package com.controleservico.os.controller;

import com.controleservico.os.controller.dto.ServiceDto;
import com.controleservico.os.model.Service;
import com.controleservico.os.service.ServiceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/services")
public class ServiceController {

    private final ServiceService service;

    public ServiceController(ServiceService service){
        this.service = service;
    }

    @GetMapping("/all")
    public List<ServiceDto> getAll(){
        return service.findAll();
    }

    @PostMapping("/new")
    public ResponseEntity<Service> save(@RequestBody ServiceDto serviceDto){
        return service.save(serviceDto);
    }



}
