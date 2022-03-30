package com.cloud.scheduled.job.admin.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.cloud.scheduled.job.admin.core.model.XxlJobInfo;
import com.cloud.scheduled.job.core.biz.model.ReturnT;

import java.util.Date;
import java.util.Map;

/**
 * core job action for xxl-job
 *
 * @author xuxueli 2016-5-28 15:30:33
 */
public interface XxlJobService extends IService<XxlJobInfo> {

    /**
     * page list
     *
     * @param start
     * @param length
     * @param jobGroup      执行器
     * @param triggerStatus 调度状态
     * @param systemCode    系统编码
     * @param executorParam 任务参数
     * @param author        负责人
     * @return
     */
    Map<String, Object> pageList(int start, int length, int jobGroup, int triggerStatus, String systemCode, String executorParam, String author);

    /**
     * add job
     *
     * @param jobInfo
     * @return
     */
    ReturnT<String> add(XxlJobInfo jobInfo);

    /**
     * update job
     *
     * @param jobInfo
     * @return
     */
    ReturnT<String> update(XxlJobInfo jobInfo);

    /**
     * remove job
     * *
     *
     * @param id
     * @return
     */
    ReturnT<String> remove(int id);

    /**
     * start job
     *
     * @param id
     * @return
     */
    ReturnT<String> start(int id);

    /**
     * stop job
     *
     * @param id
     * @return
     */
    ReturnT<String> stop(int id);

    /**
     * dashboard info
     *
     * @return
     */
    Map<String, Object> dashboardInfo();

    /**
     * chart info
     *
     * @param startDate
     * @param endDate
     * @return
     */
    ReturnT<Map<String, Object>> chartInfo(Date startDate, Date endDate);

}
