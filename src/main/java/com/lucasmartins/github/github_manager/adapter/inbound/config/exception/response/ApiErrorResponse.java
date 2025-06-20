package com.lucasmartins.github.github_manager.adapter.inbound.config.exception.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ApiErrorResponse {

    private LocalDateTime timestamp;

    private Integer status;

    private String error;

    private String message;

    private String detailedMessage;

    private String path;

}
