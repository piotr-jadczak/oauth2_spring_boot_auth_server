package com.pj.auth.server.user.form;

import com.pj.auth.server.user.validation.annotation.UniqueEmail;
import com.pj.auth.server.user.validation.annotation.UniqueUsername;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public class RegisterForm {

    @Size(min = 4, max = 32, message = "username length must be between 4 and 32 characters")
    @UniqueUsername
    private String username;

    @Email
    @UniqueEmail
    private String email;

    @Size(min = 8, max = 32, message = "password length must be between 4 and 32 characters")
    private String password;

    public RegisterForm() {
    }

    public RegisterForm(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
