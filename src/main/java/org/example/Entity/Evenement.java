package org.example.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@Entity
public class Evenement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nom;
    @OneToOne
    @JoinColumn(name = "lieu")
    private Lieu lieu;
    private LocalDate date;
    private String heure;
    private int nbrePlace;
    @OneToMany(mappedBy = "evenement")
    private List<Billet> billet;

    public Evenement() {
    }

    @Override
    public String toString() {
        return "Evenement{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", lieu=" + lieu +
                ", date=" + date +
                ", heure='" + heure + '\'' +
                ", nbrePlace=" + nbrePlace +
                ", billet=" + billet +
                '}';
    }
}
