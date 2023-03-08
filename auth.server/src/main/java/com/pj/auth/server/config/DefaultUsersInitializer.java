package com.pj.auth.server.config;

import com.pj.auth.server.user.form.RegisterForm;
import com.pj.auth.server.user.repository.UserReadOnlyRepository;
import com.pj.auth.server.user.service.UserRegisterService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DefaultUsersInitializer {

    private final UserRegisterService userRegisterService;
    private final UserReadOnlyRepository userReadOnlyRepository;
    private final String adminUserName;
    private final String adminPassword;
    private final String adminEmail;
    private final String testUserUsername;
    private final String testUserPassword;
    private final String testUserEmail;

    public DefaultUsersInitializer(UserRegisterService userRegisterService, UserReadOnlyRepository userReadOnlyRepository,
                                   @Value("${admin.user.username}") String adminUserName,
                                   @Value("${admin.user.password}") String adminPassword,
                                   @Value("${admin.user.email}") String adminEmail,
                                   @Value("${test.user.username}") String testUserUsername,
                                   @Value("${test.user.password}") String testUserPassword,
                                   @Value("${test.user.email}") String testUserEmail) {
        this.userRegisterService = userRegisterService;
        this.userReadOnlyRepository = userReadOnlyRepository;
        this.adminUserName = adminUserName;
        this.adminPassword = adminPassword;
        this.adminEmail = adminEmail;
        this.testUserUsername = testUserUsername;
        this.testUserPassword = testUserPassword;
        this.testUserEmail = testUserEmail;
    }

    public void injectAdminUser() {
        boolean isAdminInDb = userReadOnlyRepository.findByUsername(adminUserName).isPresent();
        if (isAdminInDb) {
            return;
        }
        RegisterForm registerForm = new RegisterForm(adminUserName, adminEmail, adminPassword);
        userRegisterService.registerAdmin(registerForm);
    }

    public void injectTestUser() {
        boolean isTestUserInDb = userReadOnlyRepository.findByUsername(testUserUsername).isPresent();
        if (isTestUserInDb) {
            return;
        }
        RegisterForm registerForm = new RegisterForm(testUserUsername, testUserEmail, testUserPassword);
        userRegisterService.registerUser(registerForm);
    }
}
