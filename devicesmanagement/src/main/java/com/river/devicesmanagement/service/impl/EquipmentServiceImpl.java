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
    @Autowired
    EquipmentRepository equipmentRepository;

    @Override
    public void save(Equipment equipment) {
        equipmentRepository.save(equipment);
    }

    @Override
    public void save(Equipment equiment, int id) {
        equiment.setId(id);
        equipmentRepository.save(equiment);
    }

    @Override
    public List<Equipment> findAllEquipment() {
        return equipmentRepository.findAll();
    }

    @Override
    public Optional<Equipment> findById(int id) {
        return equipmentRepository.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        equipmentRepository.deleteById(id);
    }

    @Override
    public List<Object[]> getEquipment() {
        return equipmentRepository.getEquipment();
    }
}
