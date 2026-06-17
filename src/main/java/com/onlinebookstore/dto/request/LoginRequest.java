package com.onlinebookstore.dto.request;

import jakarta.validation.constraints.NotBlank;

/**
 * 登录请求 DTO。
 * <p>接收用户名和密码用于身份验证。</p>
 */
public class LoginRequest {

    /** 用户名，不可为空 */
    @NotBlank(message = "用户名不能为空")
    private String username;

    /** 密码，不可为空 */
    @NotBlank(message = "密码不能为空")
    private String password;

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
