package org.assurance.assuranceapp.service.serviceInterfaces;

import org.assurance.assuranceapp.models.Assurance;
import org.assurance.assuranceapp.models.Devis;

import java.util.UUID;

public interface DevisServiceInterface extends GenericServiceInterface<Devis>{
    double calculateFinalPrice(Assurance assurance);
    Devis findDevisByAssuranceId(UUID assuranceId);  // New method
}
