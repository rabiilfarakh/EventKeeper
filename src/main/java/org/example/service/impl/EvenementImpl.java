package org.example.service.impl;

import org.example.dao.inter.EvenementDAO;
import org.example.entity.Evenement;
import org.example.service.inter.EvenementService;

import java.util.List;

public class EvenementImpl implements EvenementService {

    private final EvenementDAO evenementDAO;

    public EvenementImpl(EvenementDAO evenementDAO) {
        this.evenementDAO = evenementDAO;
    }

    @Override
    public void addEvent(Evenement event) {
        evenementDAO.addEvent(event);
    }

    @Override
    public void updateEvent(Integer eventId, Evenement event) {
        evenementDAO.updateEvent(eventId, event);
    }

    @Override
    public void deleteEvent(Integer eventId) {
        evenementDAO.deleteEvent(eventId);
    }

    @Override
    public List<Evenement> getAllEvents() {
        return evenementDAO.getAllEvents();
    }

    @Override
    public Evenement getEvent(Integer eventId) {
        return evenementDAO.getEvent(eventId);
    }

    @Override
    public Evenement search(String data) {
        return evenementDAO.search(data);
    }
}
