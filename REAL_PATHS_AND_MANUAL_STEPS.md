# OnlineBookstore_Experiment5 — Real Paths & Manual Steps

> Generated: 2026-06-16 | Based on actual filesystem verification
> Project Root: `C:\Users\90961\Documents\Codex\2026-06-16\files-mentioned-by-the-user-c\OnlineBookstore_Experiment5`

---

## Project Identity

| Attribute | Value |
|-----------|-------|
| Root | `C:\Users\90961\Documents\Codex\2026-06-16\files-mentioned-by-the-user-c\OnlineBookstore_Experiment5` |
| Disk | C: |
| Last Modified | 2026-06-16 21:54:12 |
| File Count | 325 |
| pom.xml | YES |
| mvnw.cmd | YES |
| mvnw (Linux/Mac) | YES |
| Jenkinsfile | YES |
| src/ | YES |
| docs/ | YES |
| jira/ | YES |
| jmeter/ | YES |
| openapi/ | YES |
| evidence/ | YES |
| target/ | YES |
| JAR | `online-bookstore-1.0.0-SNAPSHOT.jar` (64,776,109 bytes, built 21:54:33) |
| JaCoCo | YES (index.html + jacoco.xml) |
| Swagger Port | 8080 |
| Swagger UI Path | /swagger-ui.html |
| API Docs Path | /v3/api-docs |

---

## 1. Critical Paths Table

| # | Item | File/Dir | Absolute Path | Exists |
|---|------|----------|---------------|--------|
| 1 | Project Root | dir | `C:\Users\90961\Documents\Codex\2026-06-16\files-mentioned-by-the-user-c\OnlineBookstore_Experiment5` | YES |
| 2 | Maven Wrapper (Win) | file | `C:\Users\90961\Documents\Codex\2026-06-16\files-mentioned-by-the-user-c\OnlineBookstore_Experiment5\mvnw.cmd` | YES |
| 3 | Maven Wrapper (Unix) | file | `C:\Users\90961\Documents\Codex\2026-06-16\files-mentioned-by-the-user-c\OnlineBookstore_Experiment5\mvnw` | YES |
| 4 | pom.xml | file | `C:\Users\90961\Documents\Codex\2026-06-16\files-mentioned-by-the-user-c\OnlineBookstore_Experiment5\pom.xml` | YES |
| 5 | Actual JAR | file | `C:\Users\90961\Documents\Codex\2026-06-16\files-mentioned-by-the-user-c\OnlineBookstore_Experiment5\target\online-bookstore-1.0.0-SNAPSHOT.jar` | YES |
| 6 | JaCoCo Index | file | `C:\Users\90961\Documents\Codex\2026-06-16\files-mentioned-by-the-user-c\OnlineBookstore_Experiment5\target\site\jacoco\index.html` | YES |
| 7 | JaCoCo XML | file | `C:\Users\90961\Documents\Codex\2026-06-16\files-mentioned-by-the-user-c\OnlineBookstore_Experiment5\target\site\jacoco\jacoco.xml` | YES |
| 8 | Jenkinsfile | file | `C:\Users\90961\Documents\Codex\2026-06-16\files-mentioned-by-the-user-c\OnlineBookstore_Experiment5\Jenkinsfile` | YES |
| 9 | README | file | `C:\Users\90961\Documents\Codex\2026-06-16\files-mentioned-by-the-user-c\OnlineBookstore_Experiment5\README.md` | YES |
| 10 | Final Report | file | `C:\Users\90961\Documents\Codex\2026-06-16\files-mentioned-by-the-user-c\OnlineBookstore_Experiment5\EXPERIMENT_FINAL_REPORT.md` | YES |
| 11 | Manual Ops Guide | file | `C:\Users\90961\Documents\Codex\2026-06-16\files-mentioned-by-the-user-c\OnlineBookstore_Experiment5\MANUAL_OPERATIONS.md` | YES |
| 12 | Delivery Checklist | file | `C:\Users\90961\Documents\Codex\2026-06-16\files-mentioned-by-the-user-c\OnlineBookstore_Experiment5\DELIVERY_CHECKLIST.md` | YES |
| 13 | API Validation Report | file | `C:\Users\90961\Documents\Codex\2026-06-16\files-mentioned-by-the-user-c\OnlineBookstore_Experiment5\docs\07-submission\API_RUNTIME_VALIDATION_REPORT.md` | YES |
| 14 | Code Coverage Report | file | `C:\Users\90961\Documents\Codex\2026-06-16\files-mentioned-by-the-user-c\OnlineBookstore_Experiment5\docs\07-submission\CODE_COVERAGE_REPORT.md` | YES |

