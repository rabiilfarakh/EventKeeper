package org.example.dao.inter;

import org.example.entity.Registration;

import java.util.List;

public interface AdminDAO {

    List<Registration> getReportOfParticipant(String username);

    List <Registration> getReportOfEvent(int eventID);
}
