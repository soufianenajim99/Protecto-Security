package org.assurance.assuranceapp.models;

import jakarta.persistence.Entity;

@Entity
public class AssuranceHabitation extends Assurance {
    private double valeurBien;
    private String typeLogement;
    private String localisation;
    private boolean systemeSecurite;

    public AssuranceHabitation( Utilisateur utilisateur, Devis devis, double valeurBien, String typeLogement, String localisation, boolean systemeSecurite) {
        super( utilisateur, devis);
        this.valeurBien = valeurBien;
        this.typeLogement = typeLogement;
        this.localisation = localisation;
        this.systemeSecurite = systemeSecurite;
    }

    public AssuranceHabitation() {
    }

    public double getValeurBien() {
        return valeurBien;
    }

    public void setValeurBien(double valeurBien) {
        this.valeurBien = valeurBien;
    }

    public String getTypeLogement() {
        return typeLogement;
    }

    public void setTypeLogement(String typeLogement) {
        this.typeLogement = typeLogement;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public boolean isSystemeSecurite() {
        return systemeSecurite;
    }

    public void setSystemeSecurite(boolean systemeSecurite) {
        this.systemeSecurite = systemeSecurite;
    }
}
