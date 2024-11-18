package com.example.goal.exception;
import lombok.AllArgsConstructor;
import lombok.Getter;
@Getter
@AllArgsConstructor
public class SuccessResponse<T> {
    private String message;
    private int code;
    private T data;
}