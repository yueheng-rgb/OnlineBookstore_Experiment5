package com.onlinebookstore.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.onlinebookstore.dto.request.BookRequest;
import com.onlinebookstore.entity.Book;
import com.onlinebookstore.service.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * BookController 集成测试（Web 层）。
 * <p>使用 MockMvc 模拟 HTTP 请求测试控制器行为。</p>
 */
@WebMvcTest(BookController.class)
@DisplayName("图书控制器集成测试")
class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private BookService bookService;

    private Book book;

    /**
     * 初始化测试图书数据。
     */
    @BeforeEach
    void setUp() {
        book = new Book();
        book.setId(1L);
        book.setIsbn("978-7-111-11111-1");
        book.setTitle("软件工程导论");
        book.setAuthor("张海藩");
        book.setPrice(new BigDecimal("59.00"));
        book.setStock(100);
    }

    /**
     * 测试：GET /api/books/{id} 返回图书详情。
     */
    @Test
    @DisplayName("GET 查询图书返回 200 和 JSON")
    void testGetBookById() throws Exception {
        when(bookService.getBookById(1L)).thenReturn(book);
        mockMvc.perform(get("/api/books/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200))
                .andExpect(jsonPath("$.data.title").value("软件工程导论"))
                .andExpect(jsonPath("$.data.author").value("张海藩"));
    }

    /**
     * 测试：POST /api/books 创建图书返回 201。
     */
    @Test
    @DisplayName("POST 创建图书返回 201")
    void testCreateBook() throws Exception {
        BookRequest request = new BookRequest();
        request.setIsbn("978-7-111-99999-9");
        request.setTitle("新书");
        request.setAuthor("新作者");
        request.setPrice(new BigDecimal("39.00"));
        request.setStock(50);

        when(bookService.createBook(any(BookRequest.class))).thenReturn(book);

        mockMvc.perform(post("/api/books")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.code").value(200));
    }

    /**
     * 测试：POST /api/books 缺少必填字段返回 400。
     */
    @Test
    @DisplayName("创建图书缺少 ISBN 返回 400")
    void testCreateBook_ValidationError() throws Exception {
        BookRequest request = new BookRequest();
        request.setTitle("新书");
        // 缺少 isbn、author、price

        mockMvc.perform(post("/api/books")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isBadRequest());
    }

    /**
     * 测试：DELETE /api/books/{id} 删除图书返回 200。
     */
    @Test
    @DisplayName("DELETE 删除图书返回 200")
    void testDeleteBook() throws Exception {
        mockMvc.perform(delete("/api/books/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
    }
}
