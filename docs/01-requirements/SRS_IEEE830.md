# 软件需求规格说明书 (IEEE 830)

> 本文件为完整索引，详细内容见 `01-software-requirements-specification.md`

## IEEE 830 结构对照

| IEEE 830 章节 | 内容 | 对应文件 |
|---------------|------|----------|
| 1. 引言 | 目的、范围、定义、参考文献 | 01-software-requirements-specification.md §1 |
| 2. 总体描述 | 产品视角、用户特征、约束 | 01-software-requirements-specification.md §2 |
| 3. 具体需求 | 功能需求、非功能需求 | 01-software-requirements-specification.md §3-4 |

## 需求追踪矩阵

| 需求ID | 需求描述 | 优先级 | 对应API | 状态 |
|--------|----------|--------|---------|------|
| REQ-USER-01 | 用户注册 | High | POST /api/users/register | 已实现 |
| REQ-USER-02 | 用户登录 | High | POST /api/users/login | 已实现 |
| REQ-BOOK-01 | 图书CRUD | High | /api/books | 已实现 |
| REQ-BOOK-02 | 图书搜索 | Medium | /api/books/search | 已实现 |
| REQ-CART-01 | 购物车管理 | High | /api/carts | 已实现 |
| REQ-ORDER-01 | 订单创建 | High | /api/orders | 已实现 |
| REQ-ORDER-02 | 订单管理 | High | /api/orders | 已实现 |
