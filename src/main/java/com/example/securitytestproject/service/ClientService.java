package com.example.securitytestproject.service;

import com.example.securitytestproject.dto.ClientRequestDto;
import com.example.securitytestproject.dto.ClientResponseDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface ClientService extends UserDetailsService {
    ClientResponseDto getClientDtoById(Long id);

    ClientResponseDto createRequestDtoForManager(ClientRequestDto clientRequestDto);

    ClientResponseDto createRequestDtoForClient(ClientRequestDto clientRequestDto);

    void deleteClientByName(String name);
}
