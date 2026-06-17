# API Runtime Validation Report

## Test Environment
- **Application**: Online Bookstore v1.0.0-SNAPSHOT
- **Profile**: h2 (H2 in-memory database)
- **Port**: 8080
- **Test Date**: 2026-06-16
- **Tool**: Python urllib

## Validation Results Summary
**Passed: 15/15 (100%)**

---

## 1. GET /api/books — List All Books
| Field | Value |
|-------|-------|
| Method | GET |
| URL | /api/books |
| HTTP Status | 200 |
| Total Books | 12 (page size 10, totalElements 12) |
| Verification | Return >= 10 books |
| Result | **PASS** |

## 2. GET /api/books/1 — Get Book by ID
| Field | Value |
|-------|-------|
| Method | GET |
| URL | /api/books/1 |
| HTTP Status | 200 |
| Response | Book id=1, ISBN, title, author, price, stock, category |
| Verification | Return book with id=1 |
| Result | **PASS** |

## 3. GET /api/books/999999 — Non-existent Book
| Field | Value |
|-------|-------|
| Method | GET |
| URL | /api/books/999999 |
| HTTP Status | 404 |
| errorCode | BOOK_NOT_FOUND |
| Verification | Return 404 with errorCode |
| Result | **PASS** |

## 4. POST /api/users/register — Register User
| Field | Value |
|-------|-------|
| Method | POST |
| URL | /api/users/register |
| Request Body | `{"username":"...","password":"...","email":"..."}` |
| HTTP Status | 201 |
| Verification | Create test user |
| Result | **PASS** |

## 5. GET /api/books/1 — Stock Before Order
| Field | Value |
|-------|-------|
| Method | GET |
| URL | /api/books/1 |
| HTTP Status | 200 |
| Stock | 100 |
| Verification | Record baseline stock |
| Result | **PASS** |

## 6. POST /api/carts/{uid}/items — Add to Cart
| Field | Value |
|-------|-------|
| Method | POST |
| URL | /api/carts/4/items |
| Request Body | `{"bookId":1,"quantity":2}` |
| HTTP Status | 200 |
| Verification | Add book 1, qty 2 to cart |
| Result | **PASS** |

## 7. GET /api/carts/{uid} — View Cart
| Field | Value |
|-------|-------|
| Method | GET |
| URL | /api/carts/4 |
| HTTP Status | 200 |
| Verification | View cart with items |
| Result | **PASS** |

## 8. POST /api/orders — Create Order
| Field | Value |
|-------|-------|
| Method | POST |
| URL | /api/orders?userId=4 |
| Request Body | `{"shippingAddress":"123 Test Street, Beijing"}` |
| HTTP Status | 201 |
| Verification | Create order, deduct stock |
| Result | **PASS** |

## 9. GET /api/orders/{oid} — Get Order
| Field | Value |
|-------|-------|
| Method | GET |
| URL | /api/orders/1 |
| HTTP Status | 200 |
| Verification | Get order details |
| Result | **PASS** |

## 10. GET /api/books/1 — Stock After Order
| Field | Value |
|-------|-------|
| Method | GET |
| URL | /api/books/1 |
| HTTP Status | 200 |
| Stock | 98 (was 100, qty 2 deducted) |
| Verification | Stock decreased correctly |
| Result | **PASS** |

## 11. POST /api/orders/{oid}/cancel — Cancel Order
| Field | Value |
|-------|-------|
| Method | POST |
| URL | /api/orders/1/cancel |
| HTTP Status | 200 |
| Verification | Cancel order |
| Result | **PASS** |

## 12. GET /api/books/1 — Stock After Cancel
| Field | Value |
|-------|-------|
| Method | GET |
| URL | /api/books/1 |
| HTTP Status | 200 |
| Stock | 100 (fully restored) |
| Verification | Stock restored to original |
| Result | **PASS** |

## 13. POST /api/carts/{uid}/items — Insufficient Stock
| Field | Value |
|-------|-------|
| Method | POST |
| URL | /api/carts/4/items |
| Request Body | `{"bookId":2,"quantity":99999}` |
| HTTP Status | 400 |
| errorCode | INSUFFICIENT_STOCK |
| Verification | Fail with insufficient stock |
| Result | **PASS** |

## 14. POST /api/orders — Validation Error
| Field | Value |
|-------|-------|
| Method | POST |
| URL | /api/orders?userId=1 |
| Request Body | `{"shippingAddress":""}` |
| HTTP Status | 400 |
| errorCode | VALIDATION_FAILED |
| Verification | Fail with validation error |
| Result | **PASS** |

## 15. GET /api/orders/999999 — Non-existent Order
| Field | Value |
|-------|-------|
| Method | GET |
| URL | /api/orders/999999 |
| HTTP Status | 404 |
| errorCode | ORDER_NOT_FOUND |
| Verification | Return 404 with errorCode |
| Result | **PASS** |

---

## Error Response Format (Updated)
All error responses now follow the standardized format:
```json
{
  "timestamp": "2026-06-16T21:52:50.418821",
  "status": 404,
  "errorCode": "BOOK_NOT_FOUND",
  "message": "Book not found with id: 999999",
  "path": "/api/books/999999"
}
```
Validation errors include an additional `details` field with field-level errors.

### Error Codes
| errorCode | HTTP Status | Scenario |
|-----------|-------------|----------|
| BOOK_NOT_FOUND | 404 | Book does not exist |
| ORDER_NOT_FOUND | 404 | Order does not exist |
| USER_NOT_FOUND | 404 | User does not exist |
| CART_NOT_FOUND | 400 | Cart empty or item not found |
| INSUFFICIENT_STOCK | 400 | Stock insufficient |
| VALIDATION_FAILED | 400 | Request validation failed |
| INTERNAL_SERVER_ERROR | 500 | Unexpected server error |

## Raw Evidence
All raw request/response pairs: `evidence/runtime/api-validation/`