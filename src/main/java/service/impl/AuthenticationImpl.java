package service.impl;

import dao.inter.AuthDAO;
import entity.Participant;
import entity.User;
import service.inter.AuthenticationService;

import java.util.Random;

public class AuthenticationImpl implements AuthenticationService {

    private final AuthDAO authDAO;
    private final Random random = new Random();

    public AuthenticationImpl(AuthDAO authDAO) {
        this.authDAO = authDAO;
    }

    @Override
    public boolean registerParticipant(String username, String email, String password) {
        Long id = random.nextLong(1000000L) + 1;
        Participant participant = new Participant(id, username, email, password, "Unknown");
        return authDAO.RegisterParticipant(participant);
    }

    @Override
    public boolean unsubscribeParticipant(String email, String password) {
        Participant participant = new Participant(null, null, email, password, null);
        return authDAO.UnsubscribeParticipant(participant);
    }

    @Override
    public User authenticate(String email, String password) {
        return authDAO.authenticate(email, password);
    }

}
