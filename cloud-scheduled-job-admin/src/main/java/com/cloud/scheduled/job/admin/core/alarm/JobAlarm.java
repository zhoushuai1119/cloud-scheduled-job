package com.cloud.scheduled.job.admin.core.alarm;

import com.cloud.scheduled.job.admin.core.model.XxlJobInfo;
import com.cloud.scheduled.job.admin.core.model.XxlJobLog;

/**
 * @author xuxueli 2020-01-19
 */
public interface JobAlarm {

    /**
     * job alarm
     *
     * @param info
     * @param jobLog
     * @return
     */
    public boolean doAlarm(XxlJobInfo info, XxlJobLog jobLog);

}
