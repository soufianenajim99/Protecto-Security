package org.assurance.assuranceapp.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.assurance.assuranceapp.models.Devis;
import org.assurance.assuranceapp.repository.repositoryInterfaces.DevisRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Repository
public class DevisRepositoryImpl implements DevisRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public Devis save(Devis devis) {
        return entityManager.merge(devis);
    }

    @Override
    public List<Devis> findAll() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Devis> cq = cb.createQuery(Devis.class);
        Root<Devis> root = cq.from(Devis.class);
        cq.select(root);
        return entityManager.createQuery(cq).getResultList();
    }

    @Override
    public Devis findById(UUID id) {
        return entityManager.find(Devis.class, id);
    }

    @Override
    public void deleteById(UUID id) {
        Devis devis = entityManager.find(Devis.class, id);
        if (devis != null) {
            entityManager.remove(devis);
        }
    }
}
