package org.example.Repository;

import org.example.Entity.Client;
import org.example.Entity.Evenement;

import javax.persistence.EntityManager;
import java.util.List;

public class EvenementRepository extends BaseRepository<Evenement> {
    public EvenementRepository(EntityManager em) {
        super(em);
    }

    @Override
    public void save(Evenement element) {
        em.getTransaction().begin();
        em.persist(element);
        em.getTransaction().commit();
    }

    @Override
    public void delete(Evenement element) {
        em.getTransaction().begin();
        em.remove(element);
        em.getTransaction().commit();
    }

    @Override
    public Evenement findById(int id) {
        return em.find(Evenement.class, id);
    }

    @Override
    public List<Evenement> findAll() {
        return em.createQuery("SELECT c FROM Evenement c").getResultList();
    }
}
