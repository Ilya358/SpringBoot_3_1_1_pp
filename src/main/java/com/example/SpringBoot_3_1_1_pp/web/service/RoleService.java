package com.example.SpringBoot_3_1_1_pp.web.service;

import com.example.SpringBoot_3_1_1_pp.web.model.Role;

import java.util.List;

public interface RoleService {

    Role getById(Long id);

    Role getRoleByName(String name);

    List<Role> roleList();
}
