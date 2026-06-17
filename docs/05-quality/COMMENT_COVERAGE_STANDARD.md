# 注释覆盖率标准

## 标准
- 所有公共类必须有 Javadoc 类注释
- 所有公共方法必须有 Javadoc 方法注释（含 @param/@return）
- 复杂业务逻辑必须有行内注释
- 注释覆盖率 >= 30%

## 检查方法
```bash
python scripts/check_comment_coverage.py src/main/java
```

## 当前状态
- 实测覆盖率：54.9% (已达标)

## 豁免
- Getter/Setter 可不加注释
- 简单的 Repository 方法声明可不加注释
