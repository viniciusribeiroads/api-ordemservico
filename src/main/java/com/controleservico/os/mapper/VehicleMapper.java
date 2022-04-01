package com.controleservico.os.mapper;

import com.controleservico.os.controller.dto.VehicleDto;
import com.controleservico.os.model.Vehicle;
import org.springframework.beans.BeanUtils;

public class VehicleMapper {

    public static VehicleDto toDto(Vehicle vehicle){
        return new VehicleDto(
                vehicle.getId(),
                vehicle.getModel(),
                vehicle.getManufacturer(),
                vehicle.getPlate());
    }

    public static Vehicle toEntity(VehicleDto vehicleDto){
        return new Vehicle(
                vehicleDto.getId(),
                vehicleDto.getModel(),
                vehicleDto.getManufacturer(),
                vehicleDto.getPlate());
    }

    public static Vehicle copyProperties(Vehicle vehicle){
        Vehicle vehicleCopied = new Vehicle();
        BeanUtils.copyProperties(vehicle, vehicleCopied);
        return vehicleCopied;
    }
}
