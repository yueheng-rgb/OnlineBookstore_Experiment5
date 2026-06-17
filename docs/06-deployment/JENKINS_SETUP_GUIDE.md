# Jenkins 配置指南

## 前置条件
- Jenkins 2.x 已安装
- 安装插件：Pipeline, JUnit, JaCoCo, HTML Publisher
- JDK 17 已配置（Jenkins → Manage Jenkins → Tools）
- Maven 已配置（或使用 Maven Wrapper）

## 配置步骤

### 1. 创建 Pipeline 任务
1. Jenkins Dashboard → New Item
2. 输入名称：online-bookstore-pipeline
3. 选择 "Pipeline"
4. 点击 OK

### 2. 配置 Pipeline
1. Pipeline → Definition: Pipeline script from SCM
2. SCM: Git
3. Repository URL: 你的Git仓库地址
4. Branch: */main
5. Script Path: Jenkinsfile
6. 保存

### 3. 触发构建
1. 点击 "Build Now"
2. 查看 Console Output
3. 构建成功后截图保存

## 预期结果
- 8个Stage全部绿色通过
- JUnit报告可查看
- JaCoCo覆盖率报告可查看
