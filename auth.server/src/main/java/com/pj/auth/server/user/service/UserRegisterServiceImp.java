package com.pj.auth.server.user.service;

import com.pj.auth.server.user.entity.Role;
import com.pj.auth.server.user.entity.RoleName;
import com.pj.auth.server.user.entity.User;
import com.pj.auth.server.user.form.RegisterForm;
import com.pj.auth.server.user.repository.RoleRepository;
import com.pj.auth.server.user.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
class UserRegisterServiceImp implements UserRegisterService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    UserRegisterServiceImp(PasswordEncoder passwordEncoder ,UserRepository userRepository,
                           RoleRepository roleRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public void registerUser(RegisterForm form) {
        var userRole = roleRepository.findByRoleName(RoleName.USER);
        saveUser(form, userRole);
    }

    @Override
    public void registerAdmin(RegisterForm form) {
        var userRole = roleRepository.findByRoleName(RoleName.USER);
        var adminRole = roleRepository.findByRoleName(RoleName.ADMIN);
        saveUser(form, userRole, adminRole);
    }

    private void saveUser(RegisterForm form, Role... roles) {
        var hashedPassword = passwordEncoder.encode(form.getPassword());
        var newUser = User.createUser(form.getUsername(), form.getEmail(), hashedPassword, roles);
        userRepository.save(newUser);
    }
}
