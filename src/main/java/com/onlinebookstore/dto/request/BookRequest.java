package com.onlinebookstore.dto.request;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;

/**
 * 图书创建/更新请求 DTO。
 * <p>接收图书信息的各个字段，包含基本校验规则。</p>
 */
public class BookRequest {

    /** ISBN */
    @NotBlank(message = "ISBN 不能为空")
    private String isbn;

    /** 书名 */
    @NotBlank(message = "书名不能为空")
    private String title;

    /** 作者 */
    @NotBlank(message = "作者不能为空")
    private String author;

    /** 出版社 */
    private String publisher;

    /** 图书描述 */
    private String description;

    /** 单价，必须大于 0 */
    @NotNull(message = "价格不能为空")
    @DecimalMin(value = "0.01", message = "价格必须大于 0")
    private BigDecimal price;

    /** 库存数量 */
    @Min(value = 0, message = "库存不能为负数")
    private Integer stock = 0;

    /** 图书分类 */
    private String category;

    /** 封面图片 URL */
    private String coverImageUrl;

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
}
