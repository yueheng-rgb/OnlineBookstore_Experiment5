# 质量管理计划

> 详细内容见 `../../00-project-management/02-quality-management-plan.md`

## 质量门禁

| 门禁 | 标准 | 检查方式 |
|------|------|----------|
| 编译 | mvn compile 成功 | CI Pipeline |
| 单元测试 | 全部通过 | mvn test |
| 代码覆盖率 | >= 70% | JaCoCo |
| 注释覆盖率 | >= 30% | check_comment_coverage.py |
| Code Review | >= 1人批准 | GitHub PR |
