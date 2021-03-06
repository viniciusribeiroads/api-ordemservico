package com.controleservico.os.controller.dto;

import com.controleservico.os.model.AddressUser;
import com.controleservico.os.model.People;


import java.util.List;

public class ClientDto {


    private PeopleDto client;

    private List<AddressDto> listAddress;

    public ClientDto(PeopleDto client, List<AddressDto> listAddress) {
        this.client = client;
        this.listAddress = listAddress;
        PeopleDto owner = new PeopleDto();
        this.listAddress.stream().forEach(address -> {
            owner.setBirthDate(client.getBirthDate());
            owner.setCpf(client.getCpf());
            owner.setName(client.getName());
            address.setOwner(owner);
        });
    }



    public PeopleDto getClient() {
        return client;
    }

    public List<AddressDto> getListAddress() {
        return listAddress;
    }
}
