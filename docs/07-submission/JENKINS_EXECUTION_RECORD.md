# Jenkins Pipeline Execution Record

> Generated: 2026-06-17 18:10:35
> Project: OnlineBookstore_Experiment5

## 1. Jenkins Environment

| Item | Value |
|------|-------|
| Jenkins Version | 2.x LTS (WAR deployment) |
| Controller Java | 21.0.11 (Microsoft OpenJDK) |
| Build Java | 17.0.18 (Eclipse Adoptium, via tools) |
| Jenkins URL | http://127.0.0.1:8090 |
| Job Name | OnlineBookstore-Experiment5-Pipeline |
| Jenkins Home | C:\JenkinsExperiment5\jenkins_home |

## 2. Repository & Branch

| Item | Value |
|------|-------|
| SCM URL | https://github.com/yueheng-rgb/OnlineBookstore_Experiment5.git |
| Build Branch | feature/git-workflow-evidence |
| Git Commit | 73eab65 (fix: remove BOM from Jenkinsfile) |
| Jenkinsfile | Jenkinsfile (root of repo) |

## 3. Pipeline Result

| Item | Value |
|------|-------|
| Build Number | #5 |
| Final Status | **SUCCESS** |
| Start Time | 2026-06-17 18:09:11 CST |
| End Time | 2026-06-17 18:09:50 CST |
| Duration | 38.7 seconds |

## 4. Stage Results

| Stage | Status | Key Output |
|-------|--------|------------|
| Declarative: Checkout SCM | SUCCESS | Cloned from feature/git-workflow-evidence |
| Declarative: Tool Install | SUCCESS | JDK-17 (C:\Program Files\Eclipse Adoptium\jdk-17.0.18.8-hotspot) |
| 1. Checkout | SUCCESS | Code checked out |
| 2. Environment Check | SUCCESS | openjdk 17.0.18, Maven Wrapper verified |
| 3. Compile | SUCCESS | 36 source files compiled |
| 4. Unit Test | SUCCESS | 30 tests run, 0 failures, 0 errors |
| 5. Comment Coverage Check | SUCCESS | Passed (>= 30% threshold) |
| 6. JaCoCo Report | SUCCESS | Generated target/site/jacoco/index.html |
| 7. Package | SUCCESS | JAR: online-bookstore-1.0.0-SNAPSHOT.jar (64 MB) |
| 8. Archive Artifacts | SUCCESS | JAR + JaCoCo reports archived |

## 5. Test & Quality Metrics

| Metric | Value |
|--------|-------|
| Tests Run | 30 |
| Failures | 0 |
| Errors | 0 |
| Skipped | 0 |
| JaCoCo Report | target/site/jacoco/index.html |
| Comment Coverage | >= 30% (passed) |
| JAR Artifact | online-bookstore-1.0.0-SNAPSHOT.jar (64.8 MB) |

## 6. Failure & Fix History

| Build # | Result | Issue | Fix |
|---------|--------|-------|-----|
| 1 | FAILURE | git.exe not found on PATH | Configured Git tool in Jenkins |
| 2 | FAILURE | BOM character in Jenkinsfile | Removed UTF-8 BOM from Jenkinsfile |
| 3 | FAILURE | BOM (same as #2, SCM cache) | Already fixed, next build succeeded |
| 4 | FAILURE | JDK 'jdk-17' tool not found | Configured JDK-17 in Jenkins tools |
| **5** | **SUCCESS** | — | — |

## 7. Evidence Files

| File | Path |
|------|------|
| Jenkins Console Log | http://127.0.0.1:8090/job/OnlineBookstore-Experiment5-Pipeline/5/console |
| Jenkins Job Page | http://127.0.0.1:8090/job/OnlineBookstore-Experiment5-Pipeline/ |
| Build #5 Page | http://127.0.0.1:8090/job/OnlineBookstore-Experiment5-Pipeline/5/ |
| JaCoCo Report | http://127.0.0.1:8090/job/OnlineBookstore-Experiment5-Pipeline/5/HTML_Report/ |

## 8. Screenshots Required (Manual)

| # | Target Page | Save As |
|---|-------------|---------|
| 17 | http://127.0.0.1:8090/job/OnlineBookstore-Experiment5-Pipeline/ | evidence/screenshots/17-jenkins-job-success.png |
| 18 | http://127.0.0.1:8090/job/OnlineBookstore-Experiment5-Pipeline/5/ (Stage View) | evidence/screenshots/18-jenkins-pipeline-stages.png |
| 19 | http://127.0.0.1:8090/job/OnlineBookstore-Experiment5-Pipeline/5/console | evidence/screenshots/19-jenkins-console-build-success.png |

## 9. Status of Other Items

- Jira: 已通过手工方式建立代表性长篇故事、故事和子任务层级；35项完整规划保留在CSV
- 需求评审视频: 已完成
- 系统上下文图: 已生成PNG和PDF，不再强制使用Visio
- JMeter: 六组独立测试已完成
- GitHub: 仓库、功能分支、PR和main分支保护已完成
- Jenkins: Pipeline实际运行成功，Build #5 SUCCESS

## Stage View Plugin Fix & Build #8

### Plugin Installation
- **Plugin**: pipeline-stage-view **v2.41**
- **Installation**: Via Plugin Manager API, safe restart
- **Status**: Active ✅

### Build #8 (with Stage View)
- **Build Number**: #8
- **Status**: SUCCESS
- **Duration**: 48.1s
- **SCM**: SSH (git@github.com:yueheng-rgb/OnlineBookstore_Experiment5.git)
- **Tests**: 30 passed, 0 failed, 0 errors
- **Stage View URL**: http://127.0.0.1:8090/job/OnlineBookstore-Experiment5-Pipeline/

### Stage View Columns
| Stage | Status | Duration |
|-------|--------|----------|
| Declarative: Checkout SCM | SUCCESS | 4.4s |
| Declarative: Tool Install | SUCCESS | 0.1s |
| 1. Checkout | SUCCESS | 4.2s |
| 2. Environment Check | SUCCESS | 0.8s |
| 3. Compile | SUCCESS | 5.3s |
| 4. Unit Test | SUCCESS | 19.4s |
| 5. Comment Coverage Check | SUCCESS | 0.4s |
| 6. JaCoCo Report | SUCCESS | 2.3s |
| 7. Package | SUCCESS | 4.4s |
| 8. Archive Artifacts | SUCCESS | 0.4s |
| Declarative: Post Actions | SUCCESS | 0.1s |

### Build History (all)
| # | Result | Key Detail |
|---|--------|------------|
| 1 | FAILURE | git.exe not found |
| 2 | FAILURE | BOM in Jenkinsfile |
| 3 | FAILURE | BOM (SCM cache) |
| 4 | FAILURE | JDK tool not configured |
| 5 | SUCCESS | First full success (HTTPS clone) |
| 6 | FAILURE | GitHub HTTPS intermittent |
| 7 | FAILURE | GitHub HTTPS intermittent |
| **8** | **SUCCESS** | **SSH clone + Stage View active** |

### Screenshots
- Stage View: http://127.0.0.1:8090/job/OnlineBookstore-Experiment5-Pipeline/
- Build #8: http://127.0.0.1:8090/job/OnlineBookstore-Experiment5-Pipeline/8/
- Console: http://127.0.0.1:8090/job/OnlineBookstore-Experiment5-Pipeline/8/console
