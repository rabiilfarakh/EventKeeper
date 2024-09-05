package org.example;

import org.example.entity.Evenement;
import org.example.entity.Participant;
import org.example.service.inter.*;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Console {

    private final EvenementService evenementService;
    private final UserService userService;
    private final RegistrationService registrationService;
    private final ParticipantService participantService;
    private final Scanner scanner;

    public Console(EvenementService evenementService, UserService userService,
                   RegistrationService registrationService, ParticipantService participantService) {
        this.evenementService = evenementService;
        this.userService = userService;
        this.registrationService = registrationService;
        this.participantService = participantService;
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        while (true) {
            showMainMenu();
            int choice = getUserInput();
            switch (choice) {
                case 1:
                    handleRegistration();
                    break;
                case 2:
                    handleLogin();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void showMainMenu() {
        System.out.println("\n=== Main Menu ===");
        System.out.println("1. Register as Participant");
        System.out.println("2. Login");
        System.out.println("3. Exit");
    }

    private void handleRegistration() {
        System.out.println("\n=== Registration Menu ===");
        System.out.print("Enter your name: ");
        String name = scanner.next();
        System.out.print("Enter a password: ");
        String password = scanner.next();

        Participant participant = new Participant();
        participant.setUsername(name);
        participant.setPassword(password);

        participantService.register(participant);
        System.out.println("Registration successful. You are now a participant.");
    }

    private void handleLogin() {
        System.out.print("Enter username: ");
        String username = scanner.next();
        System.out.print("Enter password: ");
        String password = scanner.next();

        String userRole = userService.login(username, password);
        if (userRole != null) {
            if ("admin".equals(userRole)) {
                handleAdminActions();
            } else {
                handleParticipantActions();
            }
        } else {
            System.out.println("Invalid credentials. Please try again.");
        }
    }

    private void handleAdminActions() {
        while (true) {
            showAdminMenu();
            int choice = getUserInput();
            switch (choice) {
                case 1:
                    addEvent();
                    break;
                case 2:
                    updateEvent();
                    break;
                case 3:
                    deleteEvent();
                    break;
                case 4:
                    getAllEvents();
                    break;
                case 5:
                    getEvent();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void handleParticipantActions() {
        while (true) {
            showParticipantMenu();
            int choice = getUserInput();
            switch (choice) {
                case 1:
                    registerInEvent();
                    break;
                case 2:
                    listParticipantEvents();
                    break;
                case 3:
                    searchEvent();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void showAdminMenu() {
        System.out.println("\n=== Admin Menu ===");
        System.out.println("1. Add Event");
        System.out.println("2. Update Event");
        System.out.println("3. Delete Event");
        System.out.println("4. Get All Events");
        System.out.println("5. Get Event by ID");
        System.out.println("6. Back to Main Menu");
    }

    private void showParticipantMenu() {
        System.out.println("\n=== Participant Menu ===");
        System.out.println("1. Register in an Event");
        System.out.println("2. List My Registered Events");
        System.out.println("3. Search Event");
        System.out.println("4. Back to Main Menu");
    }

    private int getUserInput() {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Clear the invalid input
            }
        }
    }

    private void addEvent() {
        scanner.nextLine(); // Clear the buffer
        System.out.print("Enter event name: ");
        String name = scanner.nextLine();

        System.out.print("Enter event date: ");
        String date = scanner.nextLine();

        System.out.print("Enter event description: ");
        String description = scanner.nextLine();

        System.out.print("Enter event location: ");
        String location = scanner.nextLine();

        Evenement event = new Evenement();
        event.setName(name);
        event.setDate(date);
        event.setDescription(description);
        event.setLocation(location);

        try {
            evenementService.addEvent(event);
            System.out.println("Event added successfully.");
        } catch (Exception e) {
            System.out.println("Error adding event: " + e.getMessage());
        }
    }

    private void updateEvent() {
        System.out.print("Enter event ID to update: ");
        int id = getUserInput();
        scanner.nextLine(); // Clear the buffer

        System.out.print("Enter new event name: ");
        String name = scanner.nextLine();

        System.out.print("Enter new event date: ");
        String date = scanner.nextLine();

        System.out.print("Enter new event description: ");
        String description = scanner.nextLine();

        System.out.print("Enter new event location: ");
        String location = scanner.nextLine();

        Evenement event = new Evenement();
        event.setName(name);
        event.setDate(date);
        event.setDescription(description);
        event.setLocation(location);

        try {
            evenementService.updateEvent(id, event);
            System.out.println("Event updated successfully.");
        } catch (Exception e) {
            System.out.println("Error updating event: " + e.getMessage());
        }
    }

    private void deleteEvent() {
        System.out.print("Enter event ID to delete: ");
        int id = getUserInput();

        try {
            evenementService.deleteEvent(id);
            System.out.println("Event deleted successfully.");
        } catch (Exception e) {
            System.out.println("Error deleting event: " + e.getMessage());
        }
    }

    private void getAllEvents() {
        try {
            List<Evenement> events = evenementService.getAllEvents();
            if (events.isEmpty()) {
                System.out.println("No events found.");
            } else {
                events.forEach(System.out::println);
            }
        } catch (Exception e) {
            System.out.println("Error retrieving events: " + e.getMessage());
        }
    }

    private void getEvent() {
        System.out.print("Enter event ID: ");
        int id = getUserInput();

        try {
            Evenement event = evenementService.getEvent(id);
            if (event == null) {
                System.out.println("Event not found.");
            } else {
                System.out.println(event);
            }
        } catch (Exception e) {
            System.out.println("Error retrieving event: " + e.getMessage());
        }
    }

    private void registerInEvent() {
        System.out.print("Enter event ID to register: ");
        int eventId = getUserInput();
        System.out.print("Enter your participant ID: ");
        int participantId = getUserInput();

        try {
            registrationService.registerInEvent(eventId, participantId);
            System.out.println("Successfully registered in the event.");
        } catch (Exception e) {
            System.out.println("Error registering in event: " + e.getMessage());
        }
    }

    private void listParticipantEvents() {
        System.out.print("Enter your participant ID: ");
        int participantId = getUserInput();

        try {
            List<Evenement> events = registrationService.registration(participantId);
            if (events.isEmpty()) {
                System.out.println("You are not registered in any events.");
            } else {
                events.forEach(System.out::println);
            }
        } catch (Exception e) {
            System.out.println("Error retrieving your events: " + e.getMessage());
        }
    }

    private void searchEvent() {
        System.out.print("Enter event ID: ");
        int eventId = getUserInput();

        try {
            Evenement event = evenementService.getEvent(eventId);
            if (event == null) {
                System.out.println("Event not found.");
            } else {
                System.out.println(event);
            }
        } catch (Exception e) {
            System.out.println("Error retrieving the event: " + e.getMessage());
        }
    }
}
