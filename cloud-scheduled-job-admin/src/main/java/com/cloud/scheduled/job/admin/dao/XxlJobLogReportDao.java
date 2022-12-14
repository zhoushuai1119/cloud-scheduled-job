package com.cloud.scheduled.job.admin.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cloud.scheduled.job.admin.core.model.XxlJobLogReport;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * job log
 *
 * @author xuxueli 2019-11-22
 */
public interface XxlJobLogReportDao extends BaseMapper<XxlJobLogReport> {

    int save(XxlJobLogReport xxlJobLogReport);

    int updateLogReport(XxlJobLogReport xxlJobLogReport);

    List<XxlJobLogReport> queryLogReport(@Param("triggerDayFrom") Date triggerDayFrom,
                                         @Param("triggerDayTo") Date triggerDayTo);

    XxlJobLogReport queryLogReportTotal();

}
