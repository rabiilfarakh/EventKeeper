package org.example.service.inter;

import org.example.entity.Registration;

import java.util.List;

public interface AdminService {

    List<Registration> getReportOfParticipant(String username);

    List <Registration> getReportOfEvent(int eventID);
}
