package com.example.goal.exception;
import lombok.AllArgsConstructor;
import lombok.Getter;
@Getter
@AllArgsConstructor
public class ErrorHandler {
    private String message;
    private Integer errorCode;
}