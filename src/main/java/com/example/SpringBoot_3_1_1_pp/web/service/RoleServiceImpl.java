package com.example.SpringBoot_3_1_1_pp.web.service;

import com.example.SpringBoot_3_1_1_pp.web.dao.RoleDao;
import com.example.SpringBoot_3_1_1_pp.web.model.Role;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@ToString
public class RoleServiceImpl implements RoleService {

    private RoleDao roleDao;

    @Autowired
    public void setUserDAO(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Transactional
    @Override
    public Role getById(Long id) {
        return roleDao.getById(id);
    }

    @Transactional
    @Override
    public Role getRoleByName(String name) {
        return roleDao.getRoleByName(name);
    }

    @Transactional
    @Override
    public List<Role> roleList(){
        return  roleDao.getRoleList();
    }
}
