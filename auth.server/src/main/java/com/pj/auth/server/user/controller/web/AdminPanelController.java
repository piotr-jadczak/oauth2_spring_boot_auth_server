package com.pj.auth.server.user.controller.web;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminPanelController {

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/panel")
    public String viewAdminPanel() {
        return "panel";
    }
}
