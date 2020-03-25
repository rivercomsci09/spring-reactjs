package com.river.devicesmanagement.service.impl;

import com.river.devicesmanagement.model.Equipment;
import com.river.devicesmanagement.repository.EquipmentRepository;
import com.river.devicesmanagement.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipmentServiceImpl implements EquipmentService {
    private EquipmentRepository equipmentRepository;

    @Autowired
    public EquipmentServiceImpl(EquipmentRepository equipmentRepository) {
        this.equipmentRepository = equipmentRepository;
    }

    @Override
    public List<Equipment> findAllEquipment() {
        return (List<Equipment>) equipmentRepository.findAll();
    }

    @Override
    public Optional<Equipment> findById(Integer id) {
        return equipmentRepository.findById(id);
    }

    @Override
    public void save(Equipment equipment) {
        equipmentRepository.save(equipment);
    }

    @Override
    public void remove(Equipment equipment) {
        equipmentRepository.delete(equipment);
    }
}
