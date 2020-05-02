package com.example.SpringBoot_3_1_1_pp.web.dao;

import com.example.SpringBoot_3_1_1_pp.web.model.User;

import java.util.List;

public interface UserDao {
    void add(User user);

    User getUserById(Long id);

    List<User> listUsers();

    void updateUser(User user);

    void deleteUser(Long id);

    User getUserByName(String name);
}
