package com.example.securitytestproject.mapper;

import com.example.securitytestproject.dto.ClientRequestDto;
import com.example.securitytestproject.dto.ClientResponseDto;
import com.example.securitytestproject.entity.Client;
import com.example.securitytestproject.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    @Mapping(source = "client.roles", target = "role",qualifiedByName = "mapRoles")
    ClientResponseDto toDto(Client client);

    Client toEntity(ClientRequestDto clientRequestDto);

    @Named("mapRoles")
    default String mapRoles(Set<Role> roles) {
        return roles.stream()
                .map(Role::getName) // Предположим, что у Role есть метод getName() для получения имени роли
                .collect(Collectors.joining(", "));}
}
