package com.onlinebookstore;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Spring Boot 应用程序上下文加载测试。
 * <p>验证应用程序能够正确启动并加载所有 Bean。</p>
 */
@SpringBootTest
@DisplayName("应用程序上下文加载测试")
class OnlineBookstoreApplicationTests {

    /**
     * 测试 Spring 上下文能否正常加载。
     * 此测试验证所有 Bean 配置正确，依赖注入无循环引用。
     */
    @Test
    @DisplayName("应用程序上下文成功加载")
    void contextLoads() {
    }
}
