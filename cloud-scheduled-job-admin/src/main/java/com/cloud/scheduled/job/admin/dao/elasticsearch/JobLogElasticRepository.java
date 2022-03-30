package com.cloud.scheduled.job.admin.dao.elasticsearch;

import com.cloud.scheduled.job.admin.core.model.XxlJobLog;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @description:
 * @author: zhou shuai
 * @date: 2022/2/24 19:03
 * @version: v1
 */
@Repository
public interface JobLogElasticRepository extends ElasticsearchRepository<XxlJobLog, Long> {

}
