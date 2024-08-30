package ui;

import entity.Evenement;
import service.inter.EvenementService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class EventHandler {

    private final EvenementService evenementService;
    private final Scanner scanner;

    public EventHandler(EvenementService evenementService) {
        this.evenementService = evenementService;
        this.scanner = new Scanner(System.in);
    }

    public void addEvent() {
        System.out.println("Ajouter un nouvel événement:");
        System.out.print("Titre: ");
        String title = scanner.nextLine();
        System.out.print("Date (format yyyy-MM-dd): ");
        String dateStr = scanner.nextLine();
        System.out.print("Type: ");
        String type = scanner.nextLine();

        Date date = parseDate(dateStr);

        Evenement event = new Evenement();
        event.setId(1L);
        event.setTitle(title);
        event.setDate(date);
        event.setType(type);

        evenementService.addEvent(event);
        System.out.println("Événement ajouté avec succès !");
    }

    public void updateEvent() {
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

    public void deleteEvent() {
        System.out.print("Entrez l'ID de l'événement à supprimer: ");
        Long eventId = scanner.nextLong();
        scanner.nextLine();

        evenementService.deleteEvent(eventId);
        System.out.println("Événement supprimé avec succès !");
    }

    public void displayAllEvents() {
        List<Evenement> events = evenementService.getAllEvents();
        System.out.println("Liste des événements:");
        for (Evenement event : events) {
            System.out.println("ID: " + event.getId() + ", Titre: " + event.getTitle() + ", Date: " + formatDate(event.getDate()) + ", Type: " + event.getType());
        }
    }

    public void searchEvent() {
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

    private Date parseDate(String dateStr) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return dateFormat.parse(dateStr);
        } catch (ParseException e) {
            System.out.println("Format de date invalide, utilisez yyyy-MM-dd. Date définie sur null.");
            return null;
        }
    }

    private String formatDate(Date date) {
        if (date != null) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            return dateFormat.format(date);
        }
        return "Date non définie";
    }
}
