package com.pj.auth.server.user.entity;

import com.pj.auth.server.utils.hibernate.BasicEntity;
import jakarta.persistence.*;

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
}
