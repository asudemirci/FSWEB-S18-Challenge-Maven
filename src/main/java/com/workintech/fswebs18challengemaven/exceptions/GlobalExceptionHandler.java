package com.workintech.fswebs18challengemaven.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CardException.class)
    public ResponseEntity<CardErrorResponse> handleCardException(CardException e) {
        log.error("CardException: {}", e.getMessage());
        CardErrorResponse response = new CardErrorResponse(
                e.getHttpStatus().value(), e.getMessage(), System.currentTimeMillis());
        return new ResponseEntity<>(response, e.getHttpStatus());
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<CardErrorResponse> handleRuntimeException(RuntimeException e) {
        log.error("RuntimeException: {}", e.getMessage());
        CardErrorResponse response = new CardErrorResponse(
                500, e.getMessage(), System.currentTimeMillis());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
