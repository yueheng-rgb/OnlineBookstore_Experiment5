package com.onlinebookstore.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

/**
 * 购物车商品操作请求 DTO。
 * <p>用于添加或更新购物车中的商品。</p>
 */
public class CartItemRequest {

    /** 图书 ID */
    @NotNull(message = "图书 ID 不能为空")
    private Long bookId;

    /** 数量，至少为 1 */
    @NotNull(message = "数量不能为空")
    @Min(value = 1, message = "数量至少为 1")
    private Integer quantity;

    public Long getBookId() { return bookId; }
    public void setBookId(Long bookId) { this.bookId = bookId; }
    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
}
