package org.example.Entity;

import lombok.Data;
import org.example.Util.TypePlace;

import javax.persistence.ManyToOne;
@Data

public class Billet {
    private int id;
    private int numeroPlace;
    @ManyToOne
    private Evenement evenement;
    private TypePlace typePlace;
    @ManyToOne
    private Client client;


    @Override
    public String toString() {
        return "Billet{" +
                "id=" + id +
                ", numeroPlace=" + numeroPlace +
                ", evenement=" + evenement +
                ", typePlace=" + typePlace +
                ", client=" + client +
                '}';
    }
}
