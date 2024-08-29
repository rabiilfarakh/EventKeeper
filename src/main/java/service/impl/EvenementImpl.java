package service.impl;

import entity.Evenement;
import service.inter.EvenementService;
import java.util.List;
import java.util.Optional;

public class EvenementImpl implements EvenementService {


    public Evenement addEvent(Evenement event) {
        return null;
    }


    public Evenement updateEvent(Long eventId, Evenement event) {
        return null;
    }


    public void deleteEvent(Long eventId) {

    }


    public List<Evenement> getAllEvents() {
        return List.of();
    }


    public Optional<Evenement> getEventById() {
        return Optional.empty();
    }


    public List<Evenement> searchEvents(String date, String location, String type) {
        return List.of();
    }
}
