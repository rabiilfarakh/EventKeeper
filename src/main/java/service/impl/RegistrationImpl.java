package service.impl;

import entity.Evenement;
import entity.Participant;
import service.inter.RegistrationService;

import java.util.List;

public class RegistrationImpl implements RegistrationService {

    @Override
    public void RegisterParticipant(Long evenementId, Long participantId) {

    }

    @Override
    public void UnsubscribeParticipant(Long evenementId, Long participantId) {

    }

    @Override
    public List<Participant> getParticipantsForEvenement(Long evenementId) {
        return List.of();
    }

    @Override
    public List<Evenement> getEvenementsForParticipant(Long participantId) {
        return List.of();
    }
}
