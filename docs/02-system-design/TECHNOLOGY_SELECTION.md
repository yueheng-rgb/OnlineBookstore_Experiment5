# 技术选型文档

> 详细 Redis 选型分析见 `02-redis-tech-selection.md`

## 技术栈决策

| 技术领域 | 选择 | 备选方案 | 决策理由 |
|----------|------|----------|----------|
| 后端框架 | Spring Boot 3.2.0 | Quarkus, Micronaut | 生态成熟，学习资料丰富 |
| 数据库 | H2 (默认) / MySQL | PostgreSQL, HSQLDB | H2无需安装，MySQL为生产标配 |
| 缓存 | ConcurrentMap (默认) / Redis | Caffeine, Hazelcast | Spring原生支持，降级简单 |
| 构建工具 | Maven | Gradle | 教学环境更通用 |
| API文档 | Springdoc OpenAPI | Spring REST Docs | 自动生成，Swagger UI内置 |
| 测试 | JUnit 5 + Mockito | TestNG | Spring Boot默认集成 |
| CI/CD | Jenkins Pipeline | GitHub Actions | 实验要求 |
| 压测 | Apache JMeter | Gatling | 实验要求，GUI友好 |
| 容器化 | Docker Compose | Kubernetes | 本地环境够用 |
