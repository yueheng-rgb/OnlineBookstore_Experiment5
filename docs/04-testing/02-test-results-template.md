# 测试结果报告

> **说明**：此文件为模板，测试执行后填入实际结果。

## 单元测试结果

执行命令：
```bash
mvn clean test
```

| 测试类 | 测试数 | 通过 | 失败 | 跳过 |
|--------|--------|------|------|------|
| OnlineBookstoreApplicationTests | | | | |
| BookServiceTest | | | | |
| UserServiceTest | | | | |
| OrderServiceTest | | | | |
| BookControllerTest | | | | |

**总计**：__ 通过 / __ 失败 / __ 跳过

## 代码覆盖率 (JaCoCo)

执行命令：
```bash
mvn clean test jacoco:report
```

报告路径：`target/site/jacoco/index.html`

【此处插入 JaCoCo 覆盖率截图】

## 注释覆盖率

执行命令：
```bash
python scripts/check_comment_coverage.py
```

目标：>= 30%

【此处插入注释覆盖率统计截图或输出】
