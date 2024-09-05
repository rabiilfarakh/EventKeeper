package org.example;

import org.example.dao.impl.EvenementImplDAO;
import org.example.dao.impl.ParticipantImplDAO;
import org.example.dao.impl.RegistrationImplDAO;
import org.example.dao.impl.UserImplDAO;
import org.example.dao.inter.EvenementDAO;
import org.example.dao.inter.ParticipantDAO;
import org.example.dao.inter.RegistrationDAO;
import org.example.dao.inter.UserDAO;
import org.example.service.impl.EvenementImpl;
import org.example.service.impl.ParticipantImpl;
import org.example.service.impl.RegistrationImpl;
import org.example.service.impl.UserImpl;
import org.example.service.inter.EvenementService;
import org.example.service.inter.ParticipantService;
import org.example.service.inter.RegistrationService;
import org.example.service.inter.UserService;

public class Main {
    public static void main(String[] args) {
        // Initialize DAOs
        EvenementDAO evenementDAO = new EvenementImplDAO();
        ParticipantDAO participantDAO = new ParticipantImplDAO();
        RegistrationDAO registrationDAO = new RegistrationImplDAO();
        UserDAO userDAO = new UserImplDAO();

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
