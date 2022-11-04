package com.cloud.scheduled.job.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @description:
 * @author: 周帅
 * @date: 2021/1/27 19:43
 * @version: V1.0
 */
@SpringBootApplication
public class ScheduledJobAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScheduledJobAdminApplication.class, args);
    }

    /**
     * 去除 discard long time none received connection 错误日志打印
     */
    static {
        System.setProperty("druid.mysql.usePingMethod","false");
    }

}
