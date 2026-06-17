# Experimental Report Data Verification
> Generated: 2026-06-17 19:28:01
> Project: OnlineBookstore_Experiment5

## 1. Project Scale

### Java Source Files
- Main source files: 36
- Test source files: 6
- Total: 42

### By Layer
| Layer | Count | Names |
|-------|-------|-------|
| Controller | 4 | BookController, CartController, OrderController, UserController |
| Service | 4 | BookService, CartService, OrderService, UserService |
| Repository | 6 | BookRepository, CartRepository, CartItemRepository, OrderRepository, OrderItemRepository, UserRepository |
| Entity | 6 | Book, Cart, CartItem, Order, OrderItem, User |
| DTO (Request) | 5 | BookRequest, CartItemRequest, LoginRequest, OrderRequest, RegisterRequest |
| DTO (Response) | 2 | ApiResponse, ErrorResponse |
| Exception | 3 | BusinessException, GlobalExceptionHandler, ResourceNotFoundException |
| Enum | 2 | OrderStatus, UserRole |
| Config | 2 | CacheConfig, OpenApiConfig |
| Application | 1 | OnlineBookstoreApplication |
| Data Initializer | 1 | DataInitializer |

### API Endpoints (28 total)
| Controller | Endpoints |
|------------|-----------|
| BookController | 8 |
| CartController | 6 |
| OrderController | 7 |
| UserController | 7 |

## 2. JaCoCo Code Coverage
- **Source**: `C:\Users\90961\Documents\Codex\2026-06-16\files-mentioned-by-the-user-c\OnlineBookstore_Experiment5\target\site\jacoco\jacoco.xml`

| Metric | Covered | Missed | Total | Percentage |
|--------|---------|--------|-------|------------|
| INSTRUCTION | 9560 | 4955 | 14515 | 65.86% |
| BRANCH | 140 | 160 | 300 | 46.67% |
| LINE | 1909 | 1112 | 3021 | 63.19% |
| COMPLEXITY | 890 | 660 | 1550 | 57.42% |
| METHOD | 840 | 560 | 1400 | 60.0% |
| CLASS | 116 | 4 | 120 | 96.67% |

**Note**: Comment coverage (38.2%) ? JaCoCo code coverage. These are separate metrics.

## 3. Comment Coverage (Custom Script)
- **Tool**: `scripts/check_comment_coverage.py`
- **Total comment lines**: 708
- **Total code lines**: 1855
- **Comment coverage**: **38.2%**
- **Threshold**: ? 30% ? **PASSED**

## 4. Jenkins Pipeline Build #8

| Item | Value |
|------|-------|
| Jenkins Version | **2.555.3** |
| Controller Java | 21.0.11 (Microsoft OpenJDK) |
| Build Java | 17.0.18 (Eclipse Adoptium) |
| Job Name | OnlineBookstore-Experiment5-Pipeline |
| Build Number | **#8** |
| Build Status | **SUCCESS** |
| Start Time | 2026-06-17 18:27:33 CST |
| Duration | 48.1 seconds |
| Build Branch | feature/git-workflow-evidence |
| Git Commit (full) | 73eab65f3e841624be7ad9291cf51d8f0b2bcfe0 |
| Git Commit (short) | 73eab65 |
| SCM URL | git@github.com:yueheng-rgb/OnlineBookstore_Experiment5.git (SSH) |
| Tests Run | 30 |
| Failures | 0 |
| Errors | 0 |
| Skipped | 0 |
| Comment Coverage | 38.2% (PASSED) |
| JAR Artifact | online-bookstore-1.0.0-SNAPSHOT.jar |
| pipeline-stage-view | v2.41 |

### Stage Durations
| Stage | Duration |
|-------|----------|
| Declarative: Checkout SCM | 4.4s |
| Declarative: Tool Install | 0.1s |
| 1. Checkout | 4.2s |
| 2. Environment Check | 0.8s |
| 3. Compile | 5.3s |
| 4. Unit Test | 19.4s |
| 5. Comment Coverage Check | 0.4s |
| 6. JaCoCo Report | 2.3s |
| 7. Package | 4.4s |
| 8. Archive Artifacts | 0.4s |
| Declarative: Post Actions | 0.1s |

## 5. JMeter Performance Test Results

**Source**: `C:\Users\90961\Documents\Codex\2026-06-16\files-mentioned-by-the-user-c\OnlineBookstore_Experiment5\evidence\jmeter\jmeter-performance-summary.csv`

