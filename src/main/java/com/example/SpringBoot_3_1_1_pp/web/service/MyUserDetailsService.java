package com.example.SpringBoot_3_1_1_pp.web.service;

import com.example.SpringBoot_3_1_1_pp.web.dao.UserDao;
import com.example.SpringBoot_3_1_1_pp.web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        User user = userDao.getUserByName(name);

        if (user == null) {
            throw new UsernameNotFoundException(name + "not found!");
        }
        return user;
    }
}
