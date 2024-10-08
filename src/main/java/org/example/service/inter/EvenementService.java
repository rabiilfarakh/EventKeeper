package org.example.service.inter;

import org.example.entity.Evenement;

import java.util.List;

public interface EvenementService {

    void addEvent(Evenement event);

    void updateEvent(Integer eventId, Evenement event);

    void deleteEvent(Integer eventId);

    List<Evenement> getAllEvents();

    Evenement getEvent(Integer eventId);

    Evenement search(String data);
}
