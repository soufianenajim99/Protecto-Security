package org.assurance.assuranceapp.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.assurance.assuranceapp.models.AssuranceAutomobile;
import org.assurance.assuranceapp.repository.repositoryInterfaces.AssuranceAutomobileRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Repository
public class AssuranceAutomobileRepositoryImpl implements AssuranceAutomobileRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public AssuranceAutomobile save(AssuranceAutomobile assuranceSante) {
        return entityManager.merge(assuranceSante);
    }

    @Override
    public List<AssuranceAutomobile> findAll() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<AssuranceAutomobile> cq = cb.createQuery(AssuranceAutomobile.class);
        Root<AssuranceAutomobile> root = cq.from(AssuranceAutomobile.class);
        cq.select(root);
        return entityManager.createQuery(cq).getResultList();
    }

    @Override
    public AssuranceAutomobile findById(UUID id) {
        return entityManager.find(AssuranceAutomobile.class, id);
    }

    @Override
    public void deleteById(UUID id) {
        AssuranceAutomobile assuranceSante = entityManager.find(AssuranceAutomobile.class, id);
        if (assuranceSante != null) {
            entityManager.remove(assuranceSante);
        }
    }
}
