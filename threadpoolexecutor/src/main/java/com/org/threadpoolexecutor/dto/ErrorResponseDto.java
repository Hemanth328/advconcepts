package com.org.threadpoolexecutor.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class ErrorResponseDto {

    private String path;
    private String message;
    private HttpStatus status;
}
