package com.controleservico.os.mapper;

import com.controleservico.os.controller.dto.ServiceDto;
import com.controleservico.os.model.Service;
import com.controleservico.os.model.Vehicle;
import org.springframework.beans.BeanUtils;

public class ServiceMapper {

    public static ServiceDto toDto(Service service){
        return new ServiceDto(
                service.getDate(),
                service.getDescription(),
                service.getStatus().getCode(),
                service.getDriverService(),
                service.getVehicleService(),
                service.getClient(),
                service.getVehicleClient()
        );}

    public static Service toEntity(ServiceDto serviceDto){
        return new Service(
                null,
                serviceDto.getDate(),
                serviceDto.getStatus().getCode(),
                serviceDto.getDescription(),
                serviceDto.getDriverService(),
                serviceDto.getVehicleService(),
                serviceDto.getClient(),
                serviceDto.getVehicleClient());
    }

    public static Service copyProperties(Service service){
        Service serviceCopied = new Service();
        BeanUtils.copyProperties(service, serviceCopied);
        return serviceCopied;
    }
}
