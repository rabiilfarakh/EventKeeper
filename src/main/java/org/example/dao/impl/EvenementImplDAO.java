package org.example.dao.impl;

import org.example.dao.inter.EvenementDAO;
import org.example.entity.Evenement;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public class EvenementImplDAO implements EvenementDAO {

    private List<Evenement> eventList;
    private final AtomicInteger idCounter = new AtomicInteger(1); // Compteur pour générer des IDs uniques

    public EvenementImplDAO(List<Evenement> eventList) {
        this.eventList = eventList;
    }

    @Override
    public void addEvent(Evenement event) {
        if (event == null) {
            throw new IllegalArgumentException("Event cannot be null");
        }
        event.setId(idCounter.getAndIncrement()); // Génère un nouvel ID unique
        eventList.add(event);
    }

    @Override
    public void updateEvent(Integer eventId, Evenement event) {
        if (event == null) {
            throw new IllegalArgumentException("Event cannot be null");
        }
        // Recherche de l'événement existant
        Optional<Evenement> existingEventOpt = eventList.stream()
                .filter(e -> e.getId().equals(eventId))
                .findFirst();

        if (existingEventOpt.isPresent()) {
            Evenement existingEvent = existingEventOpt.get();
            existingEvent.setName(event.getName());
            existingEvent.setDate(event.getDate());
            existingEvent.setDescription(event.getDescription());
            existingEvent.setLocation(event.getLocation());
        } else {
            throw new IllegalArgumentException("Event with ID " + eventId + " does not exist");
        }
    }

    @Override
    public void deleteEvent(Integer eventId) {
        // Recherche et suppression de l'événement
        boolean removed = eventList.removeIf(e -> e.getId().equals(eventId));
        if (!removed) {
            throw new IllegalArgumentException("Event with ID " + eventId + " does not exist");
        }
    }

    @Override
    public List<Evenement> getAllEvents() {
        return new ArrayList<>(eventList);
    }

    @Override
    public Evenement getEvent(Integer eventId) {
        // Recherche de l'événement
        return eventList.stream()
                .filter(e -> e.getId().equals(eventId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Event with ID " + eventId + " does not exist"));
    }

    @Override
    public Evenement search(String data) {
        return eventList.stream()
                .filter(event -> event.getId().toString().equals(data) || // Recherche par ID
                        event.getName().equalsIgnoreCase(data) || // Recherche par nom
                        event.getDate().toString().equals(data) || // Recherche par date
                        event.getLocation().equalsIgnoreCase(data)) // Recherche par emplacement
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No event found matching: " + data));
    }

}
