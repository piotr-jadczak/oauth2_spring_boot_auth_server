package com.pj.auth.server.user.form;

import jakarta.validation.constraints.Size;

public class LoginForm {

    @Size(min = 4, max = 32, message = "username length must be between 4 and 32 characters")
    private String username;

    @Size(min = 8, max = 32, message = "password length must be between 4 and 32 characters")
    private String password;

    public LoginForm() {
    }
}
