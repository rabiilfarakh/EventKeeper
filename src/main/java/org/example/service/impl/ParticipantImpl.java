package org.example.service.impl;

import org.example.dao.inter.ParticipantDAO;
import org.example.entity.Participant;
import org.example.service.inter.ParticipantService;

import java.util.List;

public class ParticipantImpl implements ParticipantService {

    private final ParticipantDAO participantDAO;

    public ParticipantImpl(ParticipantDAO participantDAO) {
        this.participantDAO = participantDAO;
    }

    @Override
    public void register(Participant participant) {
        participantDAO.register(participant);
    }

    @Override
    public void addParticipant(Participant participant) {
        participantDAO.addParticipant(participant);
    }

    @Override
    public void updateParticipant(Integer participantId, Participant participant) {
        participantDAO.updateParticipant(participantId,participant);
    }

    @Override
    public void deleteParticipant(Integer participantId) {
        participantDAO.deleteParticipant(participantId);
    }

    @Override
    public List<Participant> getParticipants() {
        return participantDAO.getParticipants();
    }
}
