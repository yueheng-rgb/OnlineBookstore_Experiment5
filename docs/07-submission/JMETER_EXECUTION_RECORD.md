# JMeter Execution Record

> Generated: 2026-06-17 17:18:49
> Project: OnlineBookstore_Experiment5

## Environment

| Item | Value |
|------|-------|
| Java | 17.0.18 (Eclipse Adoptium) |
| Spring Boot | 3.2.0 |
| JMeter | 5.6.3 |
| Redis | 3.0.504 (Windows native) |
| App Port | 8080 |
| Test API | GET /api/books/1 |

## Execution Summary — Six Independent Runs

| # | Mode | Concurrency | Start | End | Samples | Errors | Status |
|---|------|-------------|-------|-----|---------|--------|--------|
| 1 | NoCache | 10 | 2026-06-17 17:15:44 | 2026-06-17 17:15:58 | 100 | 0 | ✅ |
| 2 | NoCache | 50 | 2026-06-17 17:15:58 | 2026-06-17 17:16:14 | 500 | 0 | ✅ |
| 3 | NoCache | 100 | 2026-06-17 17:16:14 | 2026-06-17 17:16:29 | 1000 | 0 | ✅ |
| 4 | Redis | 10 | 2026-06-17 17:17:03 | 2026-06-17 17:17:17 | 100 | 0 | ✅ |
| 5 | Redis | 50 | 2026-06-17 17:17:17 | 2026-06-17 17:17:32 | 500 | 0 | ✅ |
| 6 | Redis | 100 | 2026-06-17 17:17:32 | 2026-06-17 17:17:47 | 1000 | 0 | ✅ |

## Independent JMX Files

Each test used its own JMX file with exactly one thread group enabled:

| Test | JMX File |
|------|----------|
| NoCache-10 | jmeter/independent_nocache_10.jmx |
| NoCache-50 | jmeter/independent_nocache_50.jmx |
| NoCache-100 | jmeter/independent_nocache_100.jmx |
| Redis-10 | jmeter/independent_redis_10.jmx |
| Redis-50 | jmeter/independent_redis_50.jmx |
| Redis-100 | jmeter/independent_redis_100.jmx |

## App Start Commands

**NoCache mode (tests 1-3):**
`
java -jar target/online-bookstore-1.0.0-SNAPSHOT.jar --spring.profiles.active=nocache,h2
`
- PID: 10748

**Redis mode (tests 4-6):**
`
C:\Program Files\Redis\redis-server.exe
`
- Redis PID: 12976

`
java -jar target/online-bookstore-1.0.0-SNAPSHOT.jar --spring.profiles.active=redis,h2
`
- App PID: 18808

## Individual JMeter Commands

Test parameters: -JBASE_URL=localhost -JPORT=8080, Ramp-up=10s, Loops=10.

`
#1: jmeter -n -t jmeter/independent_nocache_10.jmx  -l jmeter/results/nocache/10/result.jtl  -e -o jmeter/results/nocache/10/html-report  -j jmeter/results/nocache/10/jmeter.log
#2: jmeter -n -t jmeter/independent_nocache_50.jmx  -l jmeter/results/nocache/50/result.jtl  -e -o jmeter/results/nocache/50/html-report  -j jmeter/results/nocache/50/jmeter.log
#3: jmeter -n -t jmeter/independent_nocache_100.jmx -l jmeter/results/nocache/100/result.jtl -e -o jmeter/results/nocache/100/html-report -j jmeter/results/nocache/100/jmeter.log
#4: jmeter -n -t jmeter/independent_redis_10.jmx   -l jmeter/results/redis/10/result.jtl   -e -o jmeter/results/redis/10/html-report   -j jmeter/results/redis/10/jmeter.log
#5: jmeter -n -t jmeter/independent_redis_50.jmx   -l jmeter/results/redis/50/result.jtl   -e -o jmeter/results/redis/50/html-report   -j jmeter/results/redis/50/jmeter.log
#6: jmeter -n -t jmeter/independent_redis_100.jmx  -l jmeter/results/redis/100/result.jtl  -e -o jmeter/results/redis/100/html-report  -j jmeter/results/redis/100/jmeter.log
`

Each test directory also contains command.txt with per-run metadata and environment.txt.

## Cleanup

- NoCache app stopped (PID 10748)
- Redis server stopped (PID 12976)
- Redis app stopped (PID 18808)
- No residual processes

## Screenshots Required (Manual)

1. **NoCache 100并发**: jmeter/results/nocache/100/html-report/index.html → evidence/screenshots/14-jmeter-nocache-100-report.png
2. **Redis 100并发**: jmeter/results/redis/100/html-report/index.html → evidence/screenshots/15-jmeter-redis-100-report.png
3. **对比汇总**: docs/04-testing/JMETER_PERFORMANCE_TEST_REPORT.md → evidence/screenshots/16-jmeter-performance-comparison.png

## Jira Status

Jira已采用手工建立代表性长篇故事、故事和子任务层级的方式完成证据展示，完整35项任务保留在CSV中作为规划材料。
