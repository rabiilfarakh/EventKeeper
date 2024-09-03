package ui;

import entity.Evenement;
import entity.Participant;
import entity.User;
import enumeration.Role;
import service.inter.AuthenticationService;
import service.inter.EvenementService;
import service.inter.ParticipantService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.Scanner;

public class Console {

    private final AuthenticationService authService;
    private final EvenementService evenementService;
    private final ParticipantService participantService;
    private final Scanner scanner;
    private final Random random;

    public Console(AuthenticationService authService, EvenementService evenementService, ParticipantService participantService) {
        this.authService = authService;
        this.evenementService = evenementService;
        this.participantService = participantService;
        this.scanner = new Scanner(System.in);
        this.random = new Random();
    }

    public void start() {
        while (true) {
            System.out.println("----- Menu Principal -----");
            System.out.println("1. Connexion");
            System.out.println("2. Inscription d'un Participant");
            System.out.println("3. Quitter");
            System.out.print("Choisissez une option : ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    handleLogin();
                    break;
                case 2:
                    handleRegistration();
                    break;
                case 3:
                    System.out.println("Au revoir !");
                    return;
                default:
                    System.out.println("Option invalide. Veuillez réessayer.");
            }
        }
    }

    private void handleLogin() {
        System.out.print("Entrez l'email : ");
        String email = scanner.nextLine();
        System.out.print("Entrez le mot de passe : ");
        String password = scanner.nextLine();

        User user = authService.authenticate(email, password);
        if (user != null) {
            if (user.getRole() == Role.ADMIN) {
                adminMenu();
            } else if (user instanceof Participant) {
                participantMenu((Participant) user);
            } else {
                System.out.println("Rôle non reconnu.");
            }
        } else {
            System.out.println("Échec de la connexion : informations incorrectes.");
        }
    }

    private void handleRegistration() {
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

    private void adminMenu() {
        while (true) {
            System.out.println("----- Menu Administrateur -----");
            System.out.println("1. Ajouter un Événement");
            System.out.println("2. Mettre à jour un Événement");
            System.out.println("3. Supprimer un Événement");
            System.out.println("4. Lister tous les Événements");
            System.out.println("5. Rechercher un Événement");
            System.out.println("6. Gérer les utilisateurs");
            System.out.println("7. Déconnexion");
            System.out.print("Choisissez une option : ");

            int choice = scanner.nextInt();
            scanner.nextLine();

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
                    displayAllEvents();
                    break;
                case 5:
                    searchEvent();
                    break;
                case 6:
                    manageParticipants();
                    break;
                case 7:
                    System.out.println("Déconnexion réussie.");
                    return;
                default:
                    System.out.println("Option invalide. Veuillez réessayer.");
            }
        }
    }

    private void participantMenu(Participant participant) {
        while (true) {
            System.out.println("----- Menu Participant -----");
            System.out.println("1. Lister tous les Événements");
            System.out.println("2. Intégrer un événement");
            System.out.println("3. Déconnexion");
            System.out.print("Choisissez une option : ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    displayAllEvents();
                    break;
                case 2:
                    integrateEvent(participant);
                    break;
                case 3:
                    System.out.println("Déconnexion réussie.");
                    return;
                default:
                    System.out.println("Option invalide. Veuillez réessayer.");
            }
        }
    }

    private void integrateEvent(Participant participant) {
        List<Evenement> events = evenementService.getAllEvents();
        System.out.println("Liste des événements disponibles :");
        for (int i = 0; i < events.size(); i++) {
            System.out.println((i + 1) + ". " + events.get(i).getTitle() + " - " + formatDate(events.get(i).getDate()));
        }

        System.out.print("Choisissez le numéro de l'événement que vous souhaitez intégrer : ");
        int eventChoice = scanner.nextInt();
        scanner.nextLine();

        if (eventChoice < 1 || eventChoice > events.size()) {
            System.out.println("Choix invalide.");
            return;
        }

        Evenement selectedEvent = events.get(eventChoice - 1);

        System.out.println("Voulez-vous vraiment intégrer l'événement : " + selectedEvent.getTitle() + " ?");
        System.out.print("Tapez 'oui' pour confirmer ou 'non' pour annuler : ");
        String confirmation = scanner.nextLine();

        if ("oui".equalsIgnoreCase(confirmation)) {
            evenementService.addParticipantToEvent(selectedEvent.getId(), participant.getId());
            System.out.println("Vous avez intégré l'événement : " + selectedEvent.getTitle() + " avec succès !");
        } else {
            System.out.println("Intégration annulée.");
        }
    }

