package com.pj.auth.server.user.entity;

import com.pj.auth.server.utils.hibernate.BasicEntity;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "roles")
public class Role extends BasicEntity {

    @Column(name = "name")
    @Enumerated(EnumType.STRING)
    private RoleName name;

    public RoleName getName() {
        return name;
    }

    public Role(RoleName name) {
        this.name = name;
    }

    public Role() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return name == role.name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
