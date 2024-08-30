package service.impl;

import dao.EventDAO;
import entity.Evenement;
import service.inter.EvenementService;

import java.util.List;
import java.util.Optional;

public class EvenementImpl implements EvenementService {

    private final EventDAO eventDAO;

    public EvenementImpl(EventDAO eventDAO) {
        this.eventDAO = eventDAO;
    }

    @Override
    public Evenement addEvent(Evenement event) {
        eventDAO.addEvent(event);
        return event;
    }

    @Override
    public Evenement updateEvent(Long eventId, Evenement event) {
        eventDAO.updateEvent(eventId, event);
        return event;
    }

    @Override
    public void deleteEvent(Long eventId) {
        eventDAO.deleteEvent(eventId);
    }

    @Override
    public List<Evenement> getAllEvents() {
        return eventDAO.getAllEvents();
    }

    @Override
    public Optional<Evenement> getEventById(Long eventId) {
        return Optional.ofNullable(eventDAO.getEventById(eventId));
    }

    @Override
    public List<Evenement> searchEvents(String criterion) {
        return eventDAO.searchEvents(criterion);
    }
}
