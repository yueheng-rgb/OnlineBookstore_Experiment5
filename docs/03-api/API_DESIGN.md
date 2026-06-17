# API 设计文档

> 详见 `01-api-design-overview.md` 和 `../../openapi/openapi.yaml`

## 接口总览

| 模块 | 端点前缀 | 接口数 |
|------|----------|--------|
| 用户管理 | /api/users | 6 |
| 图书管理 | /api/books | 7 |
| 购物车 | /api/carts | 5 |
| 订单管理 | /api/orders | 6 |
| **总计** | | **24** |

## 数据模型

| 实体 | 对应表 | 主要字段 |
|------|--------|----------|
| User | users | id, username, password, email, phone, address, role |
| Book | books | id, isbn, title, author, price, stock, category |
| Cart | carts | id, user_id |
| CartItem | cart_items | id, cart_id, book_id, quantity, unit_price |
| Order | orders | id, order_number, user_id, total_amount, status |
| OrderItem | order_items | id, order_id, book_id, quantity, unit_price, subtotal |
