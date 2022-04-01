package com.controleservico.os.controller;

import com.controleservico.os.controller.dto.ClientDto;
import com.controleservico.os.controller.dto.VehicleDto;
import com.controleservico.os.model.Client;
import com.controleservico.os.model.Vehicle;
import com.controleservico.os.service.ClientService;
import com.controleservico.os.service.VehicleService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
@AllArgsConstructor
public class VehicleController {

    private VehicleService vehicleService;

    @GetMapping(path = "/all")
    public List<VehicleDto> listAll(){
        return vehicleService.listAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<VehicleDto> findBy(@PathVariable Long id){
        return vehicleService.findBy(id);
    }

    @PostMapping(path = "/new")
    public ResponseEntity<Vehicle> create(@RequestBody VehicleDto vehicleDto){
        return vehicleService.create(vehicleDto);
    }

    @PutMapping(path = "/update")
    public ResponseEntity<Vehicle> update(@RequestBody Vehicle vehicle){
        return vehicleService.update(vehicle);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity deleteBy(@PathVariable Long id){
        return vehicleService.deleteBy(id);
    }
}
