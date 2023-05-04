package com.lidem.cfa.dao;

import com.lidem.cfa.dto.Personne;

import java.util.List;

public interface ServiceInterface {
    Personne findPersonneById(Integer id);
    Personne findPersonneByNomAndPrenom(String nom, String prenom);
    List<Personne> findAllPersonnes();
    Personne modifyPersonne(Integer id, Personne p);
    void addPersonne(Personne personne);
    void deletePersonne(Integer id);
}
