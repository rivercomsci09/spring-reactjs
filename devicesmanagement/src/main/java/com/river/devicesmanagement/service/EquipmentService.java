package com.river.devicesmanagement.service;

import com.river.devicesmanagement.model.Equipment;

import java.util.List;
import java.util.Optional;

public interface EquipmentService {
    void save(Equipment equipment);

    void save(Equipment equiment, int id);

    List<Equipment> findAllEquipment();

    Optional<Equipment> findById(int id);

    void deleteById(Integer id);

    List<Object[]> getEquipment();
}
