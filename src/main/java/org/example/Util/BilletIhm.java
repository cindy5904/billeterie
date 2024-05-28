package org.example.Util;

import org.example.Repository.BaseRepository;
import org.example.Repository.BilletRepository;

import javax.persistence.EntityManager;
import java.util.Scanner;

public class BilletIhm {
    private Scanner scanner;
    private BilletRepository billetRepository;

    public BilletIhm(Scanner scanner, EntityManager em) {
        this.scanner = scanner;
        billetRepository = new BilletRepository(em);
    }

}
