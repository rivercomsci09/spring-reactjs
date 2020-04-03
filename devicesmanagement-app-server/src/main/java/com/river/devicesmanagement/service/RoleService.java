package com.river.devicesmanagement.service;

import com.river.devicesmanagement.model.Role;

import java.util.Optional;

public interface RoleService {
    Optional<Role> findByName(String name);
}
