package com.assignment.cms.Entity;

import lombok.Data;

import java.util.Set;

@Data
public class UserResponseDTO {
    private String username;
    private String email;
    private Set<String> role;

    public UserResponseDTO(String username, String email, Set<String> role) {
        this.username = username;
        this.email = email;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<String> getRole() {
        return role;
    }

    public void setRole(Set<String> role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}