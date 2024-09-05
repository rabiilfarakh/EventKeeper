package org.example.service.impl;

import org.example.dao.inter.UserDAO;
import org.example.entity.User;
import org.example.service.inter.UserService;

public class UserImpl implements UserService {

    private final UserDAO userDAO;

    public UserImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public String login(String username, String password) {
        return userDAO.login(username,password);
    }
}
