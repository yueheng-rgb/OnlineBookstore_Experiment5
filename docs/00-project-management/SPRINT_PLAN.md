# Sprint 计划

## Sprint 0：需求分析与准备 (2026-03-01 ~ 2026-03-10)

### 目标
完成需求规格说明书，通过需求评审。

### 任务清单
- [x] 编写SRS引言 (TASK-REQ-01)
- [x] 编写功能和非功能需求 (TASK-REQ-02)
- [x] 创建用户画像 (TASK-REQ-03)
- [ ] 组织需求评审会议 (TASK-REQ-04) — 需人工完成

### 交付物
- 需求规格说明书 (IEEE 830)
- 用户画像文档 (2个角色)
- 需求评审报告 + 会议视频

---

## Sprint 1：图书管理模块 (2026-03-11 ~ 2026-03-28)

### 目标
实现完整的图书管理功能。

### 任务清单
- [x] Book实体和Repository (TASK-BOOK-01)
- [x] BookService业务逻辑 (TASK-BOOK-02)
- [x] BookController和API测试 (TASK-BOOK-03)
- [x] 图书搜索和分类API (TASK-BOOK-04)

### 交付物
- 7个图书管理API端点
- 搜索和分类筛选功能
- 单元测试

---

## Sprint 2：购物车模块 (2026-04-08 ~ 2026-04-28)

### 目标
实现购物车全部功能。

### 任务清单
- [x] Cart和CartItem实体 (TASK-CART-01)
- [x] CartService添加逻辑 (TASK-CART-02)
- [x] 购物车管理操作 (TASK-CART-03)
- [x] CartController和测试 (TASK-CART-04)

### 交付物
- 5个购物车API端点
- 库存校验和单价快照
- 单元测试

---

## Sprint 3：订单模块 + 测试 (2026-04-29 ~ 2026-06-09)

### 目标
实现订单模块和测试覆盖。

### 任务清单
- [x] Order和OrderItem实体 (TASK-ORDER-01)
- [x] 订单创建核心逻辑 (TASK-ORDER-02)
- [x] 订单状态管理 (TASK-ORDER-03)
- [x] 订单取消和库存恢复 (TASK-ORDER-04)
- [x] Service层单元测试 (TASK-TEST-01)
- [x] Controller层集成测试 (TASK-TEST-02)

### 交付物
- 6个订单API端点
- 事务一致性保证
- 26个单元/集成测试用例

---

## Sprint 4：质量保证与交付 (2026-06-10 ~ 2026-06-23)

### 目标
完成压测、CI/CD和文档。

### 任务清单
- [ ] JMeter压力测试计划 (TASK-TEST-03)
- [ ] Jenkins Pipeline和Docker (TASK-TEST-04)

### 交付物
- JMeter 6组对照测试计划
- Jenkinsfile (8阶段)
- Docker Compose部署
- 完整文档
