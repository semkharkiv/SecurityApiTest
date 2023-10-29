package com.example.securitytestproject.dto;

import com.example.securitytestproject.entity.Role;
import lombok.Data;

import java.util.Set;

@Data
public class ClientResponseDto {
    private String name;
    private String email;
    private Set<Role> roles;
}
