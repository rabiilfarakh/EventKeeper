package controller;

import entity.Evenement;
import service.inter.EvenementService;

import java.util.List;
import java.util.Optional;

public class EvenementController {

    private final EvenementService evenementService;

    public EvenementController(EvenementService evenementService) {
        this.evenementService = evenementService;
    }

    public Evenement addEvent(Evenement event) {
        return evenementService.addEvent(event);
    }

    public Evenement updateEvent(Long eventId, Evenement event) {
        return evenementService.updateEvent(eventId, event);
    }

    public void deleteEvent(Long eventId) {
        evenementService.deleteEvent(eventId);
    }

    public List<Evenement> getAllEvents() {
        return evenementService.getAllEvents();
    }

    public Optional<Evenement> getEventById(Long eventId) {
        return evenementService.getEventById(eventId);
    }

    public List<Evenement> searchEvents(String criterion) {
        return evenementService.searchEvents(criterion);
    }
}
