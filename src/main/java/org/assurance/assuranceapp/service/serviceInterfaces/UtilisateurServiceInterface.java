package org.assurance.assuranceapp.service.serviceInterfaces;

import org.assurance.assuranceapp.models.Utilisateur;

public interface UtilisateurServiceInterface extends GenericServiceInterface<Utilisateur> {
    Utilisateur findByUsername(String username);
}