---

## 2. Copy-Paste Ready Commands

### Enter Project
```powershell
Set-Location "C:\Users\90961\Documents\Codex\2026-06-16\files-mentioned-by-the-user-c\OnlineBookstore_Experiment5"
```

### Run Tests (30 tests, 0 failures)
```powershell
Set-Location "C:\Users\90961\Documents\Codex\2026-06-16\files-mentioned-by-the-user-c\OnlineBookstore_Experiment5"
.\mvnw.cmd clean verify
```

### Start Application
```powershell
java -jar "C:\Users\90961\Documents\Codex\2026-06-16\files-mentioned-by-the-user-c\OnlineBookstore_Experiment5\target\online-bookstore-1.0.0-SNAPSHOT.jar"
```

---

## 3. Real Access URLs (port 8080, confirmed from application.properties/yml)

| Service | URL |
|---------|-----|
| Swagger UI | http://localhost:8080/swagger-ui.html |
| OpenAPI JSON | http://localhost:8080/v3/api-docs |
| Books API | http://localhost:8080/api/books |
| H2 Console | http://localhost:8080/h2-console |

---

## 4. Human Operation Materials — Real Paths

### 4.1 Jira
| Item | Absolute Path | Exists |
|------|---------------|--------|
| Jira CSV | `C:\Users\90961\Documents\Codex\2026-06-16\files-mentioned-by-the-user-c\OnlineBookstore_Experiment5\jira\jira_import.csv` | YES |
| Jira Operation Guide | `C:\Users\90961\Documents\Codex\2026-06-16\files-mentioned-by-the-user-c\OnlineBookstore_Experiment5\jira\JIRA_OPERATION_GUIDE.md` | YES |
| Jira Tasks | `C:\Users\90961\Documents\Codex\2026-06-16\files-mentioned-by-the-user-c\OnlineBookstore_Experiment5\jira\jira_tasks.md` | YES |
| Jira Board Example | `C:\Users\90961\Documents\Codex\2026-06-16\files-mentioned-by-the-user-c\OnlineBookstore_Experiment5\jira\jira_board_example.md` | YES |

Open:
```powershell
notepad "C:\Users\90961\Documents\Codex\2026-06-16\files-mentioned-by-the-user-c\OnlineBookstore_Experiment5\jira\JIRA_OPERATION_GUIDE.md"
```

### 4.2 Visio (System Context Diagram)
| Item | Absolute Path | Exists |
|------|---------------|--------|
| Diagram Spec | `C:\Users\90961\Documents\Codex\2026-06-16\files-mentioned-by-the-user-c\OnlineBookstore_Experiment5\docs\02-system-design\SYSTEM_CONTEXT_DIAGRAM_SPEC.md` | YES |
| Visio Guide | `C:\Users\90961\Documents\Codex\2026-06-16\files-mentioned-by-the-user-c\OnlineBookstore_Experiment5\docs\02-system-design\SYSTEM_CONTEXT_DIAGRAM_VISIO_GUIDE.md` | YES |
| Image Prompt | `C:\Users\90961\Documents\Codex\2026-06-16\files-mentioned-by-the-user-c\OnlineBookstore_Experiment5\docs\02-system-design\SYSTEM_CONTEXT_IMAGE_PROMPT.md` | YES |

Open:
```powershell
notepad "C:\Users\90961\Documents\Codex\2026-06-16\files-mentioned-by-the-user-c\OnlineBookstore_Experiment5\docs\02-system-design\SYSTEM_CONTEXT_DIAGRAM_VISIO_GUIDE.md"
```

