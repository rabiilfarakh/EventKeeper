package org.example.dao.impl;

import org.example.dao.inter.UserDAO;
import org.example.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserImplDAO implements UserDAO {

    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "admin";
    private List<User> participants = new ArrayList<>();

    @Override
    public String login(User user) {
        if (ADMIN_USERNAME.equals(user.getUsername()) && ADMIN_PASSWORD.equals(user.getPassword())) {
            return ADMIN_USERNAME;
        } else {

        }
        return null;
    }
}
