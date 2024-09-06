package org.example;

import org.example.dao.impl.EvenementImplDAO;
import org.example.dao.impl.ParticipantImplDAO;
import org.example.dao.impl.RegistrationImplDAO;
import org.example.dao.impl.UserImplDAO;
import org.example.dao.inter.EvenementDAO;
import org.example.dao.inter.ParticipantDAO;
import org.example.dao.inter.RegistrationDAO;
import org.example.dao.inter.UserDAO;
import org.example.entity.Evenement;
import org.example.entity.Participant;
import org.example.service.impl.EvenementImpl;
import org.example.service.impl.ParticipantImpl;
import org.example.service.impl.RegistrationImpl;
import org.example.service.impl.UserImpl;
import org.example.service.inter.EvenementService;
import org.example.service.inter.ParticipantService;
import org.example.service.inter.RegistrationService;
import org.example.service.inter.UserService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        // Create shared Map for participants
        Map<Integer, Participant> participants = new HashMap<>();
        // Create shared List for evenemenets
        List<Evenement> eventList = new ArrayList<>();
        // Create shared Map for participantsInEvent
        Map<Evenement, Participant> participantsInEvent = new HashMap<>();

        // Initialize DAOs with the shared Map
        EvenementDAO evenementDAO = new EvenementImplDAO(eventList);
        ParticipantDAO participantDAO = new ParticipantImplDAO(participants);
        RegistrationDAO registrationDAO = new RegistrationImplDAO(participantsInEvent,eventList,participants);
        UserDAO userDAO = new UserImplDAO(participants);

        // Initialize Services
        EvenementService evenementService = new EvenementImpl(evenementDAO);
        ParticipantService participantService = new ParticipantImpl(participantDAO);
        RegistrationService registrationService = new RegistrationImpl(registrationDAO);
        UserService userService = new UserImpl(userDAO);

        // Initialize Console
        Console console = new Console(evenementService, userService, registrationService, participantService);
        console.run();
    }
}

