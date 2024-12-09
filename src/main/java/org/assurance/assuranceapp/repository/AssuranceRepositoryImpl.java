package org.assurance.assuranceapp.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.assurance.assuranceapp.models.Assurance;
import org.assurance.assuranceapp.repository.repositoryInterfaces.AssuranceRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Repository
public class AssuranceRepositoryImpl implements AssuranceRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public Assurance save(Assurance assurance) {
        return entityManager.merge(assurance);
    }

    @Override
    public List<Assurance> findAll() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Assurance> cq = cb.createQuery(Assurance.class);
        Root<Assurance> root = cq.from(Assurance.class);
        cq.select(root);
        return entityManager.createQuery(cq).getResultList();
    }

    @Override
    public Assurance findById(UUID id) {
        return entityManager.find(Assurance.class, id);
    }

    @Override
    public void deleteById(UUID id) {
        Assurance assurance = entityManager.find(Assurance.class, id);
        if (assurance != null) {
            entityManager.remove(assurance);
        }
    }
}
