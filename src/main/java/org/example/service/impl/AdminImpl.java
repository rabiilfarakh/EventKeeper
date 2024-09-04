package org.example.service.impl;

import org.example.dao.impl.AdminImplDAO;
import org.example.dao.inter.AdminDAO;
import org.example.entity.Registration;
import org.example.service.inter.AdminService;

import java.util.List;

public class AdminImpl implements AdminService {

    private final AdminDAO adminDAO;

    public AdminImpl(AdminDAO adminDAO) {
        this.adminDAO = adminDAO;
    }

    @Override
    public List<Registration> getReportOfParticipant(String username) {
        return adminDAO.getReportOfParticipant(username);
    }

    @Override
    public List<Registration> getReportOfEvent(int eventID) {
        return adminDAO.getReportOfEvent(eventID);
    }
}
