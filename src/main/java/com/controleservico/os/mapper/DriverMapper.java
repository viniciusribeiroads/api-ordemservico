package com.controleservico.os.mapper;

import com.controleservico.os.controller.dto.AddressDto;
import com.controleservico.os.controller.dto.ClientDto;
import com.controleservico.os.controller.dto.DriverDto;
import com.controleservico.os.model.AddressUser;
import com.controleservico.os.model.Client;
import com.controleservico.os.model.Driver;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class DriverMapper {

    @Contract("_ -> new")
    public static @NotNull DriverDto toDto(@NotNull Driver driver){
        List<AddressDto> addressDtoList = new ArrayList<>();
        driver.getListAddress().stream().forEach(
                address -> addressDtoList.add(AddressMapper.toDto(address)));
        return new DriverDto(
                PeopleMapper.toDto(driver.getDriver()),
                addressDtoList);
    }

    public static Driver toDriverEntity(DriverDto driverDto){
        List<AddressUser> clientList = new ArrayList<>();
        driverDto.getListAddress().forEach(
                address -> clientList.add(AddressMapper.toAddressEntity(address)));
        return new Driver(
                PeopleMapper.toPeopleEntity(driverDto.getDriver()),
                clientList);
    }

    public static Driver copyProperties(Driver driver){
        Driver driverCopied = new Driver();
        BeanUtils.copyProperties(driver, driverCopied);
        return driverCopied;
    }


}
