package org.example.dao.impl;

import org.example.dao.inter.AdminDAO;
import org.example.entity.Registration;

import java.util.List;

public class AdminImplDAO implements AdminDAO {

    @Override
    public List<Registration> getReportOfParticipant(String username) {

        return List.of();
    }

    @Override
    public List<Registration> getReportOfEvent(int eventID) {

        return List.of();
    }
}
