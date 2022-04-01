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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
        addressRepository.findAll()
                .stream()
                .forEach( address ->
            listAddressDto.add(AddressMapper.toDto(address)));
        return listAddressDto;
    }

    public ResponseEntity<AddressDto> findBy(Long id) {
        return addressRepository.findById(id)
                .map(addressUser -> ResponseEntity.ok(AddressMapper.toDto(addressUser)))
                .orElse(ResponseEntity.notFound().build());
    }


    @Transient
    public AddressDto save(@NotNull AddressDto addressDto) {
        //peopleRepository.save(PeopleMapper.toPeopleEntity(addressDto.getOwner())); -> cascade=CascadeType.PERSIST
        return AddressMapper.toDto(addressRepository.save(AddressMapper.toAddressEntity(addressDto)));
    }

    public ResponseEntity deleteBy(Long id) {
        return addressRepository.findById(id)
                .map(address -> {
                    addressRepository.delete(address);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }


    public ResponseEntity<AddressUser> update(AddressUser addressUser) {
        return addressRepository.findById(addressUser.getId())
                .map(oldAddress -> {
                    oldAddress.setAddressType(addressUser.getAddressType());
                    oldAddress.setCep(addressUser.getCep());
                    oldAddress.setCity(addressUser.getCity());
                    oldAddress.setComplement(addressUser.getComplement());
                    oldAddress.setDistrict(addressUser.getDistrict());
                    oldAddress.setNumber(addressUser.getNumber());
                    oldAddress.setOwner(addressUser.getOwner());

                    return new ResponseEntity<>(addressRepository.save(oldAddress), HttpStatus.CREATED);
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
