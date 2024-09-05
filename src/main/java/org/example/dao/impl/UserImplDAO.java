package org.example.dao.impl;

import org.example.dao.inter.UserDAO;
import org.example.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserImplDAO implements UserDAO {

    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "admin";
    private List<User> participants;

    public UserImplDAO() {
        this.participants = new ArrayList<>();
    }

    @Override
    public String login(String username, String password) {
        if (ADMIN_USERNAME.equals(username) && ADMIN_PASSWORD.equals(password)) {
            return ADMIN_USERNAME;
        } else {
            for (User participant : participants) {
                if (participant.getUsername().equals(username)) {
                    if (participant.getPassword().equals(password)) {
                        return participant.getUsername();
                    } else {
                        return null ;//"Mot de passe incorrect";
                    }
                }
            }
        }
        return null;
    }
}
