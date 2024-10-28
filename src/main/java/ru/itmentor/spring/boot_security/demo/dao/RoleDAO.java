package ru.itmentor.spring.boot_security.demo.dao;

import ru.itmentor.spring.boot_security.demo.models.Role;

import java.util.List;

public interface RoleDAO {
    Role findRoleByName(String roleName);
    List<Role> findAll();
}
