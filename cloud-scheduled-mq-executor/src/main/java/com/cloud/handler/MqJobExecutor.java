package com.cloud.handler;


import com.cloud.conf.JobHandlerThreadPool;
import com.cloud.mq.base.core.CloudMQTemplate;
import com.cloud.platform.common.response.BaseResponse;
import com.cloud.platform.common.utils.JsonUtil;
import com.cloud.platform.rocketmq.timedjob.TimeBasedJobMessage;
import com.cloud.scheduled.job.core.constants.CommonConstant;
import com.cloud.scheduled.job.core.context.XxlJobHelper;
import com.cloud.scheduled.job.core.dto.ExecutorParamsDTO;
import com.cloud.scheduled.job.core.handler.annotation.XxlJob;
import io.micrometer.core.instrument.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Objects;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: zhou shuai
 * @date: 2022/2/18 16:47
 * @version: v1
 */
@Component
@Slf4j
@EnableConfigurationProperties(JobHandlerThreadPool.class)
public class MqJobExecutor {

    private ThreadPoolExecutor mqJobExecutorPool;

    @Resource
    private JobHandlerThreadPool jobHandlerThreadPool;

    @Autowired
    private CloudMQTemplate cloudMQTemplate;

    @PostConstruct
    public void init() {
        mqJobExecutorPool = new ThreadPoolExecutor(
                jobHandlerThreadPool.getCorePoolSize(),
                jobHandlerThreadPool.getMaximumPoolSize(),
                jobHandlerThreadPool.getKeepAliveTime(),
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(50),
                new ThreadFactory() {
                    @Override
                    public Thread newThread(Runnable r) {
                        return new Thread(r, "xxl-job-admin, mqJobHandlerPool-" + r.hashCode());
                    }
                });
    }

    /**
     * 定时任务发送MQ
     */
    @XxlJob(CommonConstant.executorHandler.EXECUTOR_HANDLER)
    public void mqJobHandler() {
        log.info("mqJobExecutorPool:{}", JsonUtil.toString(jobHandlerThreadPool));
        mqJobExecutorPool.execute(() -> {
            executorMqJobTask();
        });
    }

    /**
     * 执行发送mq任务
     */
    private void executorMqJobTask() {

        String executorParams = XxlJobHelper.getJobParam();

        if (StringUtils.isBlank(executorParams)) {
            return;
        }

        log.info("executorParams:{}", executorParams);

        ExecutorParamsDTO executorParamsDTO = JsonUtil.toBean(executorParams, ExecutorParamsDTO.class);

        if (Objects.isNull(executorParamsDTO) || StringUtils.isEmpty(executorParamsDTO.getEventCode()) || Objects.isNull(executorParamsDTO.getLogId())) {
            return;
        }


        TimeBasedJobMessage timeBasedJobMessage = new TimeBasedJobMessage(executorParamsDTO.getLogId(), System.currentTimeMillis());
        BaseResponse<Object> sendResult = cloudMQTemplate.send(CommonConstant.TimeTaskTopic.TIME_TASK_TOPIC, executorParamsDTO.getEventCode(), timeBasedJobMessage);

        if (!sendResult.isSuccess()) {
            XxlJobHelper.handleFail();
        }

        XxlJobHelper.log("XXL-JOB发送RockrtMQ,Topic:{},eventCode:{},messageBody:{}", CommonConstant.TimeTaskTopic.TIME_TASK_TOPIC, executorParamsDTO.getEventCode(), JsonUtil.toString(timeBasedJobMessage));

        log.info("XXL-JOB发送RockrtMQ,Topic:{},eventCode:{},messageBody:{}", CommonConstant.TimeTaskTopic.TIME_TASK_TOPIC, executorParamsDTO.getEventCode(), JsonUtil.toString(timeBasedJobMessage));
        // default success
        XxlJobHelper.handleSuccess();
    }


}
