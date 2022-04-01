package com.controleservico.os.service;

import com.controleservico.os.controller.dto.VehicleDto;
import com.controleservico.os.mapper.AddressMapper;
import com.controleservico.os.mapper.VehicleMapper;
import com.controleservico.os.model.Vehicle;
import com.controleservico.os.repository.VehicleRepository;
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
public class VehicleService {

    private VehicleRepository vehicleRepository;

    public List<VehicleDto> listAll() {
        List<VehicleDto> listVehicleDto = new ArrayList<>();
        vehicleRepository.findAll().stream().forEach(
                vehicle ->
                        listVehicleDto.add(VehicleMapper.toDto(vehicle)));
        return listVehicleDto;
    }

    public ResponseEntity<VehicleDto> findBy(Long id) {
        return vehicleRepository.findById(id)
                .map(vehicle -> ResponseEntity.ok(VehicleMapper.toDto(vehicle)))
                .orElse(ResponseEntity.notFound().build());
    }

    @SneakyThrows
    @Transient
    public ResponseEntity<Vehicle> create(VehicleDto vehicleDto) {
        if (existsByPlate(vehicleDto.getPlate())) {
            throw new SQLIntegrityConstraintViolationException("Essa placa já foi cadastrada!");
        }
        return new ResponseEntity<>(vehicleRepository.save(VehicleMapper.toEntity(vehicleDto)), HttpStatus.CREATED);

    }

    private boolean existsByPlate(String plate) {
        return vehicleRepository.existsByPlate(plate);
    }

    public ResponseEntity<Vehicle> update(Vehicle vehicle) {
        return vehicleRepository.findById(vehicle.getId())
                .map(oldVehicle -> {
                    oldVehicle =  VehicleMapper.copyProperties(vehicle);

                    return new ResponseEntity<>(vehicleRepository.save(oldVehicle), HttpStatus.CREATED);
                })
                .orElse(ResponseEntity.notFound().build());

    }

    public ResponseEntity deleteBy(Long id) {
        return vehicleRepository.findById(id)
                .map(vehicle -> {
                    vehicleRepository.delete(vehicle);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
