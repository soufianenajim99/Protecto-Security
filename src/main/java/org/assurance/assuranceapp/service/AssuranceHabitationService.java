package org.assurance.assuranceapp.service;

import org.assurance.assuranceapp.models.AssuranceHabitation;
import org.assurance.assuranceapp.repository.AssuranceHabitationRepositoryImpl;
import org.assurance.assuranceapp.repository.repositoryInterfaces.AssuranceHabitationRepository;
import org.assurance.assuranceapp.service.serviceInterfaces.AssuranceHabitationServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class AssuranceHabitationService implements AssuranceHabitationServiceInterface {
    @Autowired
    private AssuranceHabitationRepository assuranceHabitationRepository;

    @Override
    @Transactional
    public AssuranceHabitation save(AssuranceHabitation assuranceHabitation) {
        return assuranceHabitationRepository.save(assuranceHabitation);
    }

    @Override
    public List<AssuranceHabitation> findAll() {
        return assuranceHabitationRepository.findAll();
    }

    @Override
    public AssuranceHabitation findById(UUID id) {
        return assuranceHabitationRepository.findById(id);
    }

    @Override
    public void deleteById(UUID id) {
        assuranceHabitationRepository.deleteById(id);
    }
}
