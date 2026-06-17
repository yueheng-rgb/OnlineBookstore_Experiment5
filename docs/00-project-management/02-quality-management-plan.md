# 质量管理计划

## 质量目标

| 指标 | 目标值 | 测量方式 |
|------|--------|----------|
| 代码注释覆盖率 | >= 30% | JaCoCo + check_comment_coverage.py |
| 单元测试覆盖率 | >= 70% | JaCoCo |
| 单元测试通过率 | 100% | mvn test |
| API 文档完整性 | 所有接口 | Swagger UI 检查 |
| Checkstyle 违规 | 0 严重违规 | mvn checkstyle |

## 代码审查流程

1. 开发人员在 feature 分支完成代码
2. 提交 Pull Request 到 main 分支
3. 至少 1 名团队成员进行 Code Review
4. 审查通过后方可合并

## Code Review 检查清单
- [ ] 代码逻辑是否正确
- [ ] 是否有适当的异常处理
- [ ] 注释是否充分（覆盖率 >= 30%）
- [ ] 是否遵循命名规范
- [ ] 是否有潜在的性能问题
- [ ] 数据库操作是否考虑了事务边界

## 测试策略

| 测试类型 | 工具 | 范围 |
|----------|------|------|
| 单元测试 | JUnit 5 + Mockito | Service 层、Controller 层 |
| 集成测试 | Spring Boot Test | 完整 API 流程 |
| 压力测试 | JMeter | Redis 缓存读写性能 |
| 代码覆盖率 | JaCoCo | 全量代码 |

## 缺陷管理
- 使用 GitHub Issues 跟踪缺陷
- 严重级别：Critical / Major / Minor
- Critical 必须在当前 Sprint 修复
