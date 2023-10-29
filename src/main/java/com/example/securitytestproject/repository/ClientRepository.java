package com.example.securitytestproject.repository;

import com.example.securitytestproject.dto.ClientResponseDto;
import com.example.securitytestproject.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client,Long> {


    Optional<Client> findClientByEmail(String name);
    void deleteClientByName(String name);

    Client findClientByName(String name);
}
