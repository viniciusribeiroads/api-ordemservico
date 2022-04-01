package com.controleservico.os.controller.dto;


import java.util.List;

public class DriverDto {


    private PeopleDto driver;

    private List<AddressDto> listAddress;

    public DriverDto(PeopleDto driver, List<AddressDto> listAddress) {
        this.driver = driver;
        this.listAddress = listAddress;
        PeopleDto owner = new PeopleDto();
        this.listAddress.stream().forEach(address -> {
            owner.setBirthDate(driver.getBirthDate());
            owner.setCpf(driver.getCpf());
            owner.setName(driver.getName());
            address.setOwner(owner);
        });
    }



    public PeopleDto getDriver() {
        return driver;
    }

    public List<AddressDto> getListAddress() {
        return listAddress;
    }
}
