package org.example.Repository;

import org.example.Entity.Billet;

import javax.persistence.EntityManager;
import java.util.List;

public class BilletRepository extends BaseRepository<Billet> {
    public BilletRepository(EntityManager em) {
        super(em);
    }

    @Override
    public void save(Billet element) {
        em.getTransaction().begin();
        em.persist(element);
        em.getTransaction().commit();
    }

    @Override
    public void delete(Billet element) {
        em.getTransaction().begin();
        em.remove(element);
        em.getTransaction().commit();
    }

    @Override
    public Billet findById(int id) {
        return em.find(Billet.class, id);
    }

    @Override
    public List<Billet> findAll() {
        return em.createQuery("SELECT c FROM Billet c").getResultList();
    }
}
