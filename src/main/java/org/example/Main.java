package org.example;

import service.inter.EvenementService;
import service.impl.EvenementImpl;
import dao.EventDAO;
import dao.impl.InMemoryEventDAO;
import ui.ConsoleMenu;

public class Main {
    public static void main(String[] args) {

        EventDAO eventDAO = new InMemoryEventDAO();

        EvenementService evenementService = new EvenementImpl(eventDAO);

        ConsoleMenu menu = new ConsoleMenu(evenementService);

        menu.start();
    }
}
