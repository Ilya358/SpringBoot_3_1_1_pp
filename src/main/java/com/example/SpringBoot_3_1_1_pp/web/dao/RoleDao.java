package com.example.SpringBoot_3_1_1_pp.web.dao;

import com.example.SpringBoot_3_1_1_pp.web.model.Role;

import java.util.List;

public interface RoleDao {
    Role getById(Long id);
    Role getRoleByName(String name);
    List<Role> getRoleList();
}
