package com.rest.app.service;

import com.rest.app.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface UserService {
    User findByUserName(User user) throws SQLException;
    Float getMoney(String userName);

    User saveUser(User user) throws SQLException;
    List<User> findAll();
}
