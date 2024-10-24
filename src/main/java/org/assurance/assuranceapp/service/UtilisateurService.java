package org.assurance.assuranceapp.service;

import org.assurance.assuranceapp.models.Utilisateur;
import org.assurance.assuranceapp.repository.UtilisateurRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;


@Service
public class UtilisateurService {
    @Autowired
    UtilisateurRepositoryImpl repo;

    @Transactional
    public void save(Utilisateur customer) {
        repo.save(customer);
    }

    @Transactional
    public List<Utilisateur> listAll() {
        return (List<Utilisateur>) repo.findAll();
    }

    @Transactional
    public Utilisateur get(UUID id) {
        return repo.findById(id);
    }

    @Transactional
    public void delete(UUID id) {
        repo.deleteById(id);
    }

}