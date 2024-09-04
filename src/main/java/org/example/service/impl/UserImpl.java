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
    public void login(User user) {
        userDAO.login(user);
    }
}
