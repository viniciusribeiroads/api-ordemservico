package com.controleservico.os.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Driver{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name = "driver")
    private People driver;

    @OneToMany(cascade=CascadeType.PERSIST)
    @JoinTable(name = "driver_address")
    private List<AddressUser> listAddress;

    public Driver() {
    }

    public Driver(long id, People driver, List<AddressUser> listAddress) {
        this.id = id;
        this.driver = driver;
        this.listAddress = listAddress;
    }

    public Driver(People driver, List<AddressUser> listAddress) {
        this.driver = driver;
        this.listAddress = listAddress;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public People getDriver() {
        return driver;
    }

    public void setDriver(People driver) {
        this.driver = driver;
    }

    public List<AddressUser> getListAddress() {
        return listAddress;
    }

    public void setListAddress(List<AddressUser> listAddress) {
        this.listAddress = listAddress;
    }
}
