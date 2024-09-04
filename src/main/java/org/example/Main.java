package org.example;

import org.example.dao.impl.EvenementImplDAO;
import org.example.dao.inter.EvenementDAO;
import org.example.service.impl.EvenementImpl;
import org.example.service.inter.EvenementService;


public class Main {
    public static void main(String[] args) {
        EvenementDAO  evenementDAO = new EvenementImplDAO();
        EvenementService evenementService  = new EvenementImpl(evenementDAO);
        Console console = new Console(evenementService);
        console.run();
    }
}