package service.inter;

import entity.Evenement;
import java.util.List;
import java.util.Optional;

public interface EvenementService {
    Evenement addEvent(Evenement event);
    Evenement updateEvent(Long eventId,Evenement event);
    void deleteEvent(Long eventId);
    List<Evenement> getAllEvents();
    Optional<Evenement> getEventById();
    List<Evenement> searchEvents(String date,String location,String type);
}
