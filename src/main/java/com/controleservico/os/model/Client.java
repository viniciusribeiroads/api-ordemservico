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

    @OneToMany(cascade=CascadeType.PERSIST)
    @JoinTable(name = "client_address")
    private List<AddressUser> listAddress;


    public long getId() {
        return id;
    }

    public People getClient() {
        return client;
    }

    public List<AddressUser> getListAddress() {
        return listAddress;
    }

    public Client() {
    }

    public Client(long id, People client, List<AddressUser> listAddress) {
        this.id = id;
        this.client = client;
        this.listAddress = listAddress;
    }

    public Client(People client, List<AddressUser> listAddress) {
        this.client = client;
        this.listAddress = listAddress;
    }
}
