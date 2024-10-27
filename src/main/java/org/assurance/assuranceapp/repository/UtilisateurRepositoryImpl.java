package org.assurance.assuranceapp.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.assurance.assuranceapp.models.Utilisateur;
import org.assurance.assuranceapp.repository.repositoryInterfaces.UtilisateurRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Repository
public class UtilisateurRepositoryImpl implements UtilisateurRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Utilisateur> findAll() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Utilisateur> cq = cb.createQuery(Utilisateur.class);
        Root<Utilisateur> root = cq.from(Utilisateur.class);
        cq.select(root);
        return entityManager.createQuery(cq).getResultList();
    }

    @Override
    public void deleteById(UUID id) {
        Utilisateur user = entityManager.find(Utilisateur.class, id);
        if (user != null) {
            entityManager.remove(user);
        }
    }

    @Override
    public Utilisateur save(Utilisateur theUtilisateur) {
        return entityManager.merge(theUtilisateur);
    }

    @Override
    public Utilisateur findById(UUID theId) {
        return entityManager.find(Utilisateur.class, theId);
    }

    @Override
    public Utilisateur findByUsername(String username) {
        try {
            return entityManager.createQuery("SELECT u FROM Utilisateur u WHERE u.username = :username", Utilisateur.class)
                    .setParameter("username", username)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

}