### 4.3 Requirements Review
| Item | Absolute Path | Exists |
|------|---------------|--------|
| Meeting Script | `C:\Users\90961\Documents\Codex\2026-06-16\files-mentioned-by-the-user-c\OnlineBookstore_Experiment5\docs\01-requirements\REQUIREMENT_REVIEW_MEETING_SCRIPT.md` | YES |
| Recording Guide | `C:\Users\90961\Documents\Codex\2026-06-16\files-mentioned-by-the-user-c\OnlineBookstore_Experiment5\docs\01-requirements\REQUIREMENT_REVIEW_RECORDING_GUIDE.md` | YES |
| Review Report | `C:\Users\90961\Documents\Codex\2026-06-16\files-mentioned-by-the-user-c\OnlineBookstore_Experiment5\docs\01-requirements\REQUIREMENT_REVIEW_REPORT.md` | YES |

Open:
```powershell
notepad "C:\Users\90961\Documents\Codex\2026-06-16\files-mentioned-by-the-user-c\OnlineBookstore_Experiment5\docs\01-requirements\REQUIREMENT_REVIEW_MEETING_SCRIPT.md"
```

### 4.4 Git Materials
| Item | Absolute Path | Exists |
|------|---------------|--------|
| .gitignore | `C:\Users\90961\Documents\Codex\2026-06-16\files-mentioned-by-the-user-c\OnlineBookstore_Experiment5\.gitignore` | YES |
| .gitattributes | `C:\Users\90961\Documents\Codex\2026-06-16\files-mentioned-by-the-user-c\OnlineBookstore_Experiment5\.gitattributes` | YES |
| .editorconfig | `C:\Users\90961\Documents\Codex\2026-06-16\files-mentioned-by-the-user-c\OnlineBookstore_Experiment5\.editorconfig` | YES |
| CODEOWNERS | `C:\Users\90961\Documents\Codex\2026-06-16\files-mentioned-by-the-user-c\OnlineBookstore_Experiment5\.github\CODEOWNERS` | YES |
| PR Template | `C:\Users\90961\Documents\Codex\2026-06-16\files-mentioned-by-the-user-c\OnlineBookstore_Experiment5\.github\pull_request_template.md` | YES |
| Git Script (Win) | `C:\Users\90961\Documents\Codex\2026-06-16\files-mentioned-by-the-user-c\OnlineBookstore_Experiment5\scripts\generate_git_history.bat` | YES |
| Git Script (Unix) | `C:\Users\90961\Documents\Codex\2026-06-16\files-mentioned-by-the-user-c\OnlineBookstore_Experiment5\scripts\generate_git_history.sh` | YES |

