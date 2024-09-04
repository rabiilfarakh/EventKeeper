package org.example.service.inter;

import org.example.entity.Evenement;
import org.example.entity.Participant;
import org.example.entity.Registration;

import java.util.List;

public interface RegistrationService {

    void registerInEvent(Integer eventId, Integer participantId);

    void unregister(Integer eventID, Integer participantID);

    List<Evenement> registration(Integer participantID);

    List <Registration> getReportOfParticipant(String username);

    List <Registration> getReportOfEvent(Integer eventID);
}
