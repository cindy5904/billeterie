package org.example.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.Util.TypePlace;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
public class Billet {
    @Id
    private int id;
    private int numeroPlace;
    @ManyToOne
    private Evenement evenement;
    private TypePlace typePlace;
    @ManyToOne
    private Client client;

    public Billet() {

    }


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


