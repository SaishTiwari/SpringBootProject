package com.myfirstproject.productlist.dto;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class ExceptionResponseDTO {
    private String apiPath;
    private HttpStatus statusCode;
    private String errorMessage;
    private LocalDateTime localDateTime;

    public ExceptionResponseDTO(String apiPath, HttpStatus statusCode, String errorMessage, LocalDateTime localDateTime) {
        this.apiPath = apiPath;
        this.statusCode = statusCode;
        this.errorMessage = errorMessage;
        this.localDateTime = localDateTime;
    }

    public ExceptionResponseDTO() {

    }

    public String getApiPath() {
        return apiPath;
    }

    public void setApiPath(String apiPath) {
        this.apiPath = apiPath;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(HttpStatus statusCode) {
        this.statusCode = statusCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }
}
