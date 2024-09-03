package dao.inter;

import entity.Participant;
import entity.User;

public interface AuthDAO {
    boolean registerParticipant(Participant participant);
    User authenticate(String email, String password);
}
