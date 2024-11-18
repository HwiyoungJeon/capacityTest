package com.example.goal.exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
@RestControllerAdvice
public class GlobalExceptionHandler extends RuntimeException {
    @ExceptionHandler(ItemException.class)
    public ResponseEntity<ErrorHandler> globalExceptionHandler(Exception ex){
        ErrorHandler errorHandler = new ErrorHandler(GlobalMessage.NOT_FOUND, HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(errorHandler, HttpStatus.NOT_FOUND);
    }
}