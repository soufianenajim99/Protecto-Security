package org.assurance.assuranceapp.models;

import jakarta.persistence.Entity;

@Entity
public class AssuranceAutomobile extends Assurance {
    private int ageConducteur;
    private String typeVehicule;
    private String utilisationVehicule;
    private String historiqueConduite;

    public AssuranceAutomobile() {
    }

    public AssuranceAutomobile( Utilisateur utilisateur, Devis devis, int ageConducteur, String typeVehicule, String utilisationVehicule, String historiqueConduite) {
        super(utilisateur, devis);
        this.ageConducteur = ageConducteur;
        this.typeVehicule = typeVehicule;
        this.utilisationVehicule = utilisationVehicule;
        this.historiqueConduite = historiqueConduite;
    }

    public int getAgeConducteur() {
        return ageConducteur;
    }

    public void setAgeConducteur(int ageConducteur) {
        this.ageConducteur = ageConducteur;
    }

    public String getTypeVehicule() {
        return typeVehicule;
    }

    public void setTypeVehicule(String typeVehicule) {
        this.typeVehicule = typeVehicule;
    }

    public String getUtilisationVehicule() {
        return utilisationVehicule;
    }

    public void setUtilisationVehicule(String utilisationVehicule) {
        this.utilisationVehicule = utilisationVehicule;
    }

    public String getHistoriqueConduite() {
        return historiqueConduite;
    }

    public void setHistoriqueConduite(String historiqueConduite) {
        this.historiqueConduite = historiqueConduite;
    }
}
