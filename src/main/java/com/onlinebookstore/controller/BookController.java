package com.onlinebookstore.controller;

import com.onlinebookstore.dto.request.BookRequest;
import com.onlinebookstore.dto.response.ApiResponse;
import com.onlinebookstore.entity.Book;
import com.onlinebookstore.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * 图书管理 REST 控制器。
 * <p>提供图书的 CRUD 操作和搜索功能。
 * 接口前缀：/api/books</p>
 */
@RestController
@RequestMapping("/api/books")
@Tag(name = "图书管理", description = "图书的增删改查和搜索接口")
public class BookController {

    private final BookService bookService;

    /**
     * 构造函数注入 BookService。
     */
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    /**
     * 创建新图书。
     * @param request 图书创建请求
     * @return 创建的图书
     */
    @PostMapping
    @Operation(summary = "添加图书", description = "向系统中添加一本新图书")
    public ResponseEntity<ApiResponse<Book>> createBook(@Valid @RequestBody BookRequest request) {
        Book book = bookService.createBook(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.success(book));
    }

    /**
     * 根据 ID 获取图书。
     */
    @GetMapping("/{id}")
    @Operation(summary = "查询图书", description = "根据 ID 获取图书详情")
    public ResponseEntity<ApiResponse<Book>> getBookById(
            @Parameter(description = "图书 ID") @PathVariable Long id) {
        Book book = bookService.getBookById(id);
        return ResponseEntity.ok(ApiResponse.success(book));
    }

    /**
     * 分页获取所有图书。
     */
    @GetMapping
    @Operation(summary = "图书列表", description = "分页获取所有图书")
    public ResponseEntity<ApiResponse<Page<Book>>> getAllBooks(
            @PageableDefault(size = 10, sort = "createdAt", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<Book> books = bookService.getAllBooks(pageable);
        return ResponseEntity.ok(ApiResponse.success(books));
    }

    /**
     * 按分类查询图书。
     */
    @GetMapping("/category/{category}")
    @Operation(summary = "按分类查询", description = "根据分类筛选图书")
    public ResponseEntity<ApiResponse<Page<Book>>> getBooksByCategory(
            @Parameter(description = "分类名称") @PathVariable String category,
            @PageableDefault(size = 10) Pageable pageable) {
        Page<Book> books = bookService.getBooksByCategory(category, pageable);
        return ResponseEntity.ok(ApiResponse.success(books));
    }

    /**
     * 按书名搜索图书。
     */
    @GetMapping("/search")
    @Operation(summary = "搜索图书", description = "按书名关键字模糊搜索图书")
    public ResponseEntity<ApiResponse<Page<Book>>> searchBooks(
            @Parameter(description = "搜索关键字") @RequestParam String keyword,
            @PageableDefault(size = 10) Pageable pageable) {
        Page<Book> books = bookService.searchBooksByTitle(keyword, pageable);
        return ResponseEntity.ok(ApiResponse.success(books));
    }

    /**
     * 更新图书信息。
     */
    @PutMapping("/{id}")
    @Operation(summary = "更新图书", description = "更新指定图书的信息")
    public ResponseEntity<ApiResponse<Book>> updateBook(
            @Parameter(description = "图书 ID") @PathVariable Long id,
            @Valid @RequestBody BookRequest request) {
        Book book = bookService.updateBook(id, request);
        return ResponseEntity.ok(ApiResponse.success(book));
    }

    /**
     * 删除图书。
     */
    @DeleteMapping("/{id}")
    @Operation(summary = "删除图书", description = "根据 ID 删除图书")
    public ResponseEntity<ApiResponse<Void>> deleteBook(
            @Parameter(description = "图书 ID") @PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.ok(ApiResponse.success("图书删除成功"));
    }
}
