package com.example.securitytestproject.controller;

import com.example.securitytestproject.dto.ClientRequestDto;
import com.example.securitytestproject.dto.ClientResponseDto;
import com.example.securitytestproject.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @GetMapping("/{id}")
    public ResponseEntity<ClientResponseDto> getClientById(@PathVariable("id") Long id){
        return new ResponseEntity<>(clientService.getClientDtoById(id), HttpStatus.OK);
    }

    @PostMapping("/create-manager")
    public ResponseEntity<ClientResponseDto> createClientForManager(@RequestBody ClientRequestDto clientRequestDto){
        return new ResponseEntity<>(clientService.createRequestDtoForManager(clientRequestDto),HttpStatus.CREATED);
    }

    @PostMapping("/create-user")
    public ResponseEntity<ClientResponseDto> createClientForUser(@RequestBody ClientRequestDto clientRequestDto){
        return new ResponseEntity<>(clientService.createRequestDtoForClient(clientRequestDto),HttpStatus.CREATED);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/manager/{name}")
    public void deleteClientByName(@PathVariable("name") String name){
        clientService.deleteClientByName(name);
    }

}
