package org.assurance.assuranceapp.service;

import org.assurance.assuranceapp.models.Assurance;
import org.assurance.assuranceapp.models.Contrat;
import org.assurance.assuranceapp.repository.repositoryInterfaces.AssuranceRepository;
import org.assurance.assuranceapp.repository.repositoryInterfaces.ContratRepository;
import org.assurance.assuranceapp.service.serviceInterfaces.ContratServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class ContratService implements ContratServiceInterface {
    @Autowired
    private ContratRepository contratRepository;

    @Override
    @Transactional
    public Contrat save(Contrat contrat) {
        return contratRepository.save(contrat);
    }

    @Override
    @Transactional
    public List<Contrat> findAll() {
        return contratRepository.findAll();
    }

    @Override
    @Transactional
    public Contrat findById(UUID id) {
        return contratRepository.findById(id);
    }

    @Override
    @Transactional
    public void deleteById(UUID id) {
        contratRepository.deleteById(id);
    }
}
