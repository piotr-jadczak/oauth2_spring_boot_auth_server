package com.pj.auth.server.user.service;

import com.pj.auth.server.user.form.RegisterForm;

public interface UserRegisterService {

    void registerUser(RegisterForm form);

    void registerAdmin(RegisterForm form);
}
