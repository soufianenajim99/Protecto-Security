package org.assurance.assuranceapp.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.assurance.assuranceapp.models.Contrat;
import org.assurance.assuranceapp.repository.repositoryInterfaces.ContratRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class ContratRepositoryImpl implements ContratRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Contrat save(Contrat contrat) {
        return entityManager.merge(contrat);
    }

    @Override
    public List<Contrat> findAll() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Contrat> cq = cb.createQuery(Contrat.class);
        Root<Contrat> root = cq.from(Contrat.class);
        cq.select(root);
        return entityManager.createQuery(cq).getResultList();
    }

    @Override
    public Contrat findById(UUID id) {
        return entityManager.find(Contrat.class, id);
    }

    @Override
    public void deleteById(UUID id) {
        Contrat contrat = entityManager.find(Contrat.class, id);
        if (contrat != null) {
            entityManager.remove(contrat);
        }
    }
}
