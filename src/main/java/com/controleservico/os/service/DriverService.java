package com.controleservico.os.service;

import com.controleservico.os.controller.dto.ClientDto;
import com.controleservico.os.controller.dto.DriverDto;
import com.controleservico.os.mapper.ClientMapper;
import com.controleservico.os.mapper.DriverMapper;
import com.controleservico.os.model.Client;
import com.controleservico.os.model.Driver;
import com.controleservico.os.repository.DriverRepository;
import com.controleservico.os.repository.PeopleRepository;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class DriverService {

    private PeopleRepository peopleRepository;
    private DriverRepository driverRepository;



    public List<DriverDto> listAll() {
        List<DriverDto> driverDtoList = new ArrayList<>();
        driverRepository.findAll()
                .forEach(driverEntity -> driverDtoList.add(DriverMapper.toDto(driverEntity)));
        return driverDtoList;
    }


    public ResponseEntity<DriverDto> findBy(Long id) {
        return driverRepository.findById(id)
                .map(driver -> ResponseEntity.ok(DriverMapper.toDto(driver)))
                .orElse(ResponseEntity.notFound().build());
    }


    @Transient
    @SneakyThrows
    public ResponseEntity<Driver> create(DriverDto driverDto) {
        Driver driverEntity = new Driver();
        driverEntity = DriverMapper.toDriverEntity(driverDto);
        if (existsByCpf(driverEntity.getDriver().getCpf())) {
            throw new SQLIntegrityConstraintViolationException("Esse CPF ja existe!");
        }

        return new ResponseEntity<>(driverRepository.save(driverEntity), HttpStatus.CREATED);
    }

    private boolean existsByCpf(String cpf){
        return peopleRepository.existsByCpf(cpf);
    }


    @Transient
    public ResponseEntity<Driver> update(Driver driver) {
        return driverRepository.findById(driver.getId())
                .map(oldDriver -> {
                    oldDriver = DriverMapper.copyProperties(driver);

                    return new ResponseEntity<>(driverRepository.save(oldDriver), HttpStatus.CREATED);
                })
                .orElse(ResponseEntity.notFound().build());
    }


    @Transient
    public ResponseEntity deleteBy(Long id) {
        return driverRepository.findById(id)
                .map(driver -> {
                    driverRepository.delete(driver);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}


