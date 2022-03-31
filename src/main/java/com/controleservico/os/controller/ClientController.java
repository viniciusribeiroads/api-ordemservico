package com.controleservico.os.controller;

import com.controleservico.os.controller.dto.ClientDto;
import com.controleservico.os.model.Client;
import com.controleservico.os.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
@AllArgsConstructor
public class ClientController {

    private ClientService clientService;

    @GetMapping(path = "/all")
    public List<ClientDto> listAll(){
        return clientService.listAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ClientDto> findBy(@PathVariable Long id){
        return clientService.findBy(id);
    }

    @PostMapping(path = "/new")
    public ResponseEntity<Client> create( @RequestBody Client client){
        return clientService.create(client);
    }

    @PutMapping(path = "/update")
    public ResponseEntity<Client> update(@RequestBody Client client){
        return clientService.update(client);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity deleteBy(@PathVariable Long id){
        return clientService.deleteBy(id);
    }
}
