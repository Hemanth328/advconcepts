package com.org.threadpoolexecutor.exception;

import com.org.threadpoolexecutor.dto.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CompletableFutureExceptions.class)
    public ResponseEntity<ErrorResponseDto> handleCompletableFutureExceptions(CompletableFutureExceptions exception, WebRequest request) {

        ErrorResponseDto errorResponseDto = new ErrorResponseDto(
                request.getDescription(false),
                exception.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR
        );

        return ResponseEntity.internalServerError().body(errorResponseDto);
    }
}
