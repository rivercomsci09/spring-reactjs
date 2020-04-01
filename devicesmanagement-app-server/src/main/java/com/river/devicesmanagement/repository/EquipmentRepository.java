package com.river.devicesmanagement.repository;

import com.river.devicesmanagement.model.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipmentRepository extends JpaRepository<Equipment, Integer> {
    @Query("SELECT e.id,e.name,e.type,e.description,e.status, a.username FROM Equipment e INNER JOIN e.account a ORDER BY e.id ASC")
    List<Object[]> getEquipment();
}
