package com.pj.auth.server.user.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.STRING)
public enum RoleName {
    USER,
    ADMIN
}
