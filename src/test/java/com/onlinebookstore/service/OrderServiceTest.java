package com.onlinebookstore.service;

import com.onlinebookstore.dto.request.OrderRequest;
import com.onlinebookstore.entity.*;
import com.onlinebookstore.enums.OrderStatus;
import com.onlinebookstore.exception.BusinessException;
import com.onlinebookstore.exception.ResourceNotFoundException;
import com.onlinebookstore.repository.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("OrderService Unit Tests")
class OrderServiceTest {

    @Mock private OrderRepository orderRepository;
    @Mock private OrderItemRepository orderItemRepository;
    @Mock private CartRepository cartRepository;
    @Mock private BookService bookService;
    @Mock private CartService cartService;

    @InjectMocks
    private OrderService orderService;

    private Cart cart;
    private Book book;
    private User user;
    private CartItem cartItem;

    @BeforeEach
    void setUp() {
        user = new User();
        user.setId(1L);
        user.setUsername("testuser");

        book = new Book();
        book.setId(1L);
        book.setTitle("Test Book");
        book.setPrice(new BigDecimal("50.00"));
        book.setStock(20);

        cartItem = new CartItem();
        cartItem.setId(1L);
        cartItem.setBook(book);
        cartItem.setQuantity(2);
        cartItem.setUnitPrice(new BigDecimal("50.00"));

        List<CartItem> items = new ArrayList<>();
        items.add(cartItem);

        cart = new Cart();
        cart.setId(1L);
        cart.setUser(user);
        cart.setCartItems(items);
        cartItem.setCart(cart);
    }

    @Test
    @DisplayName("Create order from cart success")
    void testCreateOrder_Success() {
        OrderRequest request = new OrderRequest();
        request.setShippingAddress("Beijing Haidian");

        when(cartRepository.findByUserId(1L)).thenReturn(Optional.of(cart));
        when(orderRepository.save(any(Order.class))).thenAnswer(inv -> {
            Order o = inv.getArgument(0);
            o.setId(1L);
            return o;
        });
        doNothing().when(bookService).deductStock(anyLong(), anyInt());
        doNothing().when(cartService).clearCart(anyLong());

        Order result = orderService.createOrder(1L, request);
        assertNotNull(result);
        assertEquals(OrderStatus.PENDING, result.getStatus());
        assertEquals("Beijing Haidian", result.getShippingAddress());
        assertNotNull(result.getOrderNumber());
        verify(bookService, times(1)).deductStock(1L, 2);
        verify(cartService, times(1)).clearCart(1L);
    }

    @Test
    @DisplayName("Create order fails with empty cart")
    void testCreateOrder_EmptyCart() {
        when(cartRepository.findByUserId(1L)).thenReturn(Optional.empty());
        OrderRequest request = new OrderRequest();
        request.setShippingAddress("Beijing Haidian");
        assertThrows(BusinessException.class, () -> orderService.createOrder(1L, request));
    }

    @Test
    @DisplayName("Get order by ID success")
    void testGetOrderById_Success() {
        Order order = new Order();
        order.setId(1L);
        order.setOrderNumber("ORD-20260616-000001");
        order.setStatus(OrderStatus.PENDING);
        when(orderRepository.findById(1L)).thenReturn(Optional.of(order));
        Order result = orderService.getOrderById(1L);
        assertNotNull(result);
        assertEquals("ORD-20260616-000001", result.getOrderNumber());
    }

    @Test
    @DisplayName("Get order by ID not found")
    void testGetOrderById_NotFound() {
        when(orderRepository.findById(99L)).thenReturn(Optional.empty());
        assertThrows(ResourceNotFoundException.class, () -> orderService.getOrderById(99L));
    }

    @Test
    @DisplayName("Cancel order success and restore stock via BookService")
    void testCancelOrder_Success() {
        Order order = new Order();
        order.setId(1L);
        order.setStatus(OrderStatus.PENDING);
        OrderItem item = new OrderItem();
        item.setBook(book);
        item.setQuantity(2);
        order.addOrderItem(item);

        when(orderRepository.findById(1L)).thenReturn(Optional.of(order));
        when(orderRepository.save(any(Order.class))).thenReturn(order);
        doNothing().when(bookService).restoreStock(anyLong(), anyInt());

        Order result = orderService.cancelOrder(1L);
        assertEquals(OrderStatus.CANCELLED, result.getStatus());
        verify(bookService, times(1)).restoreStock(1L, 2);
    }

    @Test
    @DisplayName("Cancel completed order throws BusinessException")
    void testCancelOrder_AlreadyCompleted() {
        Order order = new Order();
        order.setId(1L);
        order.setStatus(OrderStatus.COMPLETED);
        when(orderRepository.findById(1L)).thenReturn(Optional.of(order));
        assertThrows(BusinessException.class, () -> orderService.cancelOrder(1L));
    }
}