# JMeter Pressure Test Instructions

## Purpose
Verify performance of the Online Bookstore system under different caching strategies.

## Test Files
- `online-bookstore-nocache-test.jmx`: NoCache baseline test plan (3 thread groups: 10/50/100 concurrency)
- `online-bookstore-redis-cache-test.jmx`: Redis cache test plan (3 thread groups: 10/50/100 concurrency)
- `online-bookstore-redis-test.jmx`: Original combined test plan (for reference, 6 thread groups)
- `test-data.csv`: Test data
- `results/`: Test result output directory

## Two-Phase Execution Design

### Phase A: NoCache Baseline
1. Start application: `./mvnw spring-boot:run -Dspring-boot.run.profiles=nocache` (Linux/Mac) or `.\mvnw.cmd spring-boot:run -Dspring-boot.run.profiles=nocache` (Windows)
2. Run: `jmeter -n -t online-bookstore-nocache-test.jmx -l results/no-cache/result.jtl -e -o results/no-cache/html-report`
3. Results written to: `jmeter/results/no-cache/`

### Phase B: Redis Cache
1. Start Redis server
2. Start application: `./mvnw spring-boot:run -Dspring-boot.run.profiles=redis` (Linux/Mac) or `.\mvnw.cmd spring-boot:run -Dspring-boot.run.profiles=redis` (Windows)
3. Run: `jmeter -n -t online-bookstore-redis-cache-test.jmx -l results/redis-cache/result.jtl -e -o results/redis-cache/html-report`
4. Results written to: `jmeter/results/redis-cache/`

### Automated Script
- Windows: `scripts\run_jmeter.bat`
- Linux/Mac: `scripts/run_jmeter.sh`

## Thread Groups
| Phase | Thread Group | Concurrency | Ramp-up | Loops |
|-------|-------------|-------------|---------|-------|
| NoCache | Baseline-NoCache-10 | 10 | 10s | 10 |
| NoCache | Baseline-NoCache-50 | 50 | 10s | 10 |
| NoCache | Baseline-NoCache-100 | 100 | 10s | 10 |
| Redis | RedisCache-10 | 10 | 10s | 10 |
| Redis | RedisCache-50 | 50 | 10s | 10 |
| Redis | RedisCache-100 | 100 | 10s | 10 |

## Expected Results Template

| Metric | NoCache | Redis Cache |
|--------|---------|-------------|
| Avg Response Time (ms) | [TBD] | [TBD] |
| P99 Response Time (ms) | [TBD] | [TBD] |
| Throughput (TPS) | [TBD] | [TBD] |
| Error Rate (%) | [TBD] | [TBD] |

> **Note**: Fill in results after running JMeter with actual measurements. JMeter is not installed in the current environment.

## JMeter Installation
- Download: https://jmeter.apache.org/download_jmeter.cgi
- Extract and run `bin/jmeter.bat` (Windows) or `bin/jmeter.sh` (Linux/Mac)