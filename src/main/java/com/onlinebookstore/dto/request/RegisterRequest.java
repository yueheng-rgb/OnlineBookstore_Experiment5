package com.onlinebookstore.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * 注册请求 DTO。
 * <p>接收用户注册所需的基本信息。</p>
 */
public class RegisterRequest {

    /** 用户名，3-50 字符 */
    @NotBlank(message = "用户名不能为空")
    @Size(min = 3, max = 50, message = "用户名长度需在 3-50 之间")
    private String username;

    /** 密码，至少 6 位 */
    @NotBlank(message = "密码不能为空")
    @Size(min = 6, message = "密码长度至少为 6 位")
    private String password;

    /** 邮箱 */
    @NotBlank(message = "邮箱不能为空")
    @Email(message = "邮箱格式不正确")
    private String email;

    /** 联系电话，可选 */
    private String phone;

    /** 收货地址，可选 */
    private String address;

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
}
