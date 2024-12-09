package org.assurance.assuranceapp.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.assurance.assuranceapp.models.AssuranceSante;
import org.assurance.assuranceapp.repository.repositoryInterfaces.AssuranceSanteRepository;
import org.assurance.assuranceapp.service.serviceInterfaces.AssuranceSanteServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class AssuranceSanteService implements AssuranceSanteServiceInterface {
    @Autowired
    private AssuranceSanteRepository assuranceSanteRepository;


    @Override
    @Transactional
    public AssuranceSante save(AssuranceSante assuranceSante) {
        return assuranceSanteRepository.save(assuranceSante);
    }

    @Override
    @Transactional
    public List<AssuranceSante> findAll() {
        return assuranceSanteRepository.findAll();
    }

    @Override
    @Transactional
    public AssuranceSante findById(UUID id) {
        return assuranceSanteRepository.findById(id);
    }

    @Override
    @Transactional
    public void deleteById(UUID id) {
        assuranceSanteRepository.deleteById(id);
    }
}
