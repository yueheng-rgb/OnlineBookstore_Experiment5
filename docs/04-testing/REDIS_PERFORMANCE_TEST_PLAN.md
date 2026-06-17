# Redis 性能测试计划

## 测试目标
对比在线书店系统在"无缓存"和"Redis缓存"模式下的图书查询性能。

## 测试设计

| 线程组 | 并发数 | 循环次数 | 缓存模式 | Profile |
|--------|--------|----------|----------|---------|
| Baseline-NoCache-10 | 10 | 10 | 无缓存 | nocache |
| Baseline-NoCache-50 | 50 | 10 | 无缓存 | nocache |
| Baseline-NoCache-100 | 100 | 10 | 无缓存 | nocache |
| RedisCache-10 | 10 | 10 | Redis | redis |
| RedisCache-50 | 50 | 10 | Redis | redis |
| RedisCache-100 | 100 | 10 | Redis | redis |

## 测试步骤
1. 以 nocache profile 启动应用
2. 运行 Baseline 测试组
3. 停止应用
4. 以 redis profile 启动应用（需Redis运行）
5. 运行 RedisCache 测试组
6. 对比结果

## 无Redis环境
如无法运行Redis，仅运行 Baseline 组并记录预期对比。