### 4.5 JMeter
| Item | Absolute Path | Exists |
|------|---------------|--------|
| NoCache Plan | `C:\Users\90961\Documents\Codex\2026-06-16\files-mentioned-by-the-user-c\OnlineBookstore_Experiment5\jmeter\online-bookstore-nocache-test.jmx` | YES |
| Redis Plan | `C:\Users\90961\Documents\Codex\2026-06-16\files-mentioned-by-the-user-c\OnlineBookstore_Experiment5\jmeter\online-bookstore-redis-cache-test.jmx` | YES |
| Run Script (Win) | `C:\Users\90961\Documents\Codex\2026-06-16\files-mentioned-by-the-user-c\OnlineBookstore_Experiment5\scripts\run_jmeter.bat` | YES |
| Run Script (Unix) | `C:\Users\90961\Documents\Codex\2026-06-16\files-mentioned-by-the-user-c\OnlineBookstore_Experiment5\scripts\run_jmeter.sh` | YES |
| JMeter README | `C:\Users\90961\Documents\Codex\2026-06-16\files-mentioned-by-the-user-c\OnlineBookstore_Experiment5\jmeter\README.md` | YES |
| Results (no-cache) | `C:\Users\90961\Documents\Codex\2026-06-16\files-mentioned-by-the-user-c\OnlineBookstore_Experiment5\jmeter\results\no-cache\` | NO (not yet run) |
| Results (redis) | `C:\Users\90961\Documents\Codex\2026-06-16\files-mentioned-by-the-user-c\OnlineBookstore_Experiment5\jmeter\results\redis-cache\` | NO (not yet run) |
| Test Report | `C:\Users\90961\Documents\Codex\2026-06-16\files-mentioned-by-the-user-c\OnlineBookstore_Experiment5\docs\04-testing\JMETER_TEST_REPORT.md` | NO (template exists) |
| Report Template | `C:\Users\90961\Documents\Codex\2026-06-16\files-mentioned-by-the-user-c\OnlineBookstore_Experiment5\docs\04-testing\JMETER_TEST_REPORT_TEMPLATE.md` | YES |

### 4.6 Jenkins
| Item | Absolute Path | Exists |
|------|---------------|--------|
| Jenkinsfile | `C:\Users\90961\Documents\Codex\2026-06-16\files-mentioned-by-the-user-c\OnlineBookstore_Experiment5\Jenkinsfile` | YES |
| Setup Guide | `C:\Users\90961\Documents\Codex\2026-06-16\files-mentioned-by-the-user-c\OnlineBookstore_Experiment5\docs\06-deployment\JENKINS_SETUP_GUIDE.md` | YES |
| CI/CD Pipeline | `C:\Users\90961\Documents\Codex\2026-06-16\files-mentioned-by-the-user-c\OnlineBookstore_Experiment5\docs\06-deployment\CI_CD_PIPELINE.md` | YES |

Open:
```powershell
notepad "C:\Users\90961\Documents\Codex\2026-06-16\files-mentioned-by-the-user-c\OnlineBookstore_Experiment5\docs\06-deployment\JENKINS_SETUP_GUIDE.md"
```

### 4.7 Evidence Directories (for saving human outputs)
```powershell
explorer "C:\Users\90961\Documents\Codex\2026-06-16\files-mentioned-by-the-user-c\OnlineBookstore_Experiment5\evidence"
explorer "C:\Users\90961\Documents\Codex\2026-06-16\files-mentioned-by-the-user-c\OnlineBookstore_Experiment5\evidence\screenshots"
explorer "C:\Users\90961\Documents\Codex\2026-06-16\files-mentioned-by-the-user-c\OnlineBookstore_Experiment5\evidence\video"
explorer "C:\Users\90961\Documents\Codex\2026-06-16\files-mentioned-by-the-user-c\OnlineBookstore_Experiment5\evidence\signatures"
explorer "C:\Users\90961\Documents\Codex\2026-06-16\files-mentioned-by-the-user-c\OnlineBookstore_Experiment5\evidence\runtime\api-validation"
```

---

## 5. Recommended Manual Operation Order

| Step | Action | Command / Path |
|------|--------|----------------|
| 1 | Enter project | `Set-Location "C:\Users\90961\Documents\Codex\2026-06-16\files-mentioned-by-the-user-c\OnlineBookstore_Experiment5"` |
| 2 | Run tests | `.\mvnw.cmd clean verify` |
| 3 | Start app | `java -jar "C:\Users\90961\Documents\Codex\2026-06-16\files-mentioned-by-the-user-c\OnlineBookstore_Experiment5\target\online-bookstore-1.0.0-SNAPSHOT.jar"` |
| 4 | Open Swagger | http://localhost:8080/swagger-ui.html |
| 5 | Open JaCoCo | Open `target\site\jacoco\index.html` in browser |
| 6 | Screenshot Swagger | Save to `evidence\screenshots\` |
| 7 | Screenshot JaCoCo | Save to `evidence\screenshots\` |
| 8 | Import Jira CSV | Open `jira\JIRA_OPERATION_GUIDE.md`, import `jira\jira_import.csv` |
| 9 | Draw Visio diagram | Open `docs\02-system-design\SYSTEM_CONTEXT_DIAGRAM_VISIO_GUIDE.md` |
| 10 | Record review video | Open `docs\01-requirements\REQUIREMENT_REVIEW_RECORDING_GUIDE.md`, save to `evidence\video\` |
| 11 | Sign review report | Print `docs\01-requirements\REQUIREMENT_REVIEW_REPORT.md`, sign, scan to `evidence\signatures\` |
| 12 | Run JMeter Phase A | Start app with `nocache` profile, run `scripts\run_jmeter.bat` Phase A |
| 13 | Run JMeter Phase B | Start Redis, start app with `redis` profile, run Phase B |
| 14 | Fill JMeter report | Copy `docs\04-testing\JMETER_TEST_REPORT_TEMPLATE.md` to `JMETER_TEST_REPORT.md`, fill results |
| 15 | Initialize Git | Run `scripts\generate_git_history.bat`, push to remote |
| 16 | Setup Jenkins | Open `docs\06-deployment\JENKINS_SETUP_GUIDE.md`, create Pipeline from `Jenkinsfile` |
| 17 | Final delivery | Review `DELIVERY_CHECKLIST.md`, ensure all items checked |

---

## 6. Missing / Abnormal Items

| # | Item | Status | Note |
|---|------|--------|------|
| 1 | `jmeter\results\no-cache\` | Missing | Directory exists but empty — JMeter Phase A not yet run |
| 2 | `jmeter\results\redis-cache\` | Missing | Directory exists but empty — JMeter Phase B not yet run |
| 3 | `docs\04-testing\JMETER_TEST_REPORT.md` | Missing | Report template exists (`JMETER_TEST_REPORT_TEMPLATE.md`) — fill after JMeter run |
| 4 | Git (software) | Not installed | Must install Git before running `generate_git_history.bat` |
| 5 | JMeter (software) | Not installed | Must install JMeter before running load tests |
| 6 | Jenkins (software) | Not installed | Must install Jenkins before creating Pipeline |
| 7 | Redis (software) | Not installed | Required for JMeter Phase B |
| 8 | MySQL (software) | Not installed | Optional profile only |

No duplicate projects found. No old copies found. This is the only `OnlineBookstore_Experiment5` on C:.

---

## 7. Quick Reference Card

```powershell
# === ENTER PROJECT ===
Set-Location "C:\Users\90961\Documents\Codex\2026-06-16\files-mentioned-by-the-user-c\OnlineBookstore_Experiment5"

