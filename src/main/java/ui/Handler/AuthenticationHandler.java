package ui.Handler;

import service.inter.AuthenticationService;
import entity.Participant;

import java.util.Random;
import java.util.Scanner;

public class AuthenticationHandler {

    private final AuthenticationService authService;
    private final Scanner scanner;
    private final Random random = new Random();

    public AuthenticationHandler(AuthenticationService authService) {
        this.authService = authService;
        this.scanner = new Scanner(System.in);
    }

    public void handleRegistration() {
        System.out.print("Entrez le nom d'utilisateur : ");
        String username = scanner.nextLine();
        System.out.print("Entrez l'email : ");
        String email = scanner.nextLine();
        System.out.print("Entrez le mot de passe : ");
        String password = scanner.nextLine();

        boolean success = authService.registerParticipant(username, email, password);
        if (success) {
            System.out.println("Participant enregistré avec succès !");
        } else {
            System.out.println("Erreur : l'utilisateur existe déjà.");
        }
    }

    public void handleUnsubscription() {
        System.out.print("Entrez l'email : ");
        String email = scanner.nextLine();
        System.out.print("Entrez le mot de passe : ");
        String password = scanner.nextLine();

        boolean success = authService.unsubscribeParticipant(email, password);
        if (success) {
            System.out.println("Participant désinscrit avec succès !");
        } else {
            System.out.println("Erreur : informations invalides ou utilisateur non trouvé.");
        }
    }
}
