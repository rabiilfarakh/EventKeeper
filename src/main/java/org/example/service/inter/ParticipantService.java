package org.example.service.inter;

import org.example.entity.Participant;

import java.util.List;

public interface ParticipantService {

    void register(Participant participant);

    void addParticipant(Participant participant);

    void updateParticipant(Integer participantId, Participant participant);

    void deleteParticipant(Integer participantId);

    List<Participant> getParticipants();

}
