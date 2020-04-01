package com.river.devicesmanagement.controller;

import com.river.devicesmanagement.model.Equipment;
import com.river.devicesmanagement.service.AccountService;
import com.river.devicesmanagement.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api")
public class EquipmentController {
    @Autowired
    private EquipmentService equipmentService;

    @RequestMapping(value = "/equipments", method = RequestMethod.GET)
    public ResponseEntity<List<Equipment>> findAllEquipment() {
        List<Equipment> equipments = equipmentService.findAllEquipment();
        if (equipments.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(equipments, HttpStatus.OK);
    }

    @RequestMapping(value = "/equipments/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Equipment> getEquipmentById(
            @PathVariable("id") Integer id) {
        Optional<Equipment> equipment = equipmentService.findById(id);
        if (!equipment.isPresent()) {
            return new ResponseEntity<>(equipment.get(), HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(equipment.get(), HttpStatus.OK);
    }

    @RequestMapping(value = "/equipments", method = RequestMethod.POST)
    public ResponseEntity<Equipment> createEquipment(@RequestBody Equipment equipment, UriComponentsBuilder builder) {
        equipmentService.save(equipment);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/equipments/{id}").buildAndExpand(equipment.getId()).toUri());
        return new ResponseEntity<>(equipment, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/equipments/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Equipment> updateEquipment(@PathVariable("id") Integer id, @RequestBody Equipment equipment) {
        Optional<Equipment> currentEquipment = equipmentService.findById(id);
        if (!currentEquipment.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        currentEquipment.get().setName(equipment.getName());
        currentEquipment.get().setType(equipment.getType());
        currentEquipment.get().setDescription(equipment.getDescription());
        currentEquipment.get().setStatus(equipment.isStatus());
        currentEquipment.get().setAccount(equipment.getAccount());
        equipmentService.save(currentEquipment.get());
        return new ResponseEntity<>(currentEquipment.get(), HttpStatus.OK);
    }

    @RequestMapping(value = "/equipments/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Equipment> deleteEquipment(@PathVariable("id") Integer id) {
        Optional<Equipment> equipment = equipmentService.findById(id);
        if (!equipment.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        equipmentService.remove(equipment.get());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
