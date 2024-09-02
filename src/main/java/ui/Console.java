package ui;

import service.inter.AuthenticationService;
import ui.Handler.AuthenticationHandler;

import java.util.Scanner;

public class Console {

    private final AuthenticationHandler authHandler;
    private final Scanner scanner;

    public Console(AuthenticationService authService) {
        this.authHandler = new AuthenticationHandler(authService);
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("----- Authentication -----");
            System.out.println("1. Inscription d'un Participant");
            System.out.println("2. Désinscription d'un Participant");
            System.out.println("3. Quitter");
            System.out.print("Choisissez une option : ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    authHandler.handleRegistration();
                    break;
                case 2:
                    authHandler.handleUnsubscription();
                    break;
                case 3:
                    System.out.println("Au revoir !");
                    return;
                default:
                    System.out.println("Option invalide. Veuillez réessayer.");
            }
        }
    }
}
