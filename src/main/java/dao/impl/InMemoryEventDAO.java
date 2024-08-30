package dao.impl;

import dao.EventDAO;
import entity.Evenement;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryEventDAO implements EventDAO {
    private List<Evenement> events = new ArrayList<>();

    @Override
    public void addEvent(Evenement event) {
        events.add(event);
    }

    @Override
    public void updateEvent(Long eventId, Evenement updatedEvent) {
        for (int i = 0; i < events.size(); i++) {
            if (events.get(i).getId().equals(eventId)) {
                events.set(i, updatedEvent);
                return;
            }
        }
    }

    @Override
    public void deleteEvent(Long eventId) {
        events.removeIf(event -> event.getId().equals(eventId));
    }

    @Override
    public Evenement getEventById(Long eventId) {
        return events.stream()
                .filter(event -> event.getId().equals(eventId))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Evenement> getAllEvents() {
        return new ArrayList<>(events);
    }

    @Override
    public List<Evenement> searchEvents(String criterion) {
        List<Evenement> result = new ArrayList<>();
        for (Evenement event : events) {
            if (event.getName().contains(criterion) || event.getEmail().contains(criterion)) {
                result.add(event);
            }
        }
        return result;
    }
}
