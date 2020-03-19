package com.river.devicesmanagement.repository;

import com.river.devicesmanagement.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByRolename(String rolename);
}
