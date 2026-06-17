# 人工操作指南

> 本文档指导学生完成必须人工操作的实验步骤，每一步都包含具体命令、按钮名称和预期结果。

---

## 1. 如何启动在线书店项目

### 步骤
```bash
# 方式一：Maven 直接运行
cd OnlineBookstore_Experiment5
mvn spring-boot:run

# 方式二：打包后运行
mvn clean package -DskipTests
java -jar target/online-bookstore-1.0.0-SNAPSHOT.jar
```

### 预期结果
- 控制台输出 `Started OnlineBookstoreApplication`
- 访问 `http://localhost:8080/swagger-ui.html` 可看到 Swagger 界面

---

## 2. 如何验证接口

### 使用 Swagger UI
1. 打开浏览器访问：`http://localhost:8080/swagger-ui.html`
2. 展开 "图书管理" → `GET /api/books`
3. 点击 "Try it out" → "Execute"
4. 预期返回 200 状态码和图书列表 JSON

### 使用 curl
```bash
# 测试图书列表
curl http://localhost:8080/api/books

# 测试用户注册
curl -X POST http://localhost:8080/api/users/register ^
  -H "Content-Type: application/json" ^
  -d "{\"username\":\"testuser\",\"password\":\"test123456\",\"email\":\"test@test.com\"}"
```

---

## 3. 如何打开 Swagger UI 并截图

### 步骤
1. 确认应用已启动（http://localhost:8080）
2. 浏览器打开：`http://localhost:8080/swagger-ui.html`
3. 截图要求：
   - 包含页面顶部的 API 标题 "在线书店系统 API 文档"
   - 展开所有 4 个 Controller 分组（用户管理、图书管理、购物车管理、订单管理）
   - 截取全页面保存到 `evidence/screenshots/swagger-ui.png`

---

## 4. 如何导入 Jira 任务

### 步骤
1. 登录 Jira (Cloud 或 Server)
2. 进入目标项目 → 点击项目设置 (Project Settings)
3. 选择 "Import issues from CSV"
4. 选择文件：`jira/jira_import.csv`
5. 映射字段（默认通常自动匹配）：
   - Summary → Summary
   - Description → Description
   - Issue Type → Issue Type
   - Priority → Priority
   - Status → Status
6. 点击 "Begin Import"

### 预期结果
- 项目中导入 20 个任务，包含 Story 和 Task 类型

---

## 5. 如何配置 To Do、Doing、Done

### 步骤
1. 在 Jira 项目中进入 "Board" → "Configure Board"
2. 在 Columns 设置中确保有以下列：
   - To Do
   - In Progress
   - Done
3. 将导入的任务根据 Status 字段自动分配或手动拖动到对应列
4. 保存配置

---

## 6. 如何拖动任务并截图

### 步骤
1. 进入 Active Sprint 或 Kanban Board
2. 鼠标左键按住一个任务卡片（如 "JMeter压力测试"）
3. 从 "To Do" 列拖动到 "In Progress" 列
4. 释放鼠标，任务状态自动更新
5. 截取整个看板视图保存到 `evidence/screenshots/jira-board.png`

### 截图要求
- 清晰显示三列（To Do / In Progress / Done）
- 每列下的任务卡片可见标题和状态标签

---

## 7. 如何在 Visio 中绘制上下文图并导出 PDF

### 步骤
1. 打开 Microsoft Visio
2. 选择模板："基本框图" (Basic Diagram)
3. 参照 `docs/02-system-design/01-system-context-diagram.md` 中的示意图绘制：
   - 系统边界：使用大矩形框
   - 内部模块：使用圆角矩形（用户模块、图书模块、购物车模块、订单模块）
   - 外部实体：使用矩形虚线框（客户、管理员、Jenkins、Redis）
   - 数据流：使用箭头连线
4. 添加文字标签
5. 导出 PDF：文件 → 导出 → 创建 PDF/XPS
6. 保存到项目目录（如 `evidence/` 或本地桌面）

---

## 8. 如何运行 JMeter

### 前置条件
- 应用已在 `localhost:8080` 运行
- 已安装 JMeter 5.x（https://jmeter.apache.org/）

### 命令行运行
```bash
cd OnlineBookstore_Experiment5/jmeter
jmeter -n -t online-bookstore-redis-test.jmx -l results/result.jtl -e -o results/html-report
```

### GUI 运行
1. 启动 JMeter GUI：双击 `bin/jmeter.bat`（Windows）
2. File → Open → 选择 `jmeter/online-bookstore-redis-test.jmx`
3. 点击绿色三角形按钮运行
4. 查看 "Summary Report" 结果

---

## 9. 如何保存 JMeter HTML 报告

### 步骤
1. 运行上述命令行后，HTML 报告自动生成到 `jmeter/results/html-report/`
2. 打开 `jmeter/results/html-report/index.html` 查看报告
3. 如有需要，将整个 `html-report` 文件夹复制到 `evidence/performance/` 目录

