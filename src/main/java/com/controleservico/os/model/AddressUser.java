package com.controleservico.os.model;

import com.controleservico.os.model.enums.AddressType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.persistence.*;

@Entity
public class AddressUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private AddressType addressType;

    @NotNull
    private int number;

    @NotNull
    private String district;

    @NotNull
    private String city;

    @NotNull
    private String cep;

    @NotNull
    private String complement;


    @NotNull
    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name = "owner_id")
    private People owner;


    public AddressUser(Long id, int addressType, int number, String district, String city, String cep, String complement, People owner) {
        this.id = id;
        this.addressType = AddressType.getById(addressType);
        this.number = number;
        this.district = district;
        this.city = city;
        this.cep = cep;
        this.complement = complement;
        this.owner = owner;
    }

    public AddressUser() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AddressType getAddressType() {
        return addressType;
    }

    public void setAddressType(AddressType addressType) {
        this.addressType = addressType;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public People getOwner() {
        return owner;
    }

    public void setOwner(People owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "AddressUser{" +
                "id=" + id +
                ", addressType=" + addressType +
                ", number=" + number +
                ", district='" + district + '\'' +
                ", city='" + city + '\'' +
                ", cep='" + cep + '\'' +
                ", complement='" + complement + '\'' +
                ", owner=" + owner +
                '}';
    }
}
