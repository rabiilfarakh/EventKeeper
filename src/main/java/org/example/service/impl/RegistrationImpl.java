package org.example.service.impl;

import org.example.dao.inter.RegistrationDAO;
import org.example.entity.Evenement;
import org.example.entity.Registration;
import org.example.service.inter.RegistrationService;

import java.util.List;

public class RegistrationImpl implements RegistrationService {

    private final RegistrationDAO registrationDAO;

    public RegistrationImpl(RegistrationDAO registrationDAO) {
        this.registrationDAO = registrationDAO;
    }

    @Override
    public void registerInEvent(Integer eventId, Integer participantId) {
        registrationDAO.registerInEvent(eventId,participantId);
    }

    @Override
    public void unregister(Integer eventID, Integer participantId) {
        registrationDAO.unregister(eventID,participantId);
    }

    @Override
    public List<Evenement> registration(Integer participantID) {
        return registrationDAO.registration(participantID);
    }

    @Override
    public List<Registration> getReportOfParticipant(String username) {
        return registrationDAO.getReportOfParticipant(username);
    }

    @Override
    public List<Registration> getReportOfEvent(Integer eventID) {
        return registrationDAO.getReportOfEvent(eventID);
    }
}
