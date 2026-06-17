package com.onlinebookstore.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.math.BigDecimal;

/**
 * 订单明细实体类。
 * <p>表示订单中的单条商品记录，关联图书、数量和下单时的单价快照。</p>
 */
@Entity
@Table(name = "order_items")
public class OrderItem {

    /** 订单明细唯一标识 */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** 所属订单 */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false)
    @JsonIgnore
    private Order order;

    /** 关联图书 */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    /** 购买数量 */
    @Column(nullable = false)
    private Integer quantity;

    /** 下单时的图书单价快照 */
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal unitPrice;

    /** 此明细项的小计金额（quantity * unitPrice） */
    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal subtotal;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Order getOrder() { return order; }
    public void setOrder(Order order) { this.order = order; }
    public Book getBook() { return book; }
    public void setBook(Book book) { this.book = book; }
    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
    public BigDecimal getUnitPrice() { return unitPrice; }
    public void setUnitPrice(BigDecimal unitPrice) { this.unitPrice = unitPrice; }
    public BigDecimal getSubtotal() { return subtotal; }
    public void setSubtotal(BigDecimal subtotal) { this.subtotal = subtotal; }
}