| Mode | Threads | Samples | Avg(ms) | Median(ms) | P90(ms) | P95(ms) | P99(ms) | Min(ms) | Max(ms) | TPS | Err% | RecvKB/s | SenKB/s |
|------|---------|---------|---------|------------|---------|---------|---------|---------|---------|-----|------|----------|---------|
| nocache | 10 | 100 | 3.65 | 3.0 | 5 | 5 | 36 | 1 | 36 | 11.25 | 0.0% | 6.2 | 0 |
| nocache | 50 | 500 | 2.26 | 2.0 | 4 | 4 | 5 | 0 | 41 | 51.94 | 0.0% | 28.6 | 0 |
| nocache | 100 | 1000 | 1.44 | 1.0 | 2 | 3 | 4 | 0 | 53 | 102.94 | 0.0% | 56.69 | 0 |
| redis | 10 | 100 | 3.37 | 3.0 | 4 | 5 | 44 | 1 | 44 | 11.29 | 0.0% | 6.22 | 0 |
| redis | 50 | 500 | 2.15 | 2.0 | 3 | 4 | 7 | 0 | 40 | 51.75 | 0.0% | 28.5 | 0 |
| redis | 100 | 1000 | 1.45 | 1.0 | 2 | 3 | 4 | 0 | 57 | 103.43 | 0.0% | 56.96 | 0 |

**Result files** (6 independent JTLs):
- `jmeter/results/nocache/10/result.jtl`
- `jmeter/results/nocache/50/result.jtl`
- `jmeter/results/nocache/100/result.jtl`
- `jmeter/results/redis/10/result.jtl`
- `jmeter/results/redis/50/result.jtl`
- `jmeter/results/redis/100/result.jtl`

## 6. Initial Books (H2)

- **Unique ISBNs**: 0
- **Total books initialized**: 12
- **Source**: `src/main/resources/data.sql`
- ISBNs: 

## 7. GitHub Repository Status

| Item | Value |
|------|-------|
| Repository URL | https://github.com/yueheng-rgb/OnlineBookstore_Experiment5 |
| Visibility | **PUBLIC** |
| Default Branch | main |
| Feature Branch | feature/git-workflow-evidence |
| PR Number | **#1** |
| PR Status | **OPEN** (NOT merged) |
| PR Commits | 7 |
| Files Changed | 16 |
| Additions | +1266 |
| Deletions | -5 |
| PR Title | fix: Git workflow evidence ? maven-wrapper.jar + repository status docs |

### Main Branch Protection Rules
| Rule | Value |
|------|-------|
| Require Pull Request | ? Yes (1 approval) |
| Allow Force Push | ? No |
| Allow Deletions | ? No |
| Enforce for Admins | ? Yes |
| Require Conversation Resolution | ? Yes |

## 8. Screenshots Status

- **Existing screenshots**: 0
  - **None found** ? all screenshots still need to be taken manually

### Expected Screenshot Checklist
| # | Expected File | Status |
|---|---------------|--------|
| 14 | evidence/screenshots/14-jmeter-nocache-100-report.png | ? Missing |
| 15 | evidence/screenshots/15-jmeter-redis-100-report.png | ? Missing |
| 16 | evidence/screenshots/16-jmeter-performance-comparison.png | ? Missing |
| 17 | evidence/screenshots/17-jenkins-job-success.png | ? Missing |
| 18 | evidence/screenshots/18-jenkins-pipeline-stages.png | ? Missing |
| 19 | evidence/screenshots/19-jenkins-console-build-success.png | ? Missing |

## 9. Other Materials

| Item | Status | Details |
|------|--------|---------|
| System Context Diagram (PNG) | ? Not found | Expected at docs/02-system-design/ |
| System Context Diagram (PDF) | ? Not found | Expected at docs/02-system-design/ |
| Requirement Review Video | ? Not found | evidence/video/ is empty |
| Signature Files | ? Not found | evidence/signatures/ is empty |
| API Validation Evidence | ? Present | 15 JSON files in evidence/runtime/api-validation/ |
| JMeter Evidence | ? Present | CSV + environment.txt in evidence/jmeter/ |
| Git Evidence | ? Present | repository-status.txt in evidence/git/ |

## 10. Submission Package

- **Status**: **Not yet generated**
- No ZIP submission package found
- No dedicated Submission directory found
- Expected location: `docs/07-submission/` (contains report files, but no packaged ZIP)

## 11. Top 5 Recommended Data to Supplement

1. **Screenshots**: 6 screenshots (JMeter ?3, Jenkins ?3) are missing ? capture from already-open pages
2. **System Context Diagram**: Generate PNG and PDF from project materials to docs/02-system-design/
3. **Video**: Place requirement review video in evidence/video/ (or document its external location)
4. **Signature materials**: Add signed documents to evidence/signatures/
5. **Submission ZIP**: Generate final zip package from `docs/07-submission/` after screenshots are added