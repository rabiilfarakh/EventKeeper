package dao.impl;

import dao.inter.AuthDAO;
import entity.Admin;
import entity.Participant;
import entity.User;
import enumeration.Role;

import java.util.HashMap;
import java.util.Map;
public class InMemoryAuthDAO implements AuthDAO {
    private final Map<String, User> users = new HashMap<>();
    private final Admin admin;

    public InMemoryAuthDAO() {
        admin = new Admin(1L, "admin", "admin@gmail.com", "admin", Role.ADMIN);
        users.put(admin.getEmail(), admin);
    }

    @Override
    public boolean registerParticipant(Participant participant) {
        if (users.containsKey(participant.getEmail())) {
            return false;
        }
        users.put(participant.getEmail(), participant);
        return true;
    }

    @Override
    public User authenticate(String email, String password) {
        User user = users.get(email);
        return user != null && user.getPassword().equals(password) ? user : null;
    }
}