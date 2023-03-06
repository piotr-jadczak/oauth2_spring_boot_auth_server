package com.pj.auth.server.user.validation;

public enum UserResult {
    USER_WITH_USERNAME_NOT_EXISTS("user with username not exists");

    private final String message;

    UserResult(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getMessage(String details) {
        return String.format("%s: %s", this.message, details);
    }
}
