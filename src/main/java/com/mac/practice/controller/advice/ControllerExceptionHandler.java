package com.mac.practice.controller.advice;

import com.mac.practice.util.factory.ResponseDtoFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<?> handleIllegalStateException(IllegalStateException exception, WebRequest webRequest) {
        return ResponseEntity.ok(ResponseDtoFactory.getFailedResponseDto(exception.getMessage()));
    }
}
