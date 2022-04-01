package com.controleservico.os.controller;

import com.controleservico.os.controller.dto.ClientDto;
import com.controleservico.os.controller.dto.DriverDto;
import com.controleservico.os.model.Client;
import com.controleservico.os.model.Driver;
import com.controleservico.os.service.ClientService;
import com.controleservico.os.service.DriverService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/drivers")
@AllArgsConstructor
public class DriverController {

    private DriverService driverService;

    @GetMapping(path = "/all")
    public List<DriverDto> listAll(){
        return driverService.listAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<DriverDto> findBy(@PathVariable Long id){
        return driverService.findBy(id);
    }

    @PostMapping(path = "/new")
    public ResponseEntity<Driver> create(@RequestBody DriverDto driverDto){
        return driverService.create(driverDto);
    }

    @PutMapping(path = "/update")
    public ResponseEntity<Driver> update(@RequestBody Driver driver){
        return driverService.update(driver);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity deleteBy(@PathVariable Long id){
        return driverService.deleteBy(id);
    }
}
