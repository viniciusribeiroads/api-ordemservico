package com.controleservico.os.controller.dto;

import com.controleservico.os.model.People;
import com.controleservico.os.model.enums.AddressType;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class AddressDto {

    private AddressType addressType;

    private int number;

    private String district;

    private String city;

    private String cep;

    private String complement;

    private PeopleDto owner;

    public AddressDto(AddressType addressType, int number, String district, String city, String cep, String complement, PeopleDto owner) {
        this.addressType = addressType;
        this.number = number;
        this.district = district;
        this.city = city;
        this.cep = cep;
        this.complement = complement;
        this.owner = owner;
    }

    public AddressType getAddressType() {
        return addressType;
    }

    public int getNumber() {
        return number;
    }

    public String getDistrict() {
        return district;
    }

    public String getCity() {
        return city;
    }

    public String getCep() {
        return cep;
    }

    public String getComplement() {
        return complement;
    }

    public PeopleDto getOwner() {
        return owner;
    }

    public void setOwner(PeopleDto owner) {
        this.owner = owner;
    }
}
