package com.lidem.cfa.dao;

import com.lidem.cfa.dto.Personne;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class PersonneService implements ServiceInterface {
    EntityManagerFactory emf;
    EntityManager em;
    public PersonneService(){
        this.emf = Persistence.createEntityManagerFactory("UserDb");
        this.em = emf.createEntityManager();
    }
    @Override
    public Personne findPersonneById(Integer id) {
        Personne p = new Personne();
        try {
            p = this.em.find(Personne.class, id); // find() is a method of EntityManager
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Personne findPersonneByNomAndPrenom(String nom, String prenom) {
        Personne p = new Personne();
        try {
            p = this.em.createQuery("SELECT p FROM Personne p WHERE p.nom = :nom AND p.prenom = :prenom", Personne.class)
                    .setParameter("nom", nom)
                    .setParameter("prenom", prenom)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(p);
        return p;
    }

    @Override
    public List<Personne> findAllPersonnes() {
        List<Personne> personnes = new ArrayList<Personne>();
        try {
            Query query = this.em.createQuery("SELECT p FROM Personne p", Personne.class);
            personnes = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return personnes; // Remplacez 'null' par 'personnes'
    }


    @Override
    public Personne modifyPersonne(Integer id, Personne p) {
        Personne old = this.em.find(Personne.class, id);
        this.em.getTransaction().begin();
        old.setNom(p.getNom());
        old.setPrenom(p.getPrenom());
        this.em.getTransaction().commit();
        this.close();
        return old;
    }

    private void close() {
        this.em.close();
        this.emf.close();
    }

    @Override
    public void addPersonne(Personne personne) {
        Personne doublon = this.findPersonneByNomAndPrenom(personne.getNom(), personne.getPrenom());
        try {
            this.em.getTransaction().begin();
            this.em.persist(personne);
            this.em.getTransaction().commit();
        } catch (Exception e) {
            if (this.em.getTransaction().isActive()) {
                this.em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            this.close();
        }
    }

    @Override
    public void deletePersonne(Integer id) {
        try {
            Personne p = this.em.find(Personne.class, id);
            this.em.getTransaction().begin();
            this.em.remove(p);
            this.em.getTransaction().commit();
            this.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
