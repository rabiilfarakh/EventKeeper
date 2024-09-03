package dao.impl;

import dao.inter.ParticipantDAO;
import entity.Participant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class InMemoryParticipantDAO implements ParticipantDAO {
    private final Map<Long, Participant> participants = new HashMap<>();
    private Long idCounter = 1L;

    @Override
    public boolean deleteParticipant(Long participantId) {
        if (participants.containsKey(participantId)) {
            participants.remove(participantId);
            return true;
        }
        return false;
    }

    @Override
    public List<Participant> getAllParticipants() {
        return new ArrayList<>(participants.values());
    }

    @Override
    public void updateParticipant(Long participantId, Participant participant) {
        if (participants.containsKey(participantId)) {
            participants.put(participantId, participant);
        }
    }

    @Override
    public Participant getParticipantById(Long participantId) {
        return participants.get(participantId);
    }


/*    public void addParticipant(Participant participant) {
        participant.setId(idCounter++);
        participants.put(participant.getId(), participant);
    }*/
}