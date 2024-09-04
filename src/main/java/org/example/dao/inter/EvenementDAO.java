package org.example.dao.inter;

import org.example.entity.Evenement;

import java.util.List;

public interface EvenementDAO {

    void addEvent(Evenement event);

    void updateEvent(Integer eventId , Evenement event);

    void deleteEvent(Integer eventId);

    List<Evenement>getAllEvents();

    Evenement getEvent(Integer eventId);

}
