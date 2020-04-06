package com.river.devicesmanagement.service.impl;

import com.river.devicesmanagement.model.Role;
import com.river.devicesmanagement.repository.RoleRepository;
import com.river.devicesmanagement.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleRepository roleRepository;

    public Optional<Role> findByName(String name){
        return roleRepository.findByRolename(name);
    }
}
