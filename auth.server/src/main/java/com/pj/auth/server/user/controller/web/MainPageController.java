package com.pj.auth.server.user.controller.web;

import com.pj.auth.server.user.form.LoginForm;
import com.pj.auth.server.user.form.RegisterForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainPageController {

    @GetMapping("/")
    public String viewMainPage(Model model) {
        return "index";
    }

    @GetMapping("/login")
    public String viewLoginPage(Model model) {
        model.addAttribute("loginForm", new LoginForm());

        return "login";
    }

    @GetMapping("/register")
    public String viewRegisterPage(Model model) {
        model.addAttribute("registerForm", new RegisterForm());

        return "register";
    }
}
