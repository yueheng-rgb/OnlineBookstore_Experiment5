# API 接口设计概述

## 1. API 设计原则

- RESTful 风格，资源名词复数
- 统一响应格式 (ApiResponse)
- HTTP 状态码语义化
- 分页支持 (Spring Pageable)

## 2. 统一响应格式

```json
{
  "code": 200,
  "message": "操作成功",
  "data": { },
  "timestamp": "2026-06-16T12:00:00"
}
```

## 3. HTTP 状态码使用

| 状态码 | 含义 | 使用场景 |
|--------|------|----------|
| 200 | OK | 查询成功、更新成功 |
| 201 | Created | 创建资源成功 |
| 400 | Bad Request | 参数校验失败、业务异常 |
| 404 | Not Found | 资源不存在 |
| 500 | Internal Server Error | 服务器内部错误 |

## 4. 接口列表

### 用户管理 `/api/users`

| 方法 | 路径 | 说明 |
|------|------|------|
| POST | /api/users/register | 用户注册 |
| POST | /api/users/login | 用户登录 |
| GET | /api/users/{id} | 查询用户 |
| GET | /api/users | 用户列表（分页） |
| PUT | /api/users/{id} | 更新用户 |
| DELETE | /api/users/{id} | 删除用户 |

### 图书管理 `/api/books`

| 方法 | 路径 | 说明 |
|------|------|------|
| POST | /api/books | 添加图书 |
| GET | /api/books/{id} | 查询图书 |
| GET | /api/books | 图书列表（分页） |
| GET | /api/books/category/{category} | 按分类查询 |
| GET | /api/books/search?keyword= | 搜索图书 |
| PUT | /api/books/{id} | 更新图书 |
| DELETE | /api/books/{id} | 删除图书 |

### 购物车 `/api/carts`

| 方法 | 路径 | 说明 |
|------|------|------|
| GET | /api/carts/{userId} | 查看购物车 |
| POST | /api/carts/{userId}/items | 添加商品 |
| PUT | /api/carts/{userId}/items/{itemId} | 更新数量 |
| DELETE | /api/carts/{userId}/items/{itemId} | 移除商品 |
| DELETE | /api/carts/{userId} | 清空购物车 |

### 订单管理 `/api/orders`

| 方法 | 路径 | 说明 |
|------|------|------|
| POST | /api/orders?userId= | 创建订单 |
| GET | /api/orders/{id} | 查询订单 |
| GET | /api/orders/user/{userId} | 用户订单列表 |
| GET | /api/orders | 所有订单（管理员） |
| PUT | /api/orders/{id}/status | 更新状态 |
| POST | /api/orders/{id}/cancel | 取消订单 |

## 5. Swagger 文档

- Swagger UI：`http://localhost:8080/swagger-ui.html`
- OpenAPI JSON：`http://localhost:8080/v3/api-docs`
- OpenAPI YAML 导出：`openapi/openapi.yaml`