# === BUILD & TEST ===
.\mvnw.cmd clean verify

# === START APP ===
java -jar "C:\Users\90961\Documents\Codex\2026-06-16\files-mentioned-by-the-user-c\OnlineBookstore_Experiment5\target\online-bookstore-1.0.0-SNAPSHOT.jar"

# === OPEN KEY GUIDES ===
notepad "C:\Users\90961\Documents\Codex\2026-06-16\files-mentioned-by-the-user-c\OnlineBookstore_Experiment5\jira\JIRA_OPERATION_GUIDE.md"
notepad "C:\Users\90961\Documents\Codex\2026-06-16\files-mentioned-by-the-user-c\OnlineBookstore_Experiment5\docs\02-system-design\SYSTEM_CONTEXT_DIAGRAM_VISIO_GUIDE.md"
notepad "C:\Users\90961\Documents\Codex\2026-06-16\files-mentioned-by-the-user-c\OnlineBookstore_Experiment5\docs\01-requirements\REQUIREMENT_REVIEW_MEETING_SCRIPT.md"
notepad "C:\Users\90961\Documents\Codex\2026-06-16\files-mentioned-by-the-user-c\OnlineBookstore_Experiment5\docs\06-deployment\JENKINS_SETUP_GUIDE.md"
notepad "C:\Users\90961\Documents\Codex\2026-06-16\files-mentioned-by-the-user-c\OnlineBookstore_Experiment5\EXPERIMENT_FINAL_REPORT.md"

# === OPEN EVIDENCE FOLDERS ===
explorer "C:\Users\90961\Documents\Codex\2026-06-16\files-mentioned-by-the-user-c\OnlineBookstore_Experiment5\evidence\screenshots"
explorer "C:\Users\90961\Documents\Codex\2026-06-16\files-mentioned-by-the-user-c\OnlineBookstore_Experiment5\evidence\video"
explorer "C:\Users\90961\Documents\Codex\2026-06-16\files-mentioned-by-the-user-c\OnlineBookstore_Experiment5\evidence\signatures"

# === URLS ===
# Swagger:     http://localhost:8080/swagger-ui.html
# OpenAPI:     http://localhost:8080/v3/api-docs
# Books API:   http://localhost:8080/api/books
# H2 Console:  http://localhost:8080/h2-console
```