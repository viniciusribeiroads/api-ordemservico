package com.controleservico.os.controller;

import com.controleservico.os.controller.dto.AddressDto;
import com.controleservico.os.model.AddressUser;
import com.controleservico.os.service.AddressService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
@AllArgsConstructor
public class AddressController {

    private AddressService addressService;

    @GetMapping("/all")
    public List<AddressDto> getAll(){
        return addressService.getAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<AddressDto> findBy(@PathVariable Long id){
        return addressService.findBy(id);
    }

    @PostMapping
    @RequestMapping("/new")
    public ResponseEntity<AddressDto> save(@RequestBody AddressDto addressDto){
        return new ResponseEntity<>(addressService.save(addressDto), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/remove/{id}")
    public ResponseEntity deleteBy(@PathVariable Long id) {
        return addressService.deleteBy(id);
    }

    @PutMapping(path = "/update")
    public ResponseEntity<AddressUser> update(@RequestBody AddressUser addressUser){
        return addressService.update(addressUser);
    }











}
