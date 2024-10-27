package org.assurance.assuranceapp.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.assurance.assuranceapp.models.AssuranceHabitation;
import org.assurance.assuranceapp.repository.repositoryInterfaces.AssuranceHabitationRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Repository
public class AssuranceHabitationRepositoryImpl implements AssuranceHabitationRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public AssuranceHabitation save(AssuranceHabitation assuranceSante) {
        return entityManager.merge(assuranceSante);
    }

    @Override
    public List<AssuranceHabitation> findAll() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<AssuranceHabitation> cq = cb.createQuery(AssuranceHabitation.class);
        Root<AssuranceHabitation> root = cq.from(AssuranceHabitation.class);
        cq.select(root);
        return entityManager.createQuery(cq).getResultList();
    }

    @Override
    public AssuranceHabitation findById(UUID id) {
        return entityManager.find(AssuranceHabitation.class, id);
    }

    @Override
    public void deleteById(UUID id) {
        AssuranceHabitation assuranceSante = entityManager.find(AssuranceHabitation.class, id);
        if (assuranceSante != null) {
            entityManager.remove(assuranceSante);
        }
    }
}
