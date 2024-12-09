package org.assurance.assuranceapp.service;

import org.assurance.assuranceapp.models.Assurance;
import org.assurance.assuranceapp.repository.repositoryInterfaces.AssuranceRepository;
import org.assurance.assuranceapp.service.serviceInterfaces.AssuranceServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class AssuranceService implements AssuranceServiceInterface {
    @Autowired
    private AssuranceRepository assuranceRepository;

    @Override
    @Transactional
    public Assurance save(Assurance assurance) {
        return assuranceRepository.save(assurance);
    }

    @Override
    @Transactional
    public List<Assurance> findAll() {
        return assuranceRepository.findAll();
    }

    @Override
    @Transactional
    public Assurance findById(UUID id) {
        return assuranceRepository.findById(id);
    }

    @Override
    @Transactional
    public void deleteById(UUID id) {
        assuranceRepository.deleteById(id);
    }
}
