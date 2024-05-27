package org.example.Util;

import org.example.Entity.Evenement;
import org.example.Entity.Lieu;
import org.example.Repository.EvenementRepository;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class EvenementIhm {
    private Scanner scanner;
    private EvenementRepository evenementRepository;

    public EvenementIhm(Scanner scanner, EntityManager em) {
        this.scanner = scanner;
        evenementRepository = new EvenementRepository(em);
    }

    public void start() {
        int entry;
        while (true) {
            System.out.println("--- Menu Evenement ---");
            System.out.println("1/ Créer un événement");
            System.out.println("2/ Afficher tous les événements");
            System.out.println("3/ Afficher un événement par son Id");
            System.out.println("4/ Modifier un événement");
            System.out.println("5/ Supprimer un événement");
            entry = scanner.nextInt();
            scanner.nextLine();

            switch (entry) {
                case 1:
                    createEvenement();
                    break;
                case 2:
                    getAllEvenement();
                    break;
                case 3:
                    getEvenementById();
                    ;
                    break;
                case 4:
                    updateEvenement();
                    ;
                    break;
                case 5:
                    removeEvenement();
                    ;
                    break;
                default:
                    return;
            }
        }
    }

    private void createEvenement() {
        System.out.println("creation d'un événement");
        System.out.println("Nom de l'événement : ");
        String nom = scanner.nextLine();
        System.out.println("prix du produit : ");
        System.out.println("Capacité : ");
        int capacite = scanner.nextInt();
        Lieu lieu = Lieu.builder()
                .capacite(capacite)
                .build();
        System.out.println("Date de l'événement : ");
        String dateStr = scanner.nextLine();
        LocalDate date = LocalDate.parse(dateStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        System.out.println("Heure de l'événement : ");
        String heure = scanner.nextLine();
        scanner.nextLine();
        Evenement evenement = Evenement.builder()
                .nom(nom)
                .lieu(lieu)
                .date(date)
                .heure(heure)
                .build();

        evenementRepository.save(evenement);
    }

    private void getAllEvenement() {
        System.out.println("Afficher tous les événements : ");
        List<Evenement> evenements = evenementRepository.findAll();
        for (Evenement evenement : evenements) {
            System.out.println(evenement);
        }

    }

    private void getEvenementById() {
        System.out.println("afficher un événement par id");
        System.out.println("id de l'événement : ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Evenement evenement = evenementRepository.findById(id);
        if (evenement != null) {
            System.out.println(evenement);
        } else {
            System.out.println("aucun événement trouvé");
        }
    }

    private void updateEvenement() {
        System.out.println("mise a jour d'un événement");
        System.out.println("id de l'événement");
        int id = scanner.nextInt();
        scanner.nextLine();

        Evenement evenement = evenementRepository.findById(id);
        if (evenement != null) {
            System.out.println("nom de l'événement : ( " + evenement.getNom() + " )");
            evenement.setNom(scanner.nextLine());
            System.out.println("Lieu : ( " + evenement.getLieu() + " )");
            evenement.setLieu(scanner.nextLine());
            System.out.println("Date : (" + evenement.getDate() + ")");
            evenement.setDate(scanner.nextLine());
            scanner.nextLine();
            evenementRepository.save(evenement);
        } else {
            System.out.println("aucun produit trouvé");
        }
    }

    private void removeEvenement() {
        System.out.println("Suppression de l'événement : ");
        System.out.println("id de l'événement");
        int id = scanner.nextInt();
        scanner.nextLine();

        Evenement evenement = evenementRepository.findById(id);
        if (evenement != null) {
            evenementRepository.delete(evenement);
        } else {
            System.out.println("Aucun événement trouvé");
        }

    }

    }

