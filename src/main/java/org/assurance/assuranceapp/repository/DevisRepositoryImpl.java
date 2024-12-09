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
    public Devis save(Devis devis) {
        if (devis.getId() != null && entityManager.find(Devis.class, devis.getId()) != null) {
            // If Devis exists (based on ID), update it using merge
            return entityManager.merge(devis);
        } else {
            // If Devis does not exist (no ID or not found), persist it as a new entry
            entityManager.persist(devis);
            return devis;
        }
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

    @Override
    public Devis findByAssuranceId(UUID assuranceId) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Devis> cq = cb.createQuery(Devis.class);
        Root<Devis> root = cq.from(Devis.class);

        cq.select(root).where(cb.equal(root.get("assurance").get("id"), assuranceId));

        List<Devis> results = entityManager.createQuery(cq).getResultList();
        return results.isEmpty() ? null : results.get(0);
    }

}
