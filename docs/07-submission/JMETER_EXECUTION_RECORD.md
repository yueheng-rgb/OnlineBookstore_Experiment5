# JMeter Execution Record

> Generated: 2026-06-17 17:10:17
> Project: OnlineBookstore_Experiment5

## Execution Summary

| # | Test | Start | End | Status | Retries |
|---|------|-------|-----|--------|---------|
| 1 | NoCache-10/50/100 | 2026-06-17 17:06:14 | 2026-06-17 17:06:49 | ✅ Success | 0 |
| 2 | Redis-10/50/100 | 2026-06-17 17:08:10 | 2026-06-17 17:08:45 | ✅ Success | 0 |

## Detailed Commands

### Test 1: NoCache Mode

**App Start:**
`
java -jar target/online-bookstore-1.0.0-SNAPSHOT.jar --spring.profiles.active=nocache,h2
`
- PID: 19100
- Port: 8080
- Startup time: ~12 seconds

**JMeter Command:**
`
jmeter -n -t jmeter/online-bookstore-nocache-test.jmx -JBASE_URL=localhost -JPORT=8080 ^
  -l jmeter/results/nocache/result.jtl -e -o jmeter/results/nocache/html-report
`
- Total samples: 1600
- Duration: ~29 seconds
- Errors: 0

### Test 2: Redis Cache Mode

**Redis Start:**
`
C:\Program Files\Redis\redis-server.exe
`
- PID: 14876
- Port: 6379
- Verified: PONG

**App Start:**
`
java -jar target/online-bookstore-1.0.0-SNAPSHOT.jar --spring.profiles.active=redis,h2
`
- PID: 15476
- Port: 8080
- Startup time: ~12 seconds

**JMeter Command:**
`
jmeter -n -t jmeter/online-bookstore-redis-cache-test.jmx -JBASE_URL=localhost -JPORT=8080 ^
  -l jmeter/results/redis/result.jtl -e -o jmeter/results/redis/html-report
`
- Total samples: 1600
- Duration: ~29 seconds
- Errors: 0

## Result Files

| File | Absolute Path |
|------|---------------|
| NoCache JTL | jmeter/results/nocache/result.jtl |
| NoCache HTML | jmeter/results/nocache/html-report/index.html |
| Redis JTL | jmeter/results/redis/result.jtl |
| Redis HTML | jmeter/results/redis/html-report/index.html |
| CSV Summary | evidence/jmeter/jmeter-performance-summary.csv |

## Screenshots Required (Manual)

以下三个 HTML 报告页面需要手动截屏：

1. **NoCache 100并发报告**
   - 文件: jmeter/results/nocache/html-report/index.html
   - 保存为: evidence/screenshots/14-jmeter-nocache-100-report.png
   - 截图区域: Dashboard 概览 + Statistics 表格

2. **Redis 100并发报告**
   - 文件: jmeter/results/redis/html-report/index.html
   - 保存为: evidence/screenshots/15-jmeter-redis-100-report.png
   - 截图区域: Dashboard 概览 + Statistics 表格

3. **性能对比汇总**
   - 保存为: evidence/screenshots/16-jmeter-performance-comparison.png
   - 截图区域: 本报告第4节的表格 + 对比分析

## Cleanup

- NoCache app stopped (PID 19100 killed)
- Redis server stopped (PID 14876 killed)
- Redis app stopped (PID 15476 killed)
- No residual Java/Redis processes

