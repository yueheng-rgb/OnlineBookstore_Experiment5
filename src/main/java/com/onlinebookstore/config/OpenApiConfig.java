package com.onlinebookstore.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * OpenAPI / Swagger 配置类。
 * <p>配置 Swagger UI 显示的 API 文档基本信息。
 * Swagger UI 访问地址：http://localhost:8080/swagger-ui.html
 * OpenAPI JSON：http://localhost:8080/v3/api-docs</p>
 */
@Configuration
public class OpenApiConfig {

    /**
     * 自定义 OpenAPI 文档基本信息。
     * @return OpenAPI 实例
     */
    @Bean
    public OpenAPI onlineBookstoreOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("在线书店系统 API 文档")
                        .description("实验五：软件项目开发阶段管理——在线书店系统开发\n\n"
                                + "提供用户管理、图书管理、购物车管理和订单管理的 RESTful API。")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Experiment5 Team")
                                .email("experiment5@example.com"))
                        .license(new License()
                                .name("MIT")
                                .url("https://opensource.org/licenses/MIT")));
    }
}
