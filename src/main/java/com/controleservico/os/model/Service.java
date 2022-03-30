package com.controleservico.os.model;

import javax.persistence.*;
import javax.xml.crypto.Data;
import java.util.Date;

@Entity
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date date;

    private String description;

    @ManyToOne
    @JoinColumn(name = "driver_id")
    private Driver driverService;

    @ManyToOne
    @JoinColumn(name = "vehicleService_id")
    private Vehicle vehicleService;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "vehicleClient_id")
    private Vehicle vehicleClient;

    public Service() {
    }

    public Service(Long id, Date date, String description, Driver driverService, Vehicle vehicleService, Client client, Vehicle vehicleClient) {
        this.id = id;
        this.date = date;
        this.description = description;
        this.driverService = driverService;
        this.vehicleService = vehicleService;
        this.client = client;
        this.vehicleClient = vehicleClient;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Driver getDriverService() {
        return driverService;
    }

    public void setDriverService(Driver driverService) {
        this.driverService = driverService;
    }

    public Vehicle getVehicleService() {
        return vehicleService;
    }

    public void setVehicleService(Vehicle vehicleService) {
        this.vehicleService = vehicleService;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Vehicle getVehicleClient() {
        return vehicleClient;
    }

    public void setVehicleClient(Vehicle vehicleClient) {
        this.vehicleClient = vehicleClient;
    }
}
