package service.inter;

import entity.Participant;
import entity.User;

public interface AuthenticationService {
    // Méthode pour enregistrer un nouveau participant
    boolean registerParticipant(String username, String email, String password);

    // Méthode pour désinscrire un participant existant
    boolean unsubscribeParticipant(String email, String password);

    // Méthode pour authentifier un utilisateur (connexion)
    User authenticate(String email, String password);
}
