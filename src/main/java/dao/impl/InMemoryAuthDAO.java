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
    public boolean RegisterParticipant(Participant participant) {
        if (users.containsKey(participant.getEmail())) {
            return false; // Utilisateur déjà existant
        }
        users.put(participant.getEmail(), participant);
        return true; // Inscription réussie
    }

    @Override
    public boolean UnsubscribeParticipant(Participant participant) {
        User user = users.get(participant.getEmail());
        if (user != null && user.getPassword().equals(participant.getPassword()) && user.getRole() == Role.PARTICIPANT) {
            users.remove(participant.getEmail());
            return true; // Désinscription réussie
        }
        return false; // Échec de la désinscription
    }

    public User authenticate(String email, String password) {
        User user = users.get(email);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null; // Authentification échouée
    }
}
