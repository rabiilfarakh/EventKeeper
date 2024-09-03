package service.impl;

import dao.inter.ParticipantDAO;
import entity.Participant;
import service.inter.ParticipantService;

import java.util.List;

public class ParticipantImpl implements ParticipantService {
    private final ParticipantDAO participantDAO;

    public ParticipantImpl(ParticipantDAO participantDAO) {
        this.participantDAO = participantDAO;
    }

    @Override
    public boolean deleteParticipant(Long participantId) {
        return participantDAO.deleteParticipant(participantId);
    }

    @Override
    public List<Participant> getAllParticipants() {
        return participantDAO.getAllParticipants();
    }

    @Override
    public void updateParticipant(Long participantId, Participant participant) {
        participantDAO.updateParticipant(participantId, participant);
    }
}