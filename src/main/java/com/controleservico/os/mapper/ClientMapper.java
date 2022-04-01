package com.controleservico.os.mapper;

import com.controleservico.os.controller.dto.AddressDto;
import com.controleservico.os.controller.dto.ClientDto;
import com.controleservico.os.model.AddressUser;
import com.controleservico.os.model.Client;
import org.apache.tomcat.jni.Address;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class ClientMapper {

    @Contract("_ -> new")
    public static @NotNull ClientDto toDto(@NotNull Client client){
        List<AddressDto> addressDtoList = new ArrayList<>();
        client.getListAddress().stream().forEach(
                address -> addressDtoList.add(AddressMapper.toDto(address)));
        return new ClientDto(
                PeopleMapper.toDto(client.getClient()),
                addressDtoList);
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
