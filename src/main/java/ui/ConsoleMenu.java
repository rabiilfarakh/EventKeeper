package ui;

import service.inter.EvenementService;
import ui.Handler.EventHandler;

import java.util.Scanner;

public class ConsoleMenu {

    private final EventHandler eventHandler;
    private final Scanner scanner;

    public ConsoleMenu(EvenementService evenementService) {
        this.eventHandler = new EventHandler(evenementService);
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("----- Menu -----");
            System.out.println("1. Ajouter un événement");
            System.out.println("2. Modifier un événement");
            System.out.println("3. Supprimer un événement");
            System.out.println("4. Afficher tous les événements");
            System.out.println("5. Rechercher un événement par ID");
            System.out.println("6. Quitter");
            System.out.print("Choisissez une option : ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    eventHandler.addEvent();
                    break;
                case 2:
                    eventHandler.updateEvent();
                    break;
                case 3:
                    eventHandler.deleteEvent();
                    break;
                case 4:
                    eventHandler.displayAllEvents();
                    break;
                case 5:
                    eventHandler.searchEvent();
                    break;
                case 6:
                    System.out.println("Au revoir !");
                    return;
                default:
                    System.out.println("Option invalide. Veuillez réessayer.");
            }
        }
    }
}
