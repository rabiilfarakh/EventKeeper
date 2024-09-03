package service.inter;

import entity.Participant;
import entity.User;

public interface AuthenticationService {

    boolean registerParticipant(String username, String email, String password);
    User authenticate(String email, String password);
}
