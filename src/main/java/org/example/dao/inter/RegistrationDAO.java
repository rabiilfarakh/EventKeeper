package org.example.dao.inter;

import org.example.entity.Evenement;
import org.example.entity.Registration;

import java.util.List;

public interface RegistrationDAO {

    void registerInEvent(Integer eventId, Integer participantId );

    void unregister(Integer eventID, Integer participantID);

    List<Evenement> registration(Integer participantID);

    List <Registration> getReportOfParticipant(String username);

    List <Registration> getReportOfEvent(Integer eventID);
}
