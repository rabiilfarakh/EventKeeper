package service.inter;

import entity.Evenement;
import entity.Participant;

import java.util.List;

public interface RegistrationService {
    void RegisterParticipant(Long evenementId, Long participantId);
    void UnsubscribeParticipant(Long evenementId, Long participantId);
    List<Participant> getParticipantsForEvenement(Long evenementId);
    List<Evenement> getEvenementsForParticipant(Long participantId);
}
