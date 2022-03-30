package com.cloud.scheduled.job.admin.core.constants;


/**
 * @Author： Zhou Shuai
 * @Date： 17:49 2019/1/7
 * @Description：
 * @Version: 01
 */
public class CommonConstant {

    /**
     * 定时任务发送的 TOPIC
     */
    public interface TimeTaskTopic {
        String TIME_TASK_TOPIC = "TP_F_SC";
    }

    /**
     * 定时任务回调的 TOPIC
     */
    public interface FeedBackTopic {

        String FEEDBACK_TASK_TOPIC = "TP_F_FB";

        String FEEDBACK_TASK_EVENTCODE = "EC_RESULT";
    }

    /**
     * 执行器
     */
    public interface executorHandler {
        String EXECUTOR_HANDLER = "mqJobHandler";
    }

}
