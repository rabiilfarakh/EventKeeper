package org.example;

import dao.impl.InMemoryAuthDAO;
import dao.impl.InMemoryParticipantDAO;
import dao.inter.AuthDAO;
import dao.inter.ParticipantDAO;
import service.impl.AuthenticationImpl;
import service.impl.ParticipantImpl;
import service.inter.AuthenticationService;
import service.inter.EvenementService;
import service.impl.EvenementImpl;
import dao.inter.EventDAO;
import dao.impl.InMemoryEventDAO;
import service.inter.ParticipantService;
import ui.Console;

public class Main {
    public static void main(String[] args) {

        ParticipantDAO participantDAO = new InMemoryParticipantDAO();
        EventDAO eventDAO = new InMemoryEventDAO(participantDAO);
        AuthDAO authDAO = new InMemoryAuthDAO();

        EvenementService evenementService = new EvenementImpl(eventDAO,participantDAO);
        ParticipantService participantService = new ParticipantImpl(participantDAO);
        AuthenticationService authService = new AuthenticationImpl(authDAO);

        Console menu = new Console(authService,evenementService,participantService);
        menu.start();
    }
}
