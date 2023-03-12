package com.pj.auth.server.user.controller.web;

import com.pj.auth.server.user.entity.RoleName;
import com.pj.auth.server.user.form.RegisterForm;
import com.pj.auth.server.user.security.SecurityUser;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainPageController {

    @GetMapping("/")
    public String viewMainPage() {
        return "index";
    }

    @GetMapping("/login")
    public String viewLoginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String viewRegisterPage(Model model) {
        model.addAttribute("registerForm", new RegisterForm());
        return "register";
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/login_success")
    public String redirectLoggedUser(Authentication authentication) {
        SecurityUser securityUser = (SecurityUser) authentication.getPrincipal();
        if (securityUser.hasRole(RoleName.ADMIN)) {
            return "redirect:/panel";
        }
        return "redirect:/profile";
    }

    @GetMapping("/logout")
    public String logoutUser() {
        SecurityContextHolder.clearContext();
        return "index";
    }
}
