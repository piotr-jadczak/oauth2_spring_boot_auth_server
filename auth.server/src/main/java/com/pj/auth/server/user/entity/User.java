package com.pj.auth.server.user.entity;

import com.pj.auth.server.utils.hibernate.BasicEntity;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "users")
public class User extends BasicEntity {

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "is_locked")
    private boolean isLocked;

    @Column(name = "is_enabled")
    private boolean isEnabled;

    @Column(name = "is_expired")
    private boolean isExpired;

    @Column(name = "is_credentials_expired")
    private boolean isCredentialsExpired;

    @Column(name = "uuid")
    private String uuid;

    @Column(name = "email")
    private String email;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    Set<Role> roles;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public boolean isExpired() {
        return isExpired;
    }

    public boolean isCredentialsExpired() {
        return isCredentialsExpired;
    }

    public String getUuid() {
        return uuid;
    }

    public String getEmail() {
        return email;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void addRole(RoleName roleName) {
        var newRole = new Role(roleName);
        this.roles.add(newRole);
    }

    public User() {}

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        setDefaultState();
    }

    private void setDefaultState () {
        this.isLocked = false;
        this.isEnabled = true;
        this.isExpired = false;
        this.isCredentialsExpired = false;
        this.roles = new HashSet<>(List.of(new Role(RoleName.USER)));
        this.uuid = UUID.randomUUID().toString();
    }
}
