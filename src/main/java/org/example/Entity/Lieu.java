package org.example.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;

@Entity
@Data
@AllArgsConstructor
@SuperBuilder
public class Lieu extends Adresse{
    private int id;
    private int capacite;


    public Lieu() {
        super();
    }

    @Override
    public String toString() {
        return super.toString() + "Lieu{" +
                "id=" + id +
                ", capacite=" + capacite +
                '}';
    }
}
