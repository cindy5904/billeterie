package org.example.Util;

import org.example.Repository.BilletRepository;
import org.example.Repository.ClientRepository;
import org.example.Repository.EvenementRepository;
import org.example.Repository.LieuRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class Ihm {
    EntityManagerFactory emf =  Persistence.createEntityManagerFactory("Billeterie");
    EntityManager em = emf.createEntityManager();
    BilletRepository billetRepository;
    ClientRepository clientRepository;
    EvenementRepository evenementRepository;
    LieuRepository lieuRepository;
    Scanner scanner;

    public Ihm() {
        scanner = new Scanner(System.in);
        billetRepository = new BilletRepository(em);
        clientRepository = new ClientRepository(em);
        evenementRepository= new EvenementRepository(em);
        lieuRepository = new LieuRepository(em);

    }
}
