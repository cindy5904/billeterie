package org.example.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity
@Data
@Inheritance(strategy =  InheritanceType.TABLE_PER_CLASS)
@SuperBuilder
public class Adresse {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected int id;
    protected String rue;
    protected String ville;

    public Adresse() {
    }

    @Override
    public String toString() {
        return "Adresse{" +
                "id=" + id +
                ", rue='" + rue + '\'' +
                ", ville='" + ville + '\'' +
                '}';
    }




}
