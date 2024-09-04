package org.example.dao.inter;

import org.example.entity.Participant;

import java.util.List;

public interface ParticipantDAO {

    void register(Participant participant);

    void addParticipant(Participant participant);

    void updateParticipant(Integer participantId, Participant participant);

    void deleteParticipant(Integer participantId);

    List<Participant> getParticipants();

}
