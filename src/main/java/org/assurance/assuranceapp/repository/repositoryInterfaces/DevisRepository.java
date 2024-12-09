package org.assurance.assuranceapp.repository.repositoryInterfaces;

import org.assurance.assuranceapp.models.Devis;

import java.util.UUID;

public interface DevisRepository extends GenericRepository<Devis>{
    Devis findByAssuranceId(UUID assuranceId);
}
