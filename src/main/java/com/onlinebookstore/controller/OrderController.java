package com.onlinebookstore.controller;

import com.onlinebookstore.dto.request.OrderRequest;
import com.onlinebookstore.dto.response.ApiResponse;
import com.onlinebookstore.entity.Order;
import com.onlinebookstore.enums.OrderStatus;
import com.onlinebookstore.service.OrderService;
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
 * 订单管理 REST 控制器。
 * <p>提供订单创建、查询和状态管理功能。
 * 接口前缀：/api/orders</p>
 */
@RestController
@RequestMapping("/api/orders")
@Tag(name = "订单管理", description = "订单的创建、查询和状态管理接口")
public class OrderController {

    private final OrderService orderService;

    /**
     * 构造函数注入 OrderService。
     */
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    /**
     * 从购物车创建订单。
     */
    @PostMapping
    @Operation(summary = "创建订单", description = "从当前用户的购物车生成订单")
    public ResponseEntity<ApiResponse<Order>> createOrder(
            @Parameter(description = "用户 ID") @RequestParam Long userId,
            @Valid @RequestBody OrderRequest request) {
        Order order = orderService.createOrder(userId, request);
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.success(order));
    }

    /**
     * 根据 ID 获取订单详情。
     */
    @GetMapping("/{id}")
    @Operation(summary = "查询订单", description = "根据订单 ID 获取订单详情")
    public ResponseEntity<ApiResponse<Order>> getOrderById(
            @Parameter(description = "订单 ID") @PathVariable Long id) {
        Order order = orderService.getOrderById(id);
        return ResponseEntity.ok(ApiResponse.success(order));
    }

    /**
     * 获取用户的订单列表。
     */
    @GetMapping("/user/{userId}")
    @Operation(summary = "用户订单列表", description = "分页获取指定用户的订单")
    public ResponseEntity<ApiResponse<Page<Order>>> getUserOrders(
            @Parameter(description = "用户 ID") @PathVariable Long userId,
            @PageableDefault(size = 10, sort = "createdAt", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<Order> orders = orderService.getUserOrders(userId, pageable);
        return ResponseEntity.ok(ApiResponse.success(orders));
    }

    /**
     * 获取所有订单（管理员）。
     */
    @GetMapping
    @Operation(summary = "所有订单", description = "分页获取系统中所有订单（管理员功能）")
    public ResponseEntity<ApiResponse<Page<Order>>> getAllOrders(
            @PageableDefault(size = 10, sort = "createdAt", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<Order> orders = orderService.getAllOrders(pageable);
        return ResponseEntity.ok(ApiResponse.success(orders));
    }

    /**
     * 更新订单状态。
     */
    @PutMapping("/{id}/status")
    @Operation(summary = "更新订单状态", description = "修改订单的状态（PENDING/PAID/SHIPPED/COMPLETED/CANCELLED）")
    public ResponseEntity<ApiResponse<Order>> updateOrderStatus(
            @Parameter(description = "订单 ID") @PathVariable Long id,
            @Parameter(description = "目标状态") @RequestParam OrderStatus status) {
        Order order = orderService.updateOrderStatus(id, status);
        return ResponseEntity.ok(ApiResponse.success(order));
    }

    /**
     * 取消订单。
     */
    @PostMapping("/{id}/cancel")
    @Operation(summary = "取消订单", description = "取消指定订单并恢复库存")
    public ResponseEntity<ApiResponse<Order>> cancelOrder(
            @Parameter(description = "订单 ID") @PathVariable Long id) {
        Order order = orderService.cancelOrder(id);
        return ResponseEntity.ok(ApiResponse.success(order));
    }
}
