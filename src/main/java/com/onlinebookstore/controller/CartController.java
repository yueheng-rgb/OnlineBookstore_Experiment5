package com.onlinebookstore.controller;

import com.onlinebookstore.dto.request.CartItemRequest;
import com.onlinebookstore.dto.response.ApiResponse;
import com.onlinebookstore.entity.Cart;
import com.onlinebookstore.service.CartService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * 购物车管理 REST 控制器。
 * <p>提供购物车的查看、商品添加/更新/移除功能。
 * 接口前缀：/api/carts</p>
 */
@RestController
@RequestMapping("/api/carts")
@Tag(name = "购物车管理", description = "购物车及购物车项的增删改查接口")
public class CartController {

    private final CartService cartService;

    /**
     * 构造函数注入 CartService。
     */
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    /**
     * 获取用户购物车。
     * @param userId 用户 ID
     * @return 购物车信息
     */
    @GetMapping("/{userId}")
    @Operation(summary = "查看购物车", description = "获取指定用户的购物车内容")
    public ResponseEntity<ApiResponse<Cart>> getCart(
            @Parameter(description = "用户 ID") @PathVariable Long userId) {
        Cart cart = cartService.getCartByUserId(userId);
        return ResponseEntity.ok(ApiResponse.success(cart));
    }

    /**
     * 向购物车添加商品。
     */
    @PostMapping("/{userId}/items")
    @Operation(summary = "添加商品到购物车", description = "向指定用户的购物车中添加商品")
    public ResponseEntity<ApiResponse<Cart>> addItemToCart(
            @Parameter(description = "用户 ID") @PathVariable Long userId,
            @Valid @RequestBody CartItemRequest request) {
        Cart cart = cartService.addItemToCart(userId, request);
        return ResponseEntity.ok(ApiResponse.success(cart));
    }

    /**
     * 更新购物车商品数量。
     */
    @PutMapping("/{userId}/items/{itemId}")
    @Operation(summary = "更新购物车商品数量", description = "修改购物车中某项商品的数量")
    public ResponseEntity<ApiResponse<Cart>> updateCartItem(
            @Parameter(description = "用户 ID") @PathVariable Long userId,
            @Parameter(description = "购物车项 ID") @PathVariable Long itemId,
            @Parameter(description = "新数量") @RequestParam Integer quantity) {
        Cart cart = cartService.updateCartItemQuantity(userId, itemId, quantity);
        return ResponseEntity.ok(ApiResponse.success(cart));
    }

    /**
     * 从购物车移除商品。
     */
    @DeleteMapping("/{userId}/items/{itemId}")
    @Operation(summary = "从购物车移除商品", description = "删除购物车中的一项商品")
    public ResponseEntity<ApiResponse<Cart>> removeItemFromCart(
            @Parameter(description = "用户 ID") @PathVariable Long userId,
            @Parameter(description = "购物车项 ID") @PathVariable Long itemId) {
        Cart cart = cartService.removeItemFromCart(userId, itemId);
        return ResponseEntity.ok(ApiResponse.success(cart));
    }

    /**
     * 清空购物车。
     */
    @DeleteMapping("/{userId}")
    @Operation(summary = "清空购物车", description = "清空指定用户的购物车")
    public ResponseEntity<ApiResponse<Void>> clearCart(
            @Parameter(description = "用户 ID") @PathVariable Long userId) {
        cartService.clearCart(userId);
        return ResponseEntity.ok(ApiResponse.success("购物车已清空"));
    }
}
