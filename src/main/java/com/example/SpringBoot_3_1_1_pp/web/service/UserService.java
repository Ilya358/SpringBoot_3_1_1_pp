package com.example.SpringBoot_3_1_1_pp.web.service;

import com.example.SpringBoot_3_1_1_pp.web.model.User;

import java.util.List;


public interface UserService {
    void add(User user);
    User getUserById(Long id);
    User getUserByName(String name);
    List<User> listUsers();
    void updateUser(User user);
    void deleteUser(Long id);
}
