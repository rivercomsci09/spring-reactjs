package com.river.devicesmanagement.service;

import com.river.devicesmanagement.model.Equipment;

import java.util.List;
import java.util.Optional;

public interface EquipmentService {
    List<Equipment> findAllEquipment();

    Optional<Equipment> findById(Integer id);

    void save(Equipment equipment);

    void remove(Equipment equipment);

}
