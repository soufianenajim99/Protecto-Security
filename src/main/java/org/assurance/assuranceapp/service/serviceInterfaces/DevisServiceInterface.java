package org.assurance.assuranceapp.service.serviceInterfaces;

import org.assurance.assuranceapp.models.Assurance;
import org.assurance.assuranceapp.models.Devis;

public interface DevisServiceInterface extends GenericServiceInterface<Devis>{
    double calculateFinalPrice(Assurance assurance);
}
