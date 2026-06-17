package com.onlinebookstore.enums;

/**
 * 订单状态枚举。
 * <p>定义订单从创建到完成的生命周期状态。</p>
 */
public enum OrderStatus {
    /** 待支付 */
    PENDING,
    /** 已支付 */
    PAID,
    /** 已发货 */
    SHIPPED,
    /** 已完成 */
    COMPLETED,
    /** 已取消 */
    CANCELLED
}
