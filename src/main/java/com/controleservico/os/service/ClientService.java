package com.controleservico.os.service;

import com.controleservico.os.controller.dto.ClientDto;
import com.controleservico.os.mapper.ClientMapper;
import com.controleservico.os.model.Client;
import com.controleservico.os.repository.ClientRepository;
import com.controleservico.os.repository.PeopleRepository;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ClientService {

    private ClientRepository clientRepository;
    private PeopleRepository peopleRepository;


    public List<ClientDto> listAll() {
        List<ClientDto> clientDtoList = new ArrayList<>();
        clientRepository.findAll()
                .forEach(client -> clientDtoList.add(ClientMapper.toDto(client)));
        return clientDtoList;
    }


    public ResponseEntity<ClientDto> findBy(Long id) {
        return clientRepository.findById(id)
                .map(client -> ResponseEntity.ok(ClientMapper.toDto(client)))
                .orElse(ResponseEntity.notFound().build());
    }


    @SneakyThrows
    public ResponseEntity<Client> create(Client client) {
        if (existsByCpf(client.getClient().getCpf())) {
            throw new SQLIntegrityConstraintViolationException("Esse CPF ja existe!");
        }
        return new ResponseEntity<>(clientRepository.save(client), HttpStatus.CREATED);
    }

    private boolean existsByCpf(String cpf){
        return peopleRepository.existsByCpf(cpf);
    }


    public ResponseEntity<Client> update(Client client) {
        return clientRepository.findById(client.getId())
                .map(oldClient -> {
                    oldClient = ClientMapper.copyProperties(oldClient);

                    return new ResponseEntity<>(clientRepository.save(oldClient), HttpStatus.CREATED);
                })
                .orElse(ResponseEntity.notFound().build());
    }


    public ResponseEntity deleteBy(Long id) {
        return clientRepository.findById(id)
                .map(client -> {
                    clientRepository.delete(client);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
