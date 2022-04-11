package com.controleservico.os.model;

import com.controleservico.os.model.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dateInit;

    private Date dateFinalized;

    private String description;

    private Status status;

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

    public Service(Long id, Date date, int statusCode, String description, Driver driverService, Vehicle vehicleService, Client client, Vehicle vehicleClient) {
        this.id = id;
        this.dateInit = date;
        this.description = description;
        this.status = Status.getStatusByCode(statusCode);
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

    public Date getDateInit() {
        return dateInit;
    }

    public void setDateInit(Date dateInit) {
        this.dateInit = dateInit;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
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

    public void finalizeOrder(Date dateFinalized){
        this.dateFinalized = dateFinalized;
        this.status = Status.CLOSE;
    }



    @Override
    public String toString() {
        return "Service{" +
                "id=" + id +
                ", dateInit=" + dateInit +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", driverService=" + driverService +
                ", vehicleService=" + vehicleService +
                ", client=" + client +
                ", vehicleClient=" + vehicleClient +
                '}';
    }


}
