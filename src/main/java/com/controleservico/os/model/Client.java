package com.controleservico.os.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Client{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @JoinColumn(name = "client")
    private People client;

    @OneToMany
    @JoinTable(name = "client_address")
    private List<AddressUser> listAddress;




}
