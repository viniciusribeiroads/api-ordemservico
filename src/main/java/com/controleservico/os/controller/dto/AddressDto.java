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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AddressDto)) return false;

        AddressDto that = (AddressDto) o;

        if (number != that.number) return false;
        if (addressType != that.addressType) return false;
        if (district != null ? !district.equals(that.district) : that.district != null) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        if (cep != null ? !cep.equals(that.cep) : that.cep != null) return false;
        if (complement != null ? !complement.equals(that.complement) : that.complement != null) return false;
        return owner != null ? owner.equals(that.owner) : that.owner == null;
    }

    @Override
    public int hashCode() {
        int result = addressType != null ? addressType.hashCode() : 0;
        result = 31 * result + number;
        result = 31 * result + (district != null ? district.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (cep != null ? cep.hashCode() : 0);
        result = 31 * result + (complement != null ? complement.hashCode() : 0);
        result = 31 * result + (owner != null ? owner.hashCode() : 0);
        return result;
    }
}
