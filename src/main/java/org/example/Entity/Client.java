package org.example.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.List;
@Entity
@AllArgsConstructor
@Data
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String prenom;
    @OneToOne
    private Adresse adresse;
    private int age;
    private String numeroDeTelephone;
    @OneToMany(mappedBy = "client")
    private List<Billet> billet;


    public Client() {

    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", adresse=" + adresse +
                ", age=" + age +
                ", numeroDeTelephone='" + numeroDeTelephone + '\'' +
                '}';
    }
}
