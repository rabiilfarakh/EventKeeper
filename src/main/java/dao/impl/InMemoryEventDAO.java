// InMemoryEventDAO.java
package dao.impl;

import dao.inter.EventDAO;
import dao.inter.ParticipantDAO;
import entity.Evenement;
import entity.Participant;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class InMemoryEventDAO implements EventDAO {
    private final List<Evenement> events = new ArrayList<>();
    private final Map<Long, List<Participant>> eventParticipants = new HashMap<>();
    private final ParticipantDAO participantDAO;

    public InMemoryEventDAO(ParticipantDAO participantDAO) {
        this.participantDAO = participantDAO;
    }

    @Override
    public void addEvent(Evenement event) {
        events.add(event);
        eventParticipants.put(event.getId(), new ArrayList<>());
    }

    @Override
    public void updateEvent(Long eventId, Evenement updatedEvent) {
        for (int i = 0; i < events.size(); i++) {
            if (events.get(i).getId().equals(eventId)) {
                events.set(i, updatedEvent);
                eventParticipants.put(eventId, new ArrayList<>(updatedEvent.getParticipants()));
                return;
            }
        }
    }

    @Override
    public void deleteEvent(Long eventId) {
        events.removeIf(event -> event.getId().equals(eventId));
        eventParticipants.remove(eventId);
    }

    @Override
    public Evenement getEventById(Long eventId) {
        for (Evenement event : events) {
            if (event.getId().equals(eventId)) {
                return event;
            }
        }
        return null; // Or throw an exception if that's more appropriate
    }

    @Override
    public List<Evenement> getAllEvents() {
        return new ArrayList<>(events);
    }

    @Override
    public List<Evenement> searchEvents(String criterion) {
        List<Evenement> result = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        boolean isDateCriterion = false;

        Date criterionDate = null;
        try {
            criterionDate = dateFormat.parse(criterion);
            isDateCriterion = true;
        } catch (ParseException e) {
            // Not a date criterion
        }

        for (Evenement event : events) {
            boolean matches = false;

            if (isDateCriterion) {
                if (event.getDate().equals(criterionDate)) {
                    matches = true;
                }
            } else {
                if (event.getTitle().contains(criterion) || event.getType().contains(criterion)) {
                    matches = true;
                }
            }

            if (matches) {
                result.add(event);
            }
        }

        return result;
    }

    @Override
    public void addParticipantToEvent(Long eventId, Long participantId) {
        Evenement event = getEventById(eventId);
        if (event != null) {
            Participant participant = participantDAO.getParticipantById(participantId);
            if (participant != null) {
                List<Participant> participants = eventParticipants.get(eventId);
                if (participants != null) {
                    participants.add(participant);
                    event.addParticipant(participant);
                    updateEvent(eventId, event);
                } else {
                    System.out.println("Participants list for the event is missing.");
                }
            } else {
                System.out.println("Participant not found.");
            }
        } else {
            System.out.println("Event not found.");
        }
    }
}
