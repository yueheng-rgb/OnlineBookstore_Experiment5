# Experiment 5 Final Report

> Report Date: 2026-06-16
> Environment: JDK 17.0.18 (Eclipse Adoptium) + Maven 3.9.5 Wrapper + Windows 11

---

## Execution Status Legend

| Status | Meaning |
|--------|---------|
| **Verified** | Actually compiled/tested/run in JDK 17 environment |
| **Static Check** | File format/structure validated |
| **Manual Required** | Must be completed by human |
| **Env Limited** | Cannot execute due to environment constraints |

---

## Verified Results

### Compilation
- **Command**: `.\mvnw.cmd clean compile`
- **Result**: BUILD SUCCESS, all Java source files compiled

### Unit Tests
- **Command**: `.\mvnw.cmd clean test`
- **Result**: Tests run: **30**, Failures: **0**, Errors: **0**, Skipped: **0**

### Packaging
- **Command**: `.\mvnw.cmd clean package -DskipTests`
- **Result**: BUILD SUCCESS

### Application Startup
- **Profile**: h2 (H2 in-memory database)
- **Result**: Started on port 8080 in ~8 seconds

### H2 Book Initialization
- **Initializer**: DataInitializer.java (CommandLineRunner)
- **Books Seeded**: **12** (3 users + 12 books)
- **Verified**: GET /api/books returns totalElements=12

### API Business Loop Validation
All **15** validation tests passed (100%).

| # | Test | URL | Status | Result |
|---|------|-----|--------|--------|
| 1 | List books | GET /api/books | 200 | PASS |
| 2 | Get book by ID | GET /api/books/1 | 200 | PASS |
| 3 | Book not found | GET /api/books/999999 | 404 | PASS |
| 4 | Register user | POST /api/users/register | 201 | PASS |
| 5 | Stock before order | GET /api/books/1 | 200 | PASS |
| 6 | Add to cart | POST /api/carts/{uid}/items | 200 | PASS |
| 7 | View cart | GET /api/carts/{uid} | 200 | PASS |
| 8 | Create order | POST /api/orders | 201 | PASS |
| 9 | Get order | GET /api/orders/{oid} | 200 | PASS |
| 10 | Stock after order | GET /api/books/1 | 200 | PASS |
| 11 | Cancel order | POST /api/orders/{oid}/cancel | 200 | PASS |
| 12 | Stock after cancel | GET /api/books/1 | 200 | PASS |
| 13 | Insufficient stock | POST /api/carts/{uid}/items | 400 | PASS |
| 14 | Validation error | POST /api/orders?userId=1 | 400 | PASS |
| 15 | Order not found | GET /api/orders/999999 | 404 | PASS |

### Unified Error Response Format
All exceptions return standardized ErrorResponse:
```json
{"timestamp":"...","status":404,"errorCode":"BOOK_NOT_FOUND","message":"...","path":"/api/books/999999"}
```
Verified error codes: BOOK_NOT_FOUND, ORDER_NOT_FOUND, INSUFFICIENT_STOCK, VALIDATION_FAILED, USER_NOT_FOUND, CART_NOT_FOUND, INTERNAL_SERVER_ERROR.

### JaCoCo Code Coverage
- **Command**: `.\mvnw.cmd clean verify`

| Metric | Coverage % |
|--------|-----------|
| Instruction | **66.0%** |
| Branch | **46.6%** |
| Line | **63.5%** |
| Complexity | **57.5%** |
| Method | **60.1%** |
| Class | **96.6%** |

### Comment Coverage
- **Command**: `python scripts/check_comment_coverage.py src/main/java`
- **Result**: **43.8%** (threshold 30%, PASS)

### Maven Wrapper
| File | Status |
|------|--------|
| mvnw.cmd | Present |
| mvnw (Linux/Mac) | Present |
| .mvn/wrapper/maven-wrapper.jar | Present |
| .mvn/wrapper/maven-wrapper.properties | Present |

### JMeter Two-Phase Design
- `online-bookstore-nocache-test.jmx` — Baseline-NoCache-10/50/100
- `online-bookstore-redis-cache-test.jmx` — RedisCache-10/50/100
- Scripts: `scripts/run_jmeter.bat`, `scripts/run_jmeter.sh`

---

## Static Check Results
- Jira CSV: 35 rows, 17 columns
- JMeter JMX: 2 files, 3 thread groups each
- Jenkinsfile: 8-stage Declarative Pipeline
- OpenAPI YAML: openapi 3.0.3

---

## Manual Required
| # | Item |
|---|------|
| 1 | Jira import & board screenshot |
| 2 | Visio system context diagram |
| 3 | 10-min requirements review video |
| 4 | Signature on review report |
| 5 | JMeter actual load test (2 phases) |
| 6 | Git push to remote repository |
| 7 | Jenkins Pipeline execution |
| 8 | Swagger/JaCoCo screenshots |

---

## Environment-Limited
| # | Item | Reason |
|---|------|--------|
| 1 | MySQL mode | MySQL not installed |
| 2 | Redis mode | Redis not installed |
| 3 | JMeter load test | JMeter not installed |
| 4 | Git operations | Git not installed |
| 5 | Jenkins build | Jenkins not installed |