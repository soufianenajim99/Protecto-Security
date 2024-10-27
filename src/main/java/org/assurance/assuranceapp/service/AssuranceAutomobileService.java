package org.assurance.assuranceapp.service;

import org.assurance.assuranceapp.models.AssuranceAutomobile;
import org.assurance.assuranceapp.repository.repositoryInterfaces.AssuranceAutomobileRepository;
import org.assurance.assuranceapp.service.serviceInterfaces.AssuranceAutomobileServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class AssuranceAutomobileService implements AssuranceAutomobileServiceInterface {
    @Autowired
    private AssuranceAutomobileRepository assuranceAutomobileRepository;

    @Override
    @Transactional
    public AssuranceAutomobile save(AssuranceAutomobile assuranceAutomobile) {
        return assuranceAutomobileRepository.save(assuranceAutomobile);
    }

    @Override
    public List<AssuranceAutomobile> findAll() {
        return assuranceAutomobileRepository.findAll();
    }

    @Override
    public AssuranceAutomobile findById(UUID id) {
        return assuranceAutomobileRepository.findById(id);
    }

    @Override
    public void deleteById(UUID id) {
        assuranceAutomobileRepository.deleteById(id);
    }
}
