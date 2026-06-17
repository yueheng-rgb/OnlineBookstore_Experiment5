package com.onlinebookstore.dto.request;

import jakarta.validation.constraints.NotBlank;

/**
 * 下单请求 DTO。
 * <p>接收收货地址用于从购物车创建订单。</p>
 */
public class OrderRequest {

    /** 收货地址 */
    @NotBlank(message = "收货地址不能为空")
    private String shippingAddress;

    public String getShippingAddress() { return shippingAddress; }
    public void setShippingAddress(String shippingAddress) { this.shippingAddress = shippingAddress; }
}
