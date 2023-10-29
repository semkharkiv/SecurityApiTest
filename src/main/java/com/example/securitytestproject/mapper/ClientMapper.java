package com.example.securitytestproject.mapper;

import com.example.securitytestproject.dto.ClientRequestDto;
import com.example.securitytestproject.dto.ClientResponseDto;
import com.example.securitytestproject.entity.Client;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    ClientResponseDto toDto(Client client);

    Client toEntity(ClientRequestDto clientRequestDto);

}
