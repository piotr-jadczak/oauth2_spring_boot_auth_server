package com.pj.auth.server.user.security;

import com.pj.auth.server.user.entity.Role;
import org.springframework.security.core.GrantedAuthority;

public class SecurityRole implements GrantedAuthority {

    private final static String PREFIX = "ROLE_";

    private final Role role;

    public SecurityRole(Role role) {
        this.role = role;
    }

    @Override
    public String getAuthority() {
        return PREFIX + role.getName().toString();
    }
}
