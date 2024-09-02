package org.example;

import dao.impl.InMemoryAuthDAO;
import dao.inter.AuthDAO;
import service.impl.AuthenticationImpl;
import service.inter.AuthenticationService;
import service.inter.EvenementService;
import service.impl.EvenementImpl;
import dao.inter.EventDAO;
import dao.impl.InMemoryEventDAO;
import ui.Console;
import ui.ConsoleMenu;

public class Main {
    public static void main(String[] args) {

        //EventDAO eventDAO = new InMemoryEventDAO();

        //EvenementService evenementService = new EvenementImpl(eventDAO);

        //ConsoleMenu menu = new ConsoleMenu(evenementService);

        AuthDAO authDAO = new InMemoryAuthDAO();
        AuthenticationService authService = new AuthenticationImpl(authDAO);
        Console menu = new Console(authService);
        menu.start();
    }
}
