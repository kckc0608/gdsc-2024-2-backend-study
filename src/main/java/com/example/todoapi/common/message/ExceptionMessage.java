package com.example.todoapi.common.message;

public enum ExceptionMessage {
    USER_NOT_EXISTS("존재하지 않는 user id 입니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
