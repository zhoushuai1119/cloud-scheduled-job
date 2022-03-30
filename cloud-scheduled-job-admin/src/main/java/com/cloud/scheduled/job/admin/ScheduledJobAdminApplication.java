package com.cloud.scheduled.job.admin;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @description:
 * @author: 周帅
 * @date: 2021/1/27 19:43
 * @version: V1.0
 */
@SpringBootApplication(exclude = {DruidDataSourceAutoConfigure.class, DataSourceAutoConfiguration.class})
public class ScheduledJobAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScheduledJobAdminApplication.class, args);
    }

}