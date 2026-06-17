package com.onlinebookstore.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {

    private LocalDateTime timestamp;
    private int status;
    private String errorCode;
    private String message;
    private String path;
    private Object details;

    public ErrorResponse() {}

    public ErrorResponse(int status, String errorCode, String message, String path) {
        this.timestamp = LocalDateTime.now();
        this.status = status;
        this.errorCode = errorCode;
        this.message = message;
        this.path = path;
    }

    public static ErrorResponse of(int status, String errorCode, String message, String path) {
        return new ErrorResponse(status, errorCode, message, path);
    }

    public static ErrorResponse of(int status, String errorCode, String message, String path, Object details) {
        ErrorResponse r = new ErrorResponse(status, errorCode, message, path);
        r.details = details;
        return r;
    }

    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
    public int getStatus() { return status; }
    public void setStatus(int status) { this.status = status; }
    public String getErrorCode() { return errorCode; }
    public void setErrorCode(String errorCode) { this.errorCode = errorCode; }
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
    public String getPath() { return path; }
    public void setPath(String path) { this.path = path; }
    public Object getDetails() { return details; }
    public void setDetails(Object details) { this.details = details; }
}