package dao.inter;

import entity.Participant;
import entity.User;

public interface AuthDAO {
    // Méthode pour enregistrer un nouveau participant
    boolean RegisterParticipant(Participant participant);

    // Méthode pour désinscrire un participant existant
    boolean UnsubscribeParticipant(Participant participant);

    // Méthode pour authentifier un utilisateur (pour la connexion)
    User authenticate(String email, String password);
}
