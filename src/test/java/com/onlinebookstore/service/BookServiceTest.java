package com.onlinebookstore.service;

import com.onlinebookstore.dto.request.BookRequest;
import com.onlinebookstore.entity.Book;
import com.onlinebookstore.exception.BusinessException;
import com.onlinebookstore.exception.ResourceNotFoundException;
import com.onlinebookstore.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/**
 * BookService 单元测试类。
 * <p>使用 Mockito 模拟 BookRepository，验证图书服务的核心业务逻辑。</p>
 */
@ExtendWith(MockitoExtension.class)
@DisplayName("图书服务单元测试")
class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    private Book book;
    private BookRequest bookRequest;

    /**
     * 每个测试方法执行前初始化测试数据。
     */
    @BeforeEach
    void setUp() {
        book = new Book();
        book.setId(1L);
        book.setIsbn("978-7-111-11111-1");
        book.setTitle("软件工程导论");
        book.setAuthor("张海藩");
        book.setPublisher("清华大学出版社");
        book.setPrice(new BigDecimal("59.00"));
        book.setStock(100);
        book.setCategory("计算机科学");

        bookRequest = new BookRequest();
        bookRequest.setIsbn("978-7-111-11111-1");
        bookRequest.setTitle("软件工程导论");
        bookRequest.setAuthor("张海藩");
        bookRequest.setPublisher("清华大学出版社");
        bookRequest.setPrice(new BigDecimal("59.00"));
        bookRequest.setStock(100);
        bookRequest.setCategory("计算机科学");
    }

    /**
     * 测试：通过 ID 查询图书成功。
     */
    @Test
    @DisplayName("根据 ID 查询图书成功")
    void testGetBookById_Success() {
        when(bookRepository.findById(1L)).thenReturn(Optional.of(book));
        Book result = bookService.getBookById(1L);
        assertNotNull(result);
        assertEquals("软件工程导论", result.getTitle());
        assertEquals("张海藩", result.getAuthor());
        verify(bookRepository, times(1)).findById(1L);
    }

    /**
     * 测试：查询不存在的图书 ID 时抛出异常。
     */
    @Test
    @DisplayName("查询不存在的图书 ID 抛出 ResourceNotFoundException")
    void testGetBookById_NotFound() {
        when(bookRepository.findById(99L)).thenReturn(Optional.empty());
        assertThrows(ResourceNotFoundException.class, () -> bookService.getBookById(99L));
        verify(bookRepository, times(1)).findById(99L);
    }

    /**
     * 测试：创建图书成功。
     */
    @Test
    @DisplayName("创建图书成功")
    void testCreateBook_Success() {
        when(bookRepository.findByIsbn(anyString())).thenReturn(Optional.empty());
        when(bookRepository.save(any(Book.class))).thenReturn(book);
        Book result = bookService.createBook(bookRequest);
        assertNotNull(result);
        assertEquals("软件工程导论", result.getTitle());
        verify(bookRepository, times(1)).findByIsbn(bookRequest.getIsbn());
        verify(bookRepository, times(1)).save(any(Book.class));
    }

    /**
     * 测试：创建图书时 ISBN 重复抛出异常。
     */
    @Test
    @DisplayName("ISBN 重复时创建图书抛出 BusinessException")
    void testCreateBook_DuplicateIsbn() {
        when(bookRepository.findByIsbn(anyString())).thenReturn(Optional.of(book));
        assertThrows(BusinessException.class, () -> bookService.createBook(bookRequest));
        verify(bookRepository, times(1)).findByIsbn(bookRequest.getIsbn());
        verify(bookRepository, never()).save(any(Book.class));
    }

    /**
     * 测试：更新图书信息成功。
     */
    @Test
    @DisplayName("更新图书信息成功")
    void testUpdateBook_Success() {
        when(bookRepository.findById(1L)).thenReturn(Optional.of(book));
        when(bookRepository.save(any(Book.class))).thenReturn(book);
        BookRequest updateRequest = new BookRequest();
        updateRequest.setIsbn("978-7-111-11111-1");
        updateRequest.setTitle("软件工程导论（第2版）");
        updateRequest.setAuthor("张海藩");
        updateRequest.setPrice(new BigDecimal("69.00"));
        updateRequest.setStock(150);
        Book result = bookService.updateBook(1L, updateRequest);
        assertNotNull(result);
        verify(bookRepository, times(1)).findById(1L);
        verify(bookRepository, times(1)).save(any(Book.class));
    }

    /**
     * 测试：删除图书成功。
     */
    @Test
    @DisplayName("删除图书成功")
    void testDeleteBook_Success() {
        when(bookRepository.existsById(1L)).thenReturn(true);
        doNothing().when(bookRepository).deleteById(1L);
        assertDoesNotThrow(() -> bookService.deleteBook(1L));
        verify(bookRepository, times(1)).existsById(1L);
        verify(bookRepository, times(1)).deleteById(1L);
    }

    /**
     * 测试：扣减库存成功。
     */
    @Test
    @DisplayName("扣减库存成功")
    void testDeductStock_Success() {
        when(bookRepository.findById(1L)).thenReturn(Optional.of(book));
        when(bookRepository.save(any(Book.class))).thenReturn(book);
        bookService.deductStock(1L, 10);
        assertEquals(90, book.getStock());
        verify(bookRepository, times(1)).findById(1L);
        verify(bookRepository, times(1)).save(book);
    }

    /**
     * 测试：库存不足时扣减抛出异常。
     */
    @Test
    @DisplayName("库存不足时扣减抛出 BusinessException")
    void testDeductStock_InsufficientStock() {
        when(bookRepository.findById(1L)).thenReturn(Optional.of(book));
        assertThrows(BusinessException.class, () -> bookService.deductStock(1L, 999));
        verify(bookRepository, times(1)).findById(1L);
        verify(bookRepository, never()).save(any(Book.class));
    }
}
