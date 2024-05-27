package org.example.Repository;

import org.example.Entity.Evenement;
import org.example.Entity.Lieu;

import javax.persistence.EntityManager;
import java.util.List;

public class LieuRepository extends BaseRepository<Lieu> {
    public LieuRepository(EntityManager em) {
        super(em);
    }

    @Override
    public void save(Lieu element) {
        em.getTransaction().begin();
        em.persist(element);
        em.getTransaction().commit();
    }

    @Override
    public void delete(Lieu element) {
        em.getTransaction().begin();
        em.remove(element);
        em.getTransaction().commit();
    }

    @Override
    public Lieu findById(int id) {
        return em.find(Lieu.class, id);
    }

    @Override
    public List<Lieu> findAll() {
        return em.createQuery("SELECT c FROM Lieu c").getResultList();
    }
}
