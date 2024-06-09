package com.cw.restory.web.exception.controller;

import com.cw.restory.web.exception.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionController {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> validException(MethodArgumentNotValidException e){

        Map<String, String> validation = new HashMap<>();

        for (FieldError error : e.getFieldErrors()) {
            validation.put(error.getField(), error.getDefaultMessage());
        } //TODO -- 추후에 메시지는 프로퍼티에서 관리

        ErrorResponse errorResponse = ErrorResponse.builder()
                .code(HttpStatus.BAD_REQUEST.value())
                .validation(validation)
                .build();

        return ResponseEntity
                .badRequest()
                .body(errorResponse);
    }
}
