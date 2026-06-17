# Jira 操作指南

## 1. 导入任务到 Jira

### 步骤
1. 登录 Jira Cloud 或 Jira Server
2. 进入目标项目，点击右上角 "..." → "Import issues from CSV"
3. 选择文件：`jira/jira_import.csv`
4. 映射字段：
   - Summary → Summary
   - Description → Description
   - Issue Type → Issue Type
   - Priority → Priority
   - Status → Status
5. 确认导入

## 2. 配置 Scrum Board

### 步骤
1. 进入项目 → "Boards" → "Create board"
2. 选择 "Scrum" 模板
3. 选择 "Board from an existing project"
4. 命名看板："在线书店系统 Scrum Board"
5. 配置列：To Do → In Progress → Done
6. 将导入的任务拖入对应列

## 3. 配置 Sprint

### 步骤
1. 在 Backlog 页面点击 "Create Sprint"
2. 命名 Sprint（如 "Sprint 1 - 基础架构"）
3. 将 Backlog 中的任务拖入 Sprint
4. 在 Active Sprint 页面拖动任务改变状态
5. Sprint 结束时点击 "Complete Sprint"

## 4. 如何拖动任务并截图

### 操作
1. 进入 Active Sprint 页面
2. 鼠标按住任务卡片
3. 从 To Do 列拖动到 In Progress 列
4. 任务状态自动更新
5. 使用截图工具截取整个看板视图

### 截图要求
- 【此处插入 Jira 看板截图】
- 截图需清晰显示三列状态和任务卡片内容
- 截图文件保存到 `evidence/screenshots/jira-board.png`

## 5. Jira CSV 字段说明

| 字段 | 说明 |
|------|------|
| Summary | 任务标题 |
| Description | 任务描述 |
| Issue Type | Story / Task / Bug |
| Priority | High / Medium / Low |
| Status | To Do / In Progress / Done |
| Sprint | Sprint 1 / 2 / 3 / 4 |
| Assignee | 负责人 |
| Labels | 标签（逗号分隔） |
| Story Points | 工作量估算 |
