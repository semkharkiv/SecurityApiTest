package com.example.securitytestproject.dto;

import lombok.Data;

@Data
public class ClientRequestDto {
    private String name;
    private String password;
    private String email;
}
