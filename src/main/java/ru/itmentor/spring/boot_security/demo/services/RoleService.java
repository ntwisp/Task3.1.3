package ru.itmentor.spring.boot_security.demo.services;

import ru.itmentor.spring.boot_security.demo.models.Role;
import java.util.List;

public interface RoleService {
    List<Role> findAll();
    Role findRoleByName(String roleName);
}