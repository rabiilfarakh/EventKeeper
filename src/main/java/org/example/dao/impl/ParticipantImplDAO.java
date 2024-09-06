package org.example.dao.impl;

import org.example.dao.inter.ParticipantDAO;
import org.example.entity.Participant;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class ParticipantImplDAO implements ParticipantDAO {

    private Map<Integer, Participant> participants;
    private int currentId = 1;


    public ParticipantImplDAO(Map<Integer, Participant> participants) {
        this.participants = participants;
    }

    @Override
    public void register(Participant participant) {
        participant.setId(currentId++);
        participants.put(participant.getId(), participant);
        System.out.println("Participant enregistré : " + participant.getUsername());
    }

    @Override
    public void addParticipant(Participant participant) {
        participants.put(participant.getId(), participant);
        System.out.println("Participant ajouté : " + participant.getUsername());
    }

    @Override
    public void updateParticipant(Integer participantId, Participant participant) {
        participants.put(participantId, participant);
        System.out.println("Participant mis à jour : " + participant.getUsername());
    }

    @Override
    public void deleteParticipant(Integer participantId) {
        participants.remove(participantId);
        System.out.println("Participant supprimé : " + participantId);
    }

    @Override
    public List<Participant> getParticipants() {
        return new ArrayList<>(participants.values());
    }
}
