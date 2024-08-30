package dao;

import entity.Evenement;
import java.util.List;

public interface EventDAO {
    void addEvent(Evenement event);
    void updateEvent(Long eventId, Evenement event);
    void deleteEvent(Long eventId);
    Evenement getEventById(Long eventId);
    List<Evenement> getAllEvents();
    List<Evenement> searchEvents(String criterion);
}
