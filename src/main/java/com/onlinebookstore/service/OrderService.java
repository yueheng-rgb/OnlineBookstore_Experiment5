package com.onlinebookstore.service;

import com.onlinebookstore.dto.request.OrderRequest;
import com.onlinebookstore.entity.*;
import com.onlinebookstore.enums.OrderStatus;
import com.onlinebookstore.exception.BusinessException;
import com.onlinebookstore.exception.ResourceNotFoundException;
import com.onlinebookstore.repository.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
@Transactional
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final CartRepository cartRepository;
    private final BookService bookService;
    private final CartService cartService;

    public OrderService(OrderRepository orderRepository,
                        OrderItemRepository orderItemRepository,
                        CartRepository cartRepository,
                        BookService bookService,
                        CartService cartService) {
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
        this.cartRepository = cartRepository;
        this.bookService = bookService;
        this.cartService = cartService;
    }

    public Order createOrder(Long userId, OrderRequest request) {
        Cart cart = cartRepository.findByUserId(userId)
                .orElseThrow(() -> new BusinessException("CART_NOT_FOUND", "Cart is empty, cannot create order"));

        if (cart.getCartItems().isEmpty()) {
            throw new BusinessException("CART_NOT_FOUND", "Cart is empty, cannot create order");
        }

        for (CartItem cartItem : cart.getCartItems()) {
            Book book = cartItem.getBook();
            if (book.getStock() < cartItem.getQuantity()) {
                throw new BusinessException("INSUFFICIENT_STOCK",
                        "Book stock insufficient, current stock: " + book.getStock());
            }
        }

        Order order = new Order();
        order.setUser(cart.getUser());
        order.setOrderNumber(generateOrderNumber());
        order.setShippingAddress(request.getShippingAddress());
        order.setStatus(OrderStatus.PENDING);

        BigDecimal total = BigDecimal.ZERO;
        for (CartItem cartItem : cart.getCartItems()) {
            OrderItem orderItem = new OrderItem();
            orderItem.setBook(cartItem.getBook());
            orderItem.setQuantity(cartItem.getQuantity());
            orderItem.setUnitPrice(cartItem.getUnitPrice());
            BigDecimal subtotal = cartItem.getUnitPrice()
                    .multiply(BigDecimal.valueOf(cartItem.getQuantity()));
            orderItem.setSubtotal(subtotal);
            order.addOrderItem(orderItem);
            total = total.add(subtotal);

            bookService.deductStock(cartItem.getBook().getId(), cartItem.getQuantity());
        }
        order.setTotalAmount(total);

        Order savedOrder = orderRepository.save(order);
        cartService.clearCart(userId);
        return savedOrder;
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ORDER_NOT_FOUND", "Order not found with id: " + id));
    }

    public Page<Order> getUserOrders(Long userId, Pageable pageable) {
        return orderRepository.findByUserIdOrderByCreatedAtDesc(userId, pageable);
    }

    public Page<Order> getAllOrders(Pageable pageable) {
        return orderRepository.findAll(pageable);
    }

    public Order updateOrderStatus(Long orderId, OrderStatus status) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("ORDER_NOT_FOUND", "Order not found with id: " + orderId));

        if (order.getStatus() == OrderStatus.CANCELLED || order.getStatus() == OrderStatus.COMPLETED) {
            throw new BusinessException("ORDER_TERMINAL", "Order is in terminal state, cannot modify");
        }

        order.setStatus(status);
        return orderRepository.save(order);
    }

    public Order cancelOrder(Long orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("ORDER_NOT_FOUND", "Order not found with id: " + orderId));

        if (order.getStatus() == OrderStatus.CANCELLED) {
            throw new BusinessException("ORDER_ALREADY_CANCELLED", "Order already cancelled");
        }

        if (order.getStatus() == OrderStatus.COMPLETED) {
            throw new BusinessException("ORDER_COMPLETED", "Completed order cannot be cancelled");
        }

        order.setStatus(OrderStatus.CANCELLED);
        for (OrderItem item : order.getOrderItems()) {
            bookService.restoreStock(item.getBook().getId(), item.getQuantity());
        }
        return orderRepository.save(order);
    }

    private String generateOrderNumber() {
        String datePart = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        String timePart = String.format("%06d", System.currentTimeMillis() % 1000000);
        return "ORD-" + datePart + "-" + timePart;
    }
}