package com.example.todoapi.common.exception;

import com.example.todoapi.common.message.ExceptionMessage;

public class BadRequestException extends RuntimeException {

    public BadRequestException(ExceptionMessage message) {
        super(message.getMessage());
    }
}
