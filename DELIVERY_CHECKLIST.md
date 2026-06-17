# Delivery Checklist - Online Bookstore Experiment 5

## Automated (Completed by Codex)

| # | Item | Status | Evidence |
|---|------|--------|----------|
| 1 | Source code | DONE | src/main/java/ |
| 2 | Unit tests (30 tests) | DONE | 30 pass, 0 fail |
| 3 | Maven build | DONE | BUILD SUCCESS |
| 4 | JAR package | DONE | target/online-bookstore-1.0.0-SNAPSHOT.jar |
| 5 | H2 data init (12 books, 3 users) | DONE | DataInitializer.java |
| 6 | Unified error response format | DONE | ErrorResponse DTO, GlobalExceptionHandler |
| 7 | Error codes (7 codes) | DONE | BOOK_NOT_FOUND, ORDER_NOT_FOUND, etc. |
| 8 | JaCoCo coverage | DONE | 66.0% instruction, 63.5% line |
| 9 | Comment coverage | DONE | 43.8% (threshold 30%) |
| 10 | API runtime validation | DONE | 15/15 PASS (100%) |
| 11 | Stock deduction/restoration | DONE | 100->98->100 verified |
| 12 | Maven Wrapper (4 files) | DONE | mvnw, mvnw.cmd, .mvn/wrapper/* |
| 13 | JMeter 2-phase design | DONE | 2 separate JMX + run scripts |
| 14 | Jenkinsfile (8 stages) | DONE | Declarative Pipeline |
| 15 | OpenAPI spec | DONE | openapi/openapi.yaml |
| 16 | Jira CSV | DONE | jira/jira_import.csv (35 rows) |
| 17 | Final report | DONE | EXPERIMENT_FINAL_REPORT.md |
| 18 | README | DONE | Build/run instructions |
| 19 | API validation report | DONE | docs/07-submission/API_RUNTIME_VALIDATION_REPORT.md |
| 20 | Code coverage report | DONE | docs/07-submission/CODE_COVERAGE_REPORT.md |

## Manual (Requires Human Action)

| # | Item | Notes |
|---|------|-------|
| 1 | Jira import & board screenshot | Import CSV, capture board |
| 2 | Visio system context diagram | Draw, export PDF/PNG |
| 3 | 10-min requirements review video | Record review meeting |
| 4 | Signature on review report | Print, sign, scan |
| 5 | JMeter load test (2 phases) | Install JMeter, run nocache + redis |
| 6 | Git push to remote | Install Git, create GitHub/GitLab repo |
| 7 | Jenkins Pipeline execution | Install Jenkins, create and run Pipeline |
| 8 | Swagger/JaCoCo screenshots | Capture http://localhost:8080/swagger-ui.html |