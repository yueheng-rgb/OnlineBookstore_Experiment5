# JMeter Performance Test Report

> Generated: 2026-06-17 17:18:32
> Project: OnlineBookstore_Experiment5

## 1. Test Purpose

比较无缓存（NoCache）和 Redis 缓存两种模式在不同并发压力下对图书查询接口 GET /api/books/1 的性能表现。

## 2. Test Environment

| Item | Value |
|------|-------|
| OS | Windows 10/11 |
| Java | 17.0.18 (Eclipse Adoptium) |
| Spring Boot | 3.2.0 |
| JMeter | 5.6.3 |
| Redis | 3.0.504 (Windows native) |
| Database | H2 in-memory |
| App Port | 8080 |
| Test Interface | GET /api/books/1 |

## 3. Test Plan — Six Independent Executions

Each test was executed as a completely independent JMeter run with its own JMX file, JTL, and HTML report.

| # | Mode | Concurrency | JMX File | Ramp-up | Loops | Expected Samples |
|---|------|-------------|----------|---------|-------|-----------------|
| 1 | NoCache | 10 | independent_nocache_10.jmx | 10s | 10 | 100 |
| 2 | NoCache | 50 | independent_nocache_50.jmx | 10s | 10 | 500 |
| 3 | NoCache | 100 | independent_nocache_100.jmx | 10s | 10 | 1000 |
| 4 | Redis | 10 | independent_redis_10.jmx | 10s | 10 | 100 |
| 5 | Redis | 50 | independent_redis_50.jmx | 10s | 10 | 500 |
| 6 | Redis | 100 | independent_redis_100.jmx | 10s | 10 | 1000 |

- Each JMX file contains exactly one thread group (the other two are disabled)
- All tests hit GET /api/books/1 on localhost:8080
- Spring profiles: 
ocache,h2 for tests 1-3, edis,h2 for tests 4-6
- Redis pre-warmed via app startup + initial PING verification

## 4. Actual Results

### NoCache Mode

| Concurrency | Samples | Avg (ms) | Median (ms) | P95 (ms) | P99 (ms) | Min (ms) | Max (ms) | Throughput (req/s) | Errors |
|-------------|---------|----------|-------------|----------|----------|----------|----------|-------------------|--------|
| 10 | 100 | 3.0 | 3.0 | 5.0 | 36.0 | 1 | 36 | 11.0 | 0 |
| 50 | 500 | 2.0 | 2.0 | 4.0 | 9.0 | 0 | 41 | 50.8 | 0 |
| 100 | 1000 | 1.0 | 1.0 | 2.0 | 3.0 | 0 | 53 | 100.6 | 0 |

### Redis Cache Mode

| Concurrency | Samples | Avg (ms) | Median (ms) | P95 (ms) | P99 (ms) | Min (ms) | Max (ms) | Throughput (req/s) | Errors |
|-------------|---------|----------|-------------|----------|----------|----------|----------|-------------------|--------|
| 10 | 100 | 3.0 | 3.0 | 5.0 | 44.0 | 1 | 44 | 11.0 | 0 |
| 50 | 500 | 2.0 | 2.0 | 5.0 | 10.0 | 0 | 40 | 50.7 | 0 |
| 100 | 1000 | 1.0 | 1.0 | 2.0 | 3.0 | 0 | 57 | 100.6 | 0 |

## 5. Independent Result Files

| Test | JTL | HTML Report |
|------|-----|-------------|
| NoCache-10 | jmeter/results/nocache/10/result.jtl | jmeter/results/nocache/10/html-report/index.html |
| NoCache-50 | jmeter/results/nocache/50/result.jtl | jmeter/results/nocache/50/html-report/index.html |
| NoCache-100 | jmeter/results/nocache/100/result.jtl | jmeter/results/nocache/100/html-report/index.html |
| Redis-10 | jmeter/results/redis/10/result.jtl | jmeter/results/redis/10/html-report/index.html |
| Redis-50 | jmeter/results/redis/50/result.jtl | jmeter/results/redis/50/html-report/index.html |
| Redis-100 | jmeter/results/redis/100/result.jtl | jmeter/results/redis/100/html-report/index.html |

All 6 JTL files confirmed present, non-empty, and with correct sample counts (100/500/1000). All 6 HTML reports confirmed present.

## 6. Comparative Analysis

### Response Time
- 两组模式在 10、50、100 并发下的平均响应时间几乎完全相同（均约 3ms / 2ms / 1ms）
- 10 并发的 P99 较高（36-44ms），主要由 JPA/Hibernate 首次查询冷启动导致
- 随并发增大，平均响应时间反而降低，因为数据库连接池和 JPA 预热效果显现

### Throughput
- 吞吐量随并发线性增长：~11 → ~51 → ~101 req/s
- NoCache 和 Redis 的吞吐量差异在测量误差范围内（<1%）

### Conclusion
在本测试环境下（H2 内存数据库 + 本地单机），Redis 缓存**未显示出明显性能优势**。响应时间和吞吐量在两种模式下几乎一致。这主要是因为 H2 内存数据库本身的数据访问延迟极低（微秒级），缓存查找引入的额外网络往返开销（即使是 localhost）抵消了缓存带来的收益。在数据库访问延迟更高的环境下（如远程 MySQL/PostgreSQL），缓存可能更有价值，但需要进一步测试验证。

## 7. Risks and Limitations

- **H2 内存数据库**: 本测试的数据库访问延迟远低于典型生产环境
- **单机测试**: 所有组件在同一台机器，网络延迟可忽略
- **测试时长有限**: 每组仅 10 次循环（100-1000 样本），长时间运行可能有不同表现
- **单一接口**: 仅测试 GET /api/books/1，复杂查询或写入操作可能有不同特征
- **数据规模有限**: 12 本图书的小数据集，大数据库的缓存效果可能不同

## 8. Evidence Files

| File | Path |
|------|------|
| Summary CSV | evidence/jmeter/jmeter-performance-summary.csv |
| Environment | evidence/jmeter/environment.txt |
| Execution Record | docs/07-submission/JMETER_EXECUTION_RECORD.md |
