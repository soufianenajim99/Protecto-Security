package org.assurance.assuranceapp.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.assurance.assuranceapp.models.AssuranceSante;
import org.assurance.assuranceapp.repository.repositoryInterfaces.AssuranceSanteRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Repository
public class AssuranceSanteRepositoryImpl implements AssuranceSanteRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public AssuranceSante save(AssuranceSante assuranceSante) {
        return entityManager.merge(assuranceSante);
    }

    @Override
    public List<AssuranceSante> findAll() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<AssuranceSante> cq = cb.createQuery(AssuranceSante.class);
        Root<AssuranceSante> root = cq.from(AssuranceSante.class);
        cq.select(root);
        return entityManager.createQuery(cq).getResultList();
    }

    @Override
    public AssuranceSante findById(UUID id) {
        return entityManager.find(AssuranceSante.class, id);
    }

    @Override
    public void deleteById(UUID id) {
        AssuranceSante assuranceSante = entityManager.find(AssuranceSante.class, id);
        if (assuranceSante != null) {
            entityManager.remove(assuranceSante);
        }
    }
}
