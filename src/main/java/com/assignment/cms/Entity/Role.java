package com.assignment.cms.Entity;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Role {
    ROLE_USER,
    ROLE_ADMIN;

    @JsonCreator
    public static Role fromString(String value) {
        return Role.valueOf(value.startsWith("ROLE_") ? value : "ROLE_" + value);
    }
}