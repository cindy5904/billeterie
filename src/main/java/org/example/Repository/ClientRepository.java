package org.example.Repository;

import org.example.Entity.Billet;
import org.example.Entity.Client;

import javax.persistence.EntityManager;
import java.util.List;

public class ClientRepository extends BaseRepository <Client>{
    public ClientRepository(EntityManager em) {
        super(em);
    }

    @Override
    public void save(Client element) {
        em.getTransaction().begin();
        em.persist(element);
        em.getTransaction().commit();
    }

    @Override
    public void delete(Client element) {
        em.getTransaction().begin();
        em.remove(element);
        em.getTransaction().commit();
    }

    @Override
    public Client findById(int id) {
        return em.find(Client.class, id);
    }

    @Override
    public List<Client> findAll() {
        return em.createQuery("SELECT c FROM Client c").getResultList();
    }
}
