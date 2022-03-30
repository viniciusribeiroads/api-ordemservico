package com.controleservico.os.service;

import com.controleservico.os.controller.dto.AddressDto;
import com.controleservico.os.mapper.AddressMapper;
import com.controleservico.os.mapper.PeopleMapper;
import com.controleservico.os.model.AddressUser;
import com.controleservico.os.repository.AddressRepository;
import com.controleservico.os.repository.PeopleRepository;
import lombok.AllArgsConstructor;
import org.apache.tomcat.jni.Address;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class AddressService {

    private AddressRepository addressRepository;

    public List<AddressDto> getAll() {
        List<AddressDto> listAddressDto = new ArrayList<>();
        addressRepository.findAll().forEach(address -> listAddressDto.add(AddressMapper.toDto(address)));
        return listAddressDto;
    }


    @Transient
    public AddressDto save(@NotNull AddressDto addressDto) {
        //peopleRepository.save(PeopleMapper.toPeopleEntity(addressDto.getOwner())); -> cascade=CascadeType.PERSIST
        return AddressMapper.toDto(addressRepository.save(AddressMapper.toAddressEntity(addressDto)));
    }
}
