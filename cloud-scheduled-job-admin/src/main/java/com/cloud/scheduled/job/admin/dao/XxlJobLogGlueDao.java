package com.cloud.scheduled.job.admin.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cloud.scheduled.job.admin.core.model.XxlJobLogGlue;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * job log for glue
 *
 * @author xuxueli 2016-5-19 18:04:56
 */
public interface XxlJobLogGlueDao extends BaseMapper<XxlJobLogGlue> {

    int save(XxlJobLogGlue xxlJobLogGlue);

    List<XxlJobLogGlue> findByJobId(@Param("jobId") int jobId);

    int removeOld(@Param("jobId") int jobId, @Param("limit") int limit);

    int deleteByJobId(@Param("jobId") int jobId);

}
