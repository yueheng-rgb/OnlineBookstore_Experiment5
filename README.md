# Online Bookstore System - Experiment 5

Software Project Development Phase Management — Online Bookstore System

## Tech Stack
- **Java** 17 + Spring Boot 3.2.0
- **H2** (default) / MySQL / Redis (optional profiles)
- **Maven** 3.9.5 (Wrapper)
- **JUnit 5** + Mockito + JaCoCo

## Quick Start

### Prerequisites
- JDK 17+
- (Optional) MySQL 8.0+, Redis 7.0+, JMeter 5.6+

### Build & Run (H2 Default)

**Windows:**
```bat
.\mvnw.cmd clean verify
.\mvnw.cmd spring-boot:run
```

**Linux/macOS:**
```bash
./mvnw clean verify
./mvnw spring-boot:run
```

### Access
- API: http://localhost:8080
- Swagger UI: http://localhost:8080/swagger-ui.html
- H2 Console: http://localhost:8080/h2-console (JDBC URL: `jdbc:h2:mem:online_bookstore`)

### Default Data (H2 Mode)
- **Users**: 3 (admin, reader01, booklover), password: `123456`
- **Books**: 12

### Error Response Format
All errors return standardized format:
```json
{"timestamp":"...","status":404,"errorCode":"BOOK_NOT_FOUND","message":"...","path":"/api/books/999999"}
```

## Verified Results (2026-06-16)

| Metric | Value |
|--------|-------|
| Compilation | BUILD SUCCESS |
| Unit Tests | 30 run, 0 failures |
| API Validation | 15/15 PASS (100%) |
| JaCoCo Instruction | 66.0% |
| JaCoCo Line | 63.5% |
| JaCoCo Branch | 46.6% |
| Comment Coverage | 43.8% |
| H2 Books | 12 initialized |

## API Endpoints

| Method | Path | Description |
|--------|------|-------------|
| GET | /api/books | List books (paged) |
| GET | /api/books/{id} | Get book by ID |
| POST | /api/users/register | Register user |
| POST | /api/users/login | User login |
| GET | /api/carts/{userId} | View cart |
| POST | /api/carts/{userId}/items | Add to cart |
| POST | /api/orders?userId={id} | Create order |
| GET | /api/orders/{id} | Get order |
| POST | /api/orders/{id}/cancel | Cancel order (restores stock) |

## JMeter Load Testing
Two-phase design:
1. **Phase A (NoCache)**: `spring.profiles.active=nocache`, run `online-bookstore-nocache-test.jmx`
2. **Phase B (Redis)**: Redis running, `spring.profiles.active=redis`, run `online-bookstore-redis-cache-test.jmx`

Scripts: `scripts/run_jmeter.bat` (Windows), `scripts/run_jmeter.sh` (Linux/Mac)

## Remaining Manual Tasks
- JMeter load test (JMeter not installed)
- Git remote push (Git not installed)
- Jenkins Pipeline (Jenkins not installed)
- Jira board, Visio diagram, video recording, signature