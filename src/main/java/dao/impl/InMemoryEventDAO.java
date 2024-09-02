package dao.impl;

import dao.inter.EventDAO;
import entity.Evenement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        boolean isDateCriterion = false;

        Date criterionDate = null;
        try {
            criterionDate = dateFormat.parse(criterion);
            isDateCriterion = true;
        } catch (ParseException e) {
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

}
