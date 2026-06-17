package com.onlinebookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * 在线书店系统主启动类。
 * <p>
 * 实验五：软件项目开发阶段管理——在线书店系统开发。
 * 本系统使用 Spring Boot 3.x 构建，默认以 H2 内存数据库运行，
 * 可通过 profile 切换为 MySQL + Redis 部署模式。
 * </p>
 *
 * @author Experiment5 Team
 * @version 1.0.0
 */
@SpringBootApplication
@EnableCaching
public class OnlineBookstoreApplication {

    /**
     * 应用程序主入口。
     *
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        SpringApplication.run(OnlineBookstoreApplication.class, args);
    }
}
