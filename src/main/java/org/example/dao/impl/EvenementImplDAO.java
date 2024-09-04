package org.example.dao.impl;

import org.example.dao.inter.EvenementDAO;
import org.example.entity.Evenement;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EvenementImplDAO implements EvenementDAO {

    private final List<Evenement> eventList = new ArrayList<>();

    @Override
    public void addEvent(Evenement event) {
        if (event == null) {
            throw new IllegalArgumentException("Event cannot be null");
        }
        eventList.add(event);
    }

    @Override
    public void updateEvent(Integer eventId, Evenement event) {
        if (event == null) {
            throw new IllegalArgumentException("Event cannot be null");
        }
        if (eventId < 0 || eventId >= eventList.size()) {
            throw new IndexOutOfBoundsException("Invalid event ID");
        }
        eventList.set(eventId, event);
    }

    @Override
    public void deleteEvent(Integer eventId) {
        if (eventId < 0 || eventId >= eventList.size()) {
            throw new IndexOutOfBoundsException("Invalid event ID");
        }
        eventList.remove((int) eventId);
    }

    @Override
    public List<Evenement> getAllEvents() {
        return new ArrayList<>(eventList);
    }

    @Override
    public Evenement getEvent(Integer eventId) {
        if (eventId < 0 || eventId >= eventList.size()) {
            throw new IndexOutOfBoundsException("Invalid event ID");
        }
        return eventList.get(eventId);
    }
}
