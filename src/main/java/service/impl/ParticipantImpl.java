package service.impl;

import entity.Participant;
import service.inter.ParticipantService;

import java.util.List;
import java.util.Optional;

public class ParticipantImpl implements ParticipantService {

    @Override
    public Participant addParticipant(Participant participant) {
        return null;
    }

    @Override
    public Participant updateParticipant(int participantId, Participant participant) {
        return null;
    }

    @Override
    public void deleteParticipant(int participantId) {

    }

    @Override
    public Optional<Participant> getParticipantById(int participantId) {
        return Optional.empty();
    }

    public List<Participant> getAllParticipants() {
        return List.of();
    }
}
