package org.assurance.assuranceapp.service;

import org.assurance.assuranceapp.models.Utilisateur;
import org.assurance.assuranceapp.repository.UtilisateurRepositoryImpl;
import org.assurance.assuranceapp.repository.repositoryInterfaces.UtilisateurRepository;
import org.assurance.assuranceapp.service.serviceInterfaces.UtilisateurServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;


@Service
public class UtilisateurService implements UtilisateurServiceInterface {
    @Autowired
    UtilisateurRepository repo;

    @Transactional
    public Utilisateur save(Utilisateur customer) {
        repo.save(customer);
        return customer;
    }

    @Transactional
    public List<Utilisateur> findAll() {
        return repo.findAll();
    }

    @Transactional
    public Utilisateur findById(UUID id) {
        return repo.findById(id);
    }

    @Transactional
    public void deleteById(UUID id) {
        repo.deleteById(id);
    }

    @Transactional
    public  Utilisateur findByUsername(String username){
    return repo.findByUsername(username);
    }
}