package com.onlinebookstore.exception;

import com.onlinebookstore.controller.BookController;
import com.onlinebookstore.controller.OrderController;
import com.onlinebookstore.service.BookService;
import com.onlinebookstore.service.OrderService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest({BookController.class, OrderController.class})
@DisplayName("GlobalExceptionHandler Integration Tests")
class GlobalExceptionHandlerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookService bookService;

    @MockBean
    private OrderService orderService;

    @Test
    @DisplayName("Book not found returns 404 with BOOK_NOT_FOUND")
    void testBookNotFound() throws Exception {
        when(bookService.getBookById(999L))
                .thenThrow(new ResourceNotFoundException("BOOK_NOT_FOUND", "Book not found with id: 999"));

        mockMvc.perform(get("/api/books/999"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.status").value(404))
                .andExpect(jsonPath("$.errorCode").value("BOOK_NOT_FOUND"))
                .andExpect(jsonPath("$.message").value("Book not found with id: 999"))
                .andExpect(jsonPath("$.timestamp").exists())
                .andExpect(jsonPath("$.path").value("/api/books/999"));
    }

    @Test
    @DisplayName("Order not found returns 404 with ORDER_NOT_FOUND")
    void testOrderNotFound() throws Exception {
        when(orderService.getOrderById(999L))
                .thenThrow(new ResourceNotFoundException("ORDER_NOT_FOUND", "Order not found with id: 999"));

        mockMvc.perform(get("/api/orders/999"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.status").value(404))
                .andExpect(jsonPath("$.errorCode").value("ORDER_NOT_FOUND"))
                .andExpect(jsonPath("$.message").value("Order not found with id: 999"))
                .andExpect(jsonPath("$.timestamp").exists())
                .andExpect(jsonPath("$.path").value("/api/orders/999"));
    }

    @Test
    @DisplayName("Insufficient stock returns 400 with INSUFFICIENT_STOCK")
    void testInsufficientStock() throws Exception {
        when(orderService.createOrder(anyLong(), any()))
                .thenThrow(new BusinessException("INSUFFICIENT_STOCK", "Book stock insufficient, current stock: 5"));

        mockMvc.perform(post("/api/orders?userId=1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"shippingAddress\":\"Test\"}"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.status").value(400))
                .andExpect(jsonPath("$.errorCode").value("INSUFFICIENT_STOCK"))
                .andExpect(jsonPath("$.message").value("Book stock insufficient, current stock: 5"))
                .andExpect(jsonPath("$.timestamp").exists())
                .andExpect(jsonPath("$.path").value("/api/orders"));
    }

    @Test
    @DisplayName("Validation failure returns 400 with VALIDATION_FAILED")
    void testValidationFailed() throws Exception {
        mockMvc.perform(post("/api/orders?userId=1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"shippingAddress\":\"\"}"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.status").value(400))
                .andExpect(jsonPath("$.errorCode").value("VALIDATION_FAILED"))
                .andExpect(jsonPath("$.message").value("Validation failed"))
                .andExpect(jsonPath("$.timestamp").exists())
                .andExpect(jsonPath("$.path").value("/api/orders"))
                .andExpect(jsonPath("$.details.shippingAddress").exists());
    }
}