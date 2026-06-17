# Redis 技术选型与验证方案

## 1. 选型背景

在线书店系统需要在以下场景使用缓存提升性能：
- 热门图书信息查询
- 用户信息查询
- 减少数据库读压力

## 2. 技术对比

| 维度 | Redis | Memcached | 本地缓存 (ConcurrentMap) |
|------|-------|-----------|---------------------------|
| 数据结构 | 丰富（String/Hash/List/Set/ZSet） | 仅 Key-Value | Key-Value |
| 持久化 | RDB + AOF | 不支持 | 不支持 |
| 集群支持 | Redis Cluster | 客户端分片 | 不支持 |
| Spring Boot 集成 | spring-boot-starter-data-redis | 需额外配置 | 内置 |
| 性能 | 10W+ QPS | 10W+ QPS | 百万级（本地） |

## 3. 选型结论

**选择 Redis 作为分布式缓存方案**，原因：
1. Spring Boot 原生支持，集成简单
2. 数据结构丰富，支持未来扩展（排行榜、限流等）
3. 支持持久化，重启不丢失数据
4. 社区活跃，文档完善

## 4. 降级策略

当 Redis 不可用时，系统自动降级为 ConcurrentMapCacheManager 本地缓存：
- 不依赖 Redis 也能正常启动和运行
- 本地缓存提供基本性能优化
- Redis 恢复后可无缝切换

## 5. JMeter 验证方案

通过 JMeter 对比 Redis 缓存与本地缓存的性能差异：

### 测试场景
- 场景 1：直接查询数据库（无缓存）
- 场景 2：使用本地缓存
- 场景 3：使用 Redis 缓存

### 测试指标
- 平均响应时间
- P99 响应时间
- 吞吐量 (TPS)
- 错误率

详细 JMeter 测试计划见 `jmeter/online-bookstore-redis-test.jmx`。

## 6. Spring Boot 配置切换

```properties
# 使用本地缓存（默认）
spring.cache.type=simple

# 使用 Redis 缓存（需要 Redis 运行时）
spring.cache.type=redis
spring.data.redis.host=localhost
spring.data.redis.port=6379
```