---

## 10. 如何配置 Git 远程仓库

### 步骤
```bash
cd OnlineBookstore_Experiment5

# 初始化（如果尚未初始化）
git init

# 添加所有文件
git add .
git commit -m "feat: 在线书店系统实验五初始提交"

# 添加远程仓库
git remote add origin <你的GitHub/GitLab仓库地址>

# 推送到远程
git branch -M main
git push -u origin main
```

---

## 11. 如何设置 main 分支保护

### GitHub 操作
1. 进入仓库 → Settings → Branches
2. 点击 "Add branch protection rule"
3. Branch name pattern 填写：`main`
4. 勾选：
   - ☑ Require a pull request before merging
   - ☑ Require approvals (至少 1 个审查者)
   - ☑ Require status checks to pass before merging
5. 点击 "Create"
6. 截图保存到 `evidence/screenshots/git-branch.png`

---

## 12. 如何创建 Pull Request 并完成 Code Review

### 步骤
1. 创建功能分支：`git checkout -b feature/xxx`
2. 修改代码并提交：`git commit -m "feat: xxx"`
3. 推送：`git push origin feature/xxx`
4. 在 GitHub 上打开 Pull Request
5. 使用 `docs/05-quality/01-code-review-checklist.md` 模板进行审查
6. 审查通过后点击 "Merge pull request"
7. 截图保存到 `evidence/screenshots/code-review.png`

---

## 13. 如何配置 Jenkins Pipeline

### 步骤
1. 打开 Jenkins（本地或服务器）
2. 新建任务 → 选择 "Pipeline"
3. 任务名称：`online-bookstore-pipeline`
4. 在 Pipeline 配置中：
   - Definition: Pipeline script from SCM
   - SCM: Git
   - Repository URL: 你的 Git 仓库地址
   - Script Path: Jenkinsfile
5. 保存并点击 "Build Now"
6. 构建成功后截图保存到 `evidence/screenshots/jenkins-pipeline.png`

---

## 14. 如何录制 10 分钟需求评审视频

### 步骤
1. 准备会议脚本（见 `docs/01-requirements/03-requirements-review-report-template.md`）
2. 使用录屏工具（OBS Studio / 腾讯会议录制 / Zoom 录制）
3. 按脚本进行 10 分钟需求评审演示，内容包括：
   - 开场 (1 分钟)：说明评审目标和参会人员
   - 功能介绍 (3 分钟)：介绍四大模块功能
   - 技术方案 (2 分钟)：讲解技术栈选型
   - 讨论与确认 (3 分钟)：模拟团队成员提问和确认
   - 总结 (1 分钟)：确认评审结论
4. 保存视频到 `evidence/video/requirements-review-10min.mp4`

---

## 15. 如何打印或电子签署需求评审报告

### 步骤
1. 打开 `docs/01-requirements/03-requirements-review-report-template.md`
2. 打印或导出为 Word/PDF
3. 参会人员签字
4. 扫描保存到 `evidence/signatures/review-report-signed.png`

---

## 16. 所有截图分别应该截取什么内容

| 截图文件 | 内容要求 |
|----------|----------|
| `swagger-ui.png` | Swagger UI 主页，展开所有 API 分组 |
| `jira-board.png` | Jira 看板，三列状态和任务卡片 |
| `git-branch.png` | GitHub 分支保护规则设置页面 |
| `code-review.png` | Pull Request 和 Code Review 页面 |
| `jenkins-pipeline.png` | Jenkins Pipeline 构建成功页面 |
| `jaCoCo-report.png` | JaCoCo 覆盖率报告页面 |
| `jmeter-result.png` | JMeter Summary Report 结果 |
| `system-context-diagram.png` | Visio 绘制的系统上下文图 |
| `h2-console.png` | H2 数据库控制台 |

---

## 17. 最终提交时各文件应放到哪个目录

| 文件/材料 | 目标目录 |
|-----------|----------|
| 源代码和文档 | 整个 `OnlineBookstore_Experiment5/` |
| Jira 看板截图 | `evidence/screenshots/jira-board.png` |
| Swagger 截图 | `evidence/screenshots/swagger-ui.png` |
| Git 分支保护截图 | `evidence/screenshots/git-branch.png` |
| Jenkins 截图 | `evidence/screenshots/jenkins-pipeline.png` |
| JMeter 结果 | `evidence/screenshots/jmeter-result.png` |
| JaCoCo 截图 | `evidence/screenshots/jaCoCo-report.png` |
| 系统上下文图 | `evidence/screenshots/system-context-diagram.png` |
| 评审视频 | `evidence/video/requirements-review-10min.mp4` |
| 签字报告 | `evidence/signatures/review-report-signed.png` |
| JMeter HTML报告 | `evidence/performance/jmeter-html-report/` |
