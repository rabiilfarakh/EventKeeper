package org.example;

import org.example.entity.Evenement;
import org.example.entity.User;
import org.example.service.inter.EvenementService;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Console {

    private final EvenementService evenementService;
    private final Scanner scanner;
    private final String ADMIN_USERNAME = "admin";
    private final String ADMIN_PASSWORD = "admin";

    public Console(EvenementService evenementService) {
        this.evenementService = evenementService;
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
        System.out.println("You are now registered as a participant.");
        // Registration logic can be added here if needed
    }

    private void handleLogin() {
        System.out.print("Enter username: ");
        String username = scanner.next();
        System.out.print("Enter password: ");
        String password = scanner.next();

        if (ADMIN_USERNAME.equals(username) && ADMIN_PASSWORD.equals(password)) {
            handleAdminActions();
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
                    return; // Return to the main menu
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
                events.forEach(event -> System.out.println(event));
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
}
