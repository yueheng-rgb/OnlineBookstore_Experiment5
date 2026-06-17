# JMeter Performance Test Report

> Generated: 2026-06-17 17:10:03
> Project: OnlineBookstore_Experiment5

## 1. Test Purpose

比较无缓存（NoCache）和 Redis 缓存两种模式在不同并发压力下对图书查询接口 GET /api/books/1 的性能表现。

## 2. Test Environment

| Item | Value |
|------|-------|
| OS | Windows 10/11 |
| Java | 17.0.18 (Eclipse Adoptium) |
| Spring Boot | 3.x |
| JMeter | 5.6.3 |
| Redis | 3.0.504 (Windows native) |
| Database | H2 in-memory |
| App Port | 8080 |
| Test Interface | GET /api/books/1 |
| JMX (NoCache) | jmeter/online-bookstore-nocache-test.jmx |
| JMX (Redis) | jmeter/online-bookstore-redis-cache-test.jmx |

## 3. Test Plan

Six formal tests across two modes:

| # | Mode | Concurrency | Ramp-up | Loops | Expected Samples |
|---|------|-------------|---------|-------|-----------------|
| 1 | NoCache | 10 | 10s | 10 | 100 |
| 2 | NoCache | 50 | 10s | 10 | 500 |
| 3 | NoCache | 100 | 10s | 10 | 1000 |
| 4 | Redis | 10 | 10s | 10 | 100 |
| 5 | Redis | 50 | 10s | 10 | 500 |
| 6 | Redis | 100 | 10s | 10 | 1000 |

- Thread groups execute sequentially (TestPlan.serialize_threadgroups=true)
- All tests hit the same endpoint with identical parameters
- Tests run on same machine, no other heavy processes during testing

## 4. Actual Results

| Test Group | Concurrency | Samples | Avg (ms) | Min (ms) | Max (ms) | P95 (ms) | P99 (ms) | Throughput (req/s) | Errors | Error Rate |
|------------|-------------|---------|----------|----------|----------|----------|----------|-------------------|--------|-----------|
| NoCache-10 | 10 | 100 | 4.13 | 1 | 39 | 7 | 39 | 11.28 | 0 | 0% |
| NoCache-50 | 50 | 500 | 2.03 | 0 | 13 | 4 | 6 | 50.94 | 0 | 0% |
| NoCache-100 | 100 | 1000 | 1.01 | 0 | 7 | 2 | 3 | 100.93 | 0 | 0% |
| Redis-10 | 10 | 100 | 3.98 | 2 | 41 | 5 | 41 | 11.27 | 0 | 0% |
| Redis-50 | 50 | 500 | 2.38 | 0 | 28 | 4 | 6 | 50.95 | 0 | 0% |
| Redis-100 | 100 | 1000 | 1.20 | 0 | 8 | 3 | 4 | 100.86 | 0 | 0% |

## 5. Comparative Analysis

### Response Time
- **10并发**: NoCache 4.13ms vs Redis 3.98ms — 几乎相同（差异约 3.6%）
- **50并发**: NoCache 2.03ms vs Redis 2.38ms — Redis 略慢（+17%），可能是缓存查找开销
- **100并发**: NoCache 1.01ms vs Redis 1.20ms — Redis 略慢（+19%），缓存开销在高并发下仍存在

### Throughput
- NoCache: 11.28 → 50.94 → 100.93 req/s（随并发线性增长）
- Redis: 11.27 → 50.95 → 100.86 req/s（几乎与 NoCache 相同）

### P95/P99 Latency
- 两组模式 P95/P99 均在个位数毫秒级别
- 10 并发的 P99 较高（39ms/41ms），主要由 JPA/Hibernate 首次查询冷启动导致
- 高并发下 P99 更低，因为数据库连接池预热完成

### Conclusion
**Redis 缓存在本测试中未显示性能优势。** 原因：
1. H2 内存数据库响应极快（<1ms），数据库查询本身不是瓶颈
2. Redis 缓存查找需要网络往返（虽然 localhost），引入额外延迟
3. 在 H2 环境下，缓存反而增加了响应时间（+17%~+19%）
4. 错误率均为 0%，两种模式均稳定

如果使用 MySQL/PostgreSQL 等远程数据库，Redis 缓存的收益会更加明显。

## 6. Risks and Limitations

- **H2 vs MySQL**: 本测试使用 H2 内存数据库，无法反映生产环境远程数据库的性能特征
- **单机测试**: 应用、数据库、JMeter、Redis 均在同一台机器上，网络延迟可以忽略
- **测试时长**: 每组仅 10 次循环，测试样本有限
- **缓存预热**: Redis 首次查询包含缓存未命中（cache miss）的写入开销
- **数据规模**: 仅测试单一接口 /api/books/1，未涉及复杂查询

## 7. Result Files

| File | Path |
|------|------|
| NoCache JTL | jmeter/results/nocache/result.jtl |
| NoCache HTML Report | jmeter/results/nocache/html-report/index.html |
| Redis JTL | jmeter/results/redis/result.jtl |
| Redis HTML Report | jmeter/results/redis/html-report/index.html |
| Summary CSV | evidence/jmeter/jmeter-performance-summary.csv |
| Environment | evidence/jmeter/environment.txt |

