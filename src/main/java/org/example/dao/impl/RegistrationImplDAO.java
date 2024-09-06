package org.example.dao.impl;

import org.example.dao.inter.RegistrationDAO;
import org.example.entity.Evenement;
import org.example.entity.Participant;
import org.example.entity.Registration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RegistrationImplDAO implements RegistrationDAO {

    private Map<Evenement, Participant> participantInEvent ;
    private List<Evenement> eventList ;
    private Map<Integer, Participant> participants ;

    public RegistrationImplDAO(Map<Evenement, Participant> participantInEvent,List<Evenement> eventList,Map<Integer, Participant> participants) {
        this.participants = participants;
        this.eventList = eventList;
        this.participantInEvent = participantInEvent;
    }

    @Override
    public void registerInEvent(Integer eventId, Integer participantId) {
        // Rechercher l'événement par son ID dans la liste des événements
        Evenement foundEvent = eventList.stream()
                .filter(event -> event.getId().equals(eventId))
                .findFirst()
                .orElse(null); // Si l'événement n'est pas trouvé, retourne null

        // Rechercher le participant par son ID dans le map des participants
        Participant foundParticipant = participants.get(participantId);

        // Vérifier si l'événement et le participant existent
        if (foundEvent != null && foundParticipant != null) {
            // Ajouter l'événement et le participant à la Map
            participantInEvent.put(foundEvent, foundParticipant);
            System.out.println("Participant enregistré avec succès à l'événement.");
        } else {
            // Gestion des cas où l'événement ou le participant n'existent pas
            if (foundEvent == null) {
                System.out.println("Événement avec ID " + eventId + " non trouvé.");
            }
            if (foundParticipant == null) {
                System.out.println("Participant avec ID " + participantId + " non trouvé.");
            }
        }
    }


    @Override
    public void unregister(Integer eventId, Integer participantId) {
        // Rechercher l'événement par son ID
        Evenement foundEvent = eventList.stream()
                .filter(event -> event.getId().equals(eventId))
                .findFirst()
                .orElse(null);

        // Rechercher le participant par son ID
        Participant foundParticipant = participants.get(participantId);

        // Vérifier si l'événement et le participant existent
        if (foundEvent != null && foundParticipant != null) {
            // Vérifier si le participant est inscrit à l'événement
            if (participantInEvent.containsKey(foundEvent) && participantInEvent.get(foundEvent).equals(foundParticipant)) {
                participantInEvent.remove(foundEvent);
                System.out.println("Participant désinscrit avec succès de l'événement.");
            } else {
                System.out.println("Le participant n'est pas inscrit à cet événement.");
            }
        } else {
            if (foundEvent == null) {
                System.out.println("Événement avec ID " + eventId + " non trouvé.");
            }
            if (foundParticipant == null) {
                System.out.println("Participant avec ID " + participantId + " non trouvé.");
            }
        }
    }

    @Override
    public List<Evenement> registration(Integer participantId) {
        Participant foundParticipant = participants.get(participantId);

        if (foundParticipant == null) {
            System.out.println("Participant avec ID " + participantId + " non trouvé.");
            return new ArrayList<>(); // Retourne une liste vide si le participant n'existe pas
        }

        // Retourner la liste des événements auxquels le participant est inscrit
        List<Evenement> registeredEvents = new ArrayList<>();
        for (Map.Entry<Evenement, Participant> entry : participantInEvent.entrySet()) {
            if (entry.getValue().equals(foundParticipant)) {
                registeredEvents.add(entry.getKey());
            }
        }

        return registeredEvents;
    }


    @Override
    public List<Registration> getReportOfParticipant(String username) {
        return List.of();
    }

    @Override
    public List<Registration> getReportOfEvent(Integer eventID) {
        return List.of();
    }
}
