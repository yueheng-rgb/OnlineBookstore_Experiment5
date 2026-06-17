# 人工证据目录

> **说明**：此目录用于存放需要人工完成的实验证据材料。
> Codex 无法自动生成截图、视频、签字等，请按以下说明手动完成。

## 目录结构

```
evidence/
├── README.md                 ← 本文件
├── screenshots/              ← 截图存放处
│   ├── swagger-ui.png        ← Swagger UI 界面截图
│   ├── jira-board.png        ← Jira 看板截图
│   ├── git-branch.png        ← Git 分支保护截图
│   ├── jenkins-pipeline.png  ← Jenkins 构建截图
│   ├── jmeter-result.png     ← JMeter 测试结果截图
│   ├── jaCoCo-report.png     ← JaCoCo 覆盖率截图
│   └── system-context-diagram.png ← 系统上下文图截图
├── video/                    ← 视频存放处
│   └── requirements-review-10min.mp4 ← 10分钟需求评审会议录像
├── signatures/               ← 签字文件存放处
│   └── review-report-signed.png ← 签字后的需求评审报告扫描件
└── performance/              ← 性能测试报告存放处
    └── jmeter-html-report/   ← JMeter HTML 报告
```

## 截图要求

每项截图应包含：
1. **Swagger UI**：显示所有 API 分组和接口列表
2. **Jira 看板**：清晰显示 To Do、In Progress、Done 三列及任务卡片
3. **Git 分支**：显示 main 分支保护设置页面
4. **Jenkins**：显示 Pipeline 成功构建的页面
5. **JMeter**：Summary Report 结果
6. **JaCoCo**：代码覆盖率统计
