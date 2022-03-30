package com.controleservico.os.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Driver{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @JoinColumn(name = "driver")
    private People driver;

    @OneToMany
    @JoinTable(name = "driver_address")
    private List<AddressUser> listAddress;


}
