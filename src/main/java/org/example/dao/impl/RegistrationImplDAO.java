package org.example.dao.impl;

import org.example.dao.inter.RegistrationDAO;
import org.example.entity.Evenement;
import org.example.entity.Registration;

import java.util.List;

public class RegistrationImplDAO implements RegistrationDAO {
    @Override
    public void registerInEvent(Integer eventId, Integer participantId) {

    }

    @Override
    public void unregister(Integer eventID, Integer participantID) {

    }

    @Override
    public List<Evenement> registration(Integer participantID) {
        return List.of();
    }

    @Override
    public List<Registration> getReportOfParticipant(String username) {
        return List.of();
    }

    @Override
    public List<Registration> getReportOfEvent(Integer eventID) {
        return List.of();
    }
}