    private void addEvent() {
        System.out.println("Ajouter un nouvel événement:");
        System.out.print("Titre: ");
        String title = scanner.nextLine();
        System.out.print("Date (format yyyy-MM-dd): ");
        String dateStr = scanner.nextLine();
        System.out.print("Type: ");
        String type = scanner.nextLine();

        Date date = parseDate(dateStr);

        Evenement event = new Evenement();
        long id = random.nextLong(1000000L) + 1;
        event.setId(id);
        event.setTitle(title);
        event.setDate(date);
        event.setType(type);

        evenementService.addEvent(event);
        System.out.println("Événement ajouté avec succès !");
    }

    private void updateEvent() {
        System.out.print("Entrez l'ID de l'événement à modifier: ");
        Long eventId = scanner.nextLong();
        scanner.nextLine();

        System.out.print("Nouveau Titre: ");
        String title = scanner.nextLine();
        System.out.print("Nouvelle Date (format yyyy-MM-dd): ");
        String dateStr = scanner.nextLine();
        System.out.print("Nouveau Type: ");
        String type = scanner.nextLine();

        Date date = parseDate(dateStr);

        Evenement event = new Evenement();
        event.setId(eventId);
        event.setTitle(title);
        event.setDate(date);
        event.setType(type);

        evenementService.updateEvent(eventId, event);
        System.out.println("Événement mis à jour avec succès !");
    }

    private void deleteEvent() {
        System.out.print("Entrez l'ID de l'événement à supprimer: ");
        Long eventId = scanner.nextLong();
        scanner.nextLine();

        evenementService.deleteEvent(eventId);
        System.out.println("Événement supprimé avec succès !");
    }

    private void displayAllEvents() {
        List<Evenement> events = evenementService.getAllEvents();
        System.out.println("Liste des événements:");
        for (Evenement event : events) {
            System.out.println("ID: " + event.getId() + ", Titre: " + event.getTitle() + ", Date: " + formatDate(event.getDate()) + ", Type: " + event.getType());
        }
    }

    private void searchEvent() {
        System.out.print("Entrez le critère de recherche (Titre, Type ou Date au format yyyy-MM-dd): ");
        String criterion = scanner.nextLine();

        List<Evenement> events = evenementService.searchEvents(criterion);
        if (!events.isEmpty()) {
            System.out.println("Événements trouvés:");
            for (Evenement event : events) {
                System.out.println("ID: " + event.getId() + ", Titre: " + event.getTitle() + ", Date: " + formatDate(event.getDate()) + ", Type: " + event.getType());
            }
        } else {
            System.out.println("Aucun événement trouvé avec le critère donné.");
        }
    }

    private void manageParticipants() {
        while (true) {
            System.out.println("----- Gérer les Utilisateurs -----");
            System.out.println("1. Lister les Participants");
            System.out.println("2. Supprimer un Participant");
            System.out.println("3. Retour");
            System.out.print("Choisissez une option : ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    displayAllParticipants();
                    break;
                case 2:
                    deleteParticipant();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Option invalide. Veuillez réessayer.");
            }
        }
    }

    private void displayAllParticipants() {
        List<Participant> participants = participantService.getAllParticipants();
        if (participants.isEmpty()) {
            System.out.println("Aucun participant n'est enregistré.");
        } else {
            System.out.println("Liste des participants:");
            for (Participant participant : participants) {
                System.out.println("ID: " + participant.getId() + ", Nom d'utilisateur: " + participant.getUsername() + ", Email: " + participant.getEmail());
            }
        }
        System.out.println("\nAppuyez sur Entrée pour continuer...");
        scanner.nextLine();
    }


    private void deleteParticipant() {
        System.out.print("Entrez l'ID du participant à supprimer: ");
        Long participantId = scanner.nextLong();
        scanner.nextLine();

        participantService.deleteParticipant(participantId);
        System.out.println("Participant supprimé avec succès !");
    }

    private Date parseDate(String dateStr) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
        } catch (ParseException e) {
            System.out.println("Date invalide. Utilisation de la date actuelle à la place.");
            return new Date();
        }
    }

    private String formatDate(Date date) {
        return new SimpleDateFormat("yyyy-MM-dd").format(date);
    }
}
