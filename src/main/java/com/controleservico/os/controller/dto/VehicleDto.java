package com.controleservico.os.controller.dto;

public class VehicleDto {

    private Long id;

    private String model;

    private String manufacturer;

    private String plate;

    public VehicleDto(Long id, String model, String manufacturer, String plate) {
        this.id = id;
        this.model = model;
        this.manufacturer = manufacturer;
        this.plate = plate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }
}
