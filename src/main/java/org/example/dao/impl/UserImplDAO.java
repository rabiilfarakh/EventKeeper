package org.example.dao.impl;

import org.example.dao.inter.UserDAO;
import org.example.entity.Participant;

import java.util.Map;

public class UserImplDAO implements UserDAO {

    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "admin";
    private Map<Integer, Participant> participants;

    // Inject the same Map of participants used by ParticipantImplDAO
    public UserImplDAO(Map<Integer, Participant> participants) {
        this.participants = participants;
    }

    @Override
    public String login(String username, String password) {
        if (ADMIN_USERNAME.equals(username) && ADMIN_PASSWORD.equals(password)) {
            return ADMIN_USERNAME;
        } else {
            for (Participant participant : participants.values()) {
                if (participant.getUsername().equals(username)) {
                    if (participant.getPassword().equals(password)) {
                        return participant.getUsername();
                    } else {
                        return "Mot de passe incorrect";
                    }
                }
            }
        }
        return null;
    }
}
