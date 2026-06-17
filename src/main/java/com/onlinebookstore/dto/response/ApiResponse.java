package com.onlinebookstore.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.time.LocalDateTime;

/**
 * 统一 API 响应封装。
 * <p>所有 REST 接口返回此格式，确保前端能统一处理成功和错误情况。</p>
 *
 * @param <T> 响应数据的类型
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {

    /** HTTP 状态码 */
    private int code;

    /** 响应消息 */
    private String message;

    /** 响应数据体，可为 null */
    private T data;

    /** 响应时间戳 */
    private LocalDateTime timestamp;

    /**
     * 创建成功响应（带数据）。
     * @param data 响应数据
     * @param <T> 数据类型
     * @return ApiResponse 实例
     */
    public static <T> ApiResponse<T> success(T data) {
        ApiResponse<T> response = new ApiResponse<>();
        response.code = 200;
        response.message = "操作成功";
        response.data = data;
        response.timestamp = LocalDateTime.now();
        return response;
    }

    /**
     * 创建成功响应（无数据）。
     * @param message 成功消息
     * @param <T> 数据类型
     * @return ApiResponse 实例
     */
    public static <T> ApiResponse<T> success(String message) {
        ApiResponse<T> response = new ApiResponse<>();
        response.code = 200;
        response.message = message;
        response.timestamp = LocalDateTime.now();
        return response;
    }

    /**
     * 创建错误响应。
     * @param code HTTP 状态码
     * @param message 错误消息
     * @param <T> 数据类型
     * @return ApiResponse 实例
     */
    public static <T> ApiResponse<T> error(int code, String message) {
        ApiResponse<T> response = new ApiResponse<>();
        response.code = code;
        response.message = message;
        response.timestamp = LocalDateTime.now();
        return response;
    }

    /**
     * 创建错误响应（带错误详情）。
     * @param code HTTP 状态码
     * @param message 错误消息
     * @param data 错误详情
     * @param <T> 数据类型
     * @return ApiResponse 实例
     */
    public static <T> ApiResponse<T> error(int code, String message, T data) {
        ApiResponse<T> response = new ApiResponse<>();
        response.code = code;
        response.message = message;
        response.data = data;
        response.timestamp = LocalDateTime.now();
        return response;
    }

    // Getters and Setters
    public int getCode() { return code; }
    public void setCode(int code) { this.code = code; }
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
    public T getData() { return data; }
    public void setData(T data) { this.data = data; }
    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
}
