package com.controleservico.os.mapper;

import com.controleservico.os.controller.dto.AddressDto;
import com.controleservico.os.controller.dto.ClientDto;
import com.controleservico.os.model.AddressUser;
import com.controleservico.os.model.Client;
import org.apache.tomcat.jni.Address;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class ClientMapper {

    public static ClientDto toDto(Client client){
        List<AddressDto> clientDtoList = new ArrayList<>();
        client.getListAddress().forEach(
                address -> clientDtoList.add(AddressMapper.toDto(address)));
        return new ClientDto(
                PeopleMapper.toDto(client.getClient()),
                clientDtoList);
    }

    public static Client toClientEntity(ClientDto clientDto){
        List<AddressUser> clientList = new ArrayList<>();
        clientDto.getListAddress().forEach(
                address -> clientList.add(AddressMapper.toAddressEntity(address)));
        return new Client(
                PeopleMapper.toPeopleEntity(clientDto.getClient()),
                clientList);
    }

    public static Client copyProperties(Client client){
        Client clientCopied = new Client();
        BeanUtils.copyProperties(client, clientCopied);
        return clientCopied;
    }


}
