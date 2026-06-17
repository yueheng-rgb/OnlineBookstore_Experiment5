package com.onlinebookstore.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 图书实体类。
 * <p>存储在线书店中的图书信息，包括书名、作者、价格、库存等核心字段。
 * 支持分页查询和缓存加速。</p>
 */
@Entity
@Table(name = "books")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Book {

    /** 图书唯一标识，自动生成 */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** ISBN 国际标准书号，不可为空，唯一 */
    @NotBlank(message = "ISBN 不能为空")
    @Column(nullable = false, unique = true, length = 20)
    private String isbn;

    /** 书名，不可为空 */
    @NotBlank(message = "书名不能为空")
    @Column(nullable = false, length = 200)
    private String title;

    /** 作者，不可为空 */
    @NotBlank(message = "作者不能为空")
    @Column(nullable = false, length = 100)
    private String author;

    /** 出版社 */
    @Column(length = 100)
    private String publisher;

    /** 图书描述 */
    @Column(length = 2000)
    private String description;

    /** 单价，不可为空，必须大于 0 */
    @NotNull(message = "价格不能为空")
    @DecimalMin(value = "0.01", message = "价格必须大于 0")
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    /** 库存数量，不可为负 */
    @Min(value = 0, message = "库存不能为负数")
    @Column(nullable = false)
    private Integer stock = 0;

    /** 图书分类 */
    @Column(length = 50)
    private String category;

    /** 封面图片 URL */
    @Column(length = 500)
    private String coverImageUrl;

    /** 记录创建时间 */
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    /** 最后更新时间 */
    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
    public String getPublisher() { return publisher; }
    public void setPublisher(String publisher) { this.publisher = publisher; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }
    public Integer getStock() { return stock; }
    public void setStock(Integer stock) { this.stock = stock; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public String getCoverImageUrl() { return coverImageUrl; }
    public void setCoverImageUrl(String coverImageUrl) { this.coverImageUrl = coverImageUrl; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
