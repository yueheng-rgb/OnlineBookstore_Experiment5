# CI/CD Pipeline 文档

## Pipeline 架构

```
Git Push → Jenkins Pipeline →
  Checkout → Environment Check → Compile → Unit Test →
  Comment Coverage → JaCoCo Report → Package → Archive
```

## 阶段说明

| 阶段 | 内容 | 失败条件 |
|------|------|----------|
| Checkout | 从Git检出代码 | Git不可达 |
| Environment Check | 验证JDK 17和Maven | 版本不匹配 |
| Compile | mvn compile | 编译错误 |
| Unit Test | mvn test | 测试失败 |
| Comment Coverage | Python脚本 | 覆盖率<30% |
| JaCoCo Report | 生成覆盖率HTML | - |
| Package | mvn package -DskipTests | 打包失败 |
| Archive | 归档JAR到Jenkins | - |

## 配置文件
- `Jenkinsfile`：声明式Pipeline
