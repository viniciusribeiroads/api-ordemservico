package com.controleservico.os.service;

import com.controleservico.os.controller.dto.ServiceDto;
import com.controleservico.os.mapper.ServiceMapper;
import com.controleservico.os.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceService {

    @Autowired
    private ServiceRepository serviceRepository;


    public List<ServiceDto> findAll() {
        List<ServiceDto> listServiceDto = new ArrayList<>();
        serviceRepository.findAll().stream()
                .map(service ->
                        listServiceDto.add(ServiceMapper.toDto(service)));
        return listServiceDto;
    }


    public ResponseEntity<com.controleservico.os.model.Service> save(ServiceDto serviceDto) {
        com.controleservico.os.model.Service newService = ServiceMapper.toEntity(serviceDto);

        return  ResponseEntity.status(HttpStatus.CREATED).body(serviceRepository.save(newService));
    }


}
