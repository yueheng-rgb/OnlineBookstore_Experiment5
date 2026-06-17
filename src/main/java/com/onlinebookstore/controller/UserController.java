package com.onlinebookstore.controller;

import com.onlinebookstore.dto.request.LoginRequest;
import com.onlinebookstore.dto.request.RegisterRequest;
import com.onlinebookstore.dto.response.ApiResponse;
import com.onlinebookstore.entity.User;
import com.onlinebookstore.service.UserService;
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
 * 用户管理 REST 控制器。
 * <p>提供用户注册、登录、CRUD 操作的 RESTful API。
 * 接口前缀：/api/users</p>
 */
@RestController
@RequestMapping("/api/users")
@Tag(name = "用户管理", description = "用户注册、登录、信息管理接口")
public class UserController {

    private final UserService userService;

    /**
     * 构造函数注入 UserService。
     */
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 用户注册。
     * @param request 注册请求
     * @return 注册成功的用户信息
     */
    @PostMapping("/register")
    @Operation(summary = "用户注册", description = "新用户注册，默认角色为 CUSTOMER")
    public ResponseEntity<ApiResponse<User>> register(@Valid @RequestBody RegisterRequest request) {
        User user = userService.register(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.success(user));
    }

    /**
     * 用户登录。
     * @param request 登录请求
     * @return 登录成功的用户信息
     */
    @PostMapping("/login")
    @Operation(summary = "用户登录", description = "使用用户名和密码登录")
    public ResponseEntity<ApiResponse<User>> login(@Valid @RequestBody LoginRequest request) {
        User user = userService.login(request);
        return ResponseEntity.ok(ApiResponse.success(user));
    }

    /**
     * 根据 ID 获取用户信息。
     */
    @GetMapping("/{id}")
    @Operation(summary = "查询用户", description = "根据用户 ID 获取用户信息")
    public ResponseEntity<ApiResponse<User>> getUserById(
            @Parameter(description = "用户 ID") @PathVariable Long id) {
        User user = userService.getUserById(id);
        return ResponseEntity.ok(ApiResponse.success(user));
    }

    /**
     * 分页获取所有用户。
     */
    @GetMapping
    @Operation(summary = "用户列表", description = "分页获取所有用户")
    public ResponseEntity<ApiResponse<Page<User>>> getAllUsers(
            @PageableDefault(size = 10, sort = "createdAt", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<User> users = userService.getAllUsers(pageable);
        return ResponseEntity.ok(ApiResponse.success(users));
    }

    /**
     * 更新用户信息。
     */
    @PutMapping("/{id}")
    @Operation(summary = "更新用户", description = "更新指定用户的信息")
    public ResponseEntity<ApiResponse<User>> updateUser(
            @Parameter(description = "用户 ID") @PathVariable Long id,
            @RequestBody User updates) {
        User user = userService.updateUser(id, updates);
        return ResponseEntity.ok(ApiResponse.success(user));
    }

    /**
     * 删除用户。
     */
    @DeleteMapping("/{id}")
    @Operation(summary = "删除用户", description = "根据 ID 删除用户")
    public ResponseEntity<ApiResponse<Void>> deleteUser(
            @Parameter(description = "用户 ID") @PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok(ApiResponse.success("用户删除成功"));
    }
}
