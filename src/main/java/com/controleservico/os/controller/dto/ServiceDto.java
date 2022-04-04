package com.controleservico.os.controller.dto;

import com.controleservico.os.model.Client;
import com.controleservico.os.model.Driver;
import com.controleservico.os.model.Vehicle;
import com.controleservico.os.model.enums.Status;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.Instant;
import java.util.Date;

public class ServiceDto {


    private Date date;

    private String description;

    private Status status;

    private Driver driverService;

    private Vehicle vehicleService;

    private Client client;

    private Vehicle vehicleClient;

    public ServiceDto(){}

    public ServiceDto(String description, Driver driverService, Vehicle vehicleService, Client client, Vehicle vehicleClient) {
        this.date = Date.from(Instant.now());
        this.status = Status.getStatusByCode(1);
        this.description = description;
        this.driverService = driverService;
        this.vehicleService = vehicleService;
        this.client = client;
        this.vehicleClient = vehicleClient;
    }

    public ServiceDto(Date date,String description, int statusCode, Driver driverService, Vehicle vehicleService, Client client, Vehicle vehicleClient) {
        this.date = date;
        this.description = description;
        this.status = Status.getStatusByCode(statusCode);
        this.driverService = driverService;
        this.vehicleService = vehicleService;
        this.client = client;
        this.vehicleClient = vehicleClient;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
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
