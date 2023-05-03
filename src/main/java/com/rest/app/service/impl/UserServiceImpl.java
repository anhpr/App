package com.rest.app.service.impl;

import com.rest.app.entity.User;
import com.rest.app.repository.UserRepository;
import com.rest.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User findByUserName(User user) {
        User userResult = userRepository.findByName(user.getName());
//        if(u)
        return userResult;
    }

    @Override
    public Float getMoney(String userName) {
        return null;
    }

    @Override
    public User saveUser(User user) {
        user.setMoney();
        return userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
