package org.assurance.assuranceapp.models;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Devis {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String status;
    private double prixDeBase;
    private double prixFinale;

    @OneToOne
    @JoinColumn(name = "assurance_id")
    private Assurance assurance;

    @OneToOne(mappedBy = "devis", cascade = CascadeType.ALL)
    private Contrat contrat;

    public Devis(String status, double prixDeBase, Assurance assurance, Contrat contrat) {
        this.status = status;
        this.prixDeBase = prixDeBase;
        this.assurance = assurance;
        this.contrat = contrat;
    }

    public Devis() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getPrixDeBase() {
        return prixDeBase;
    }

    public void setPrixDeBase(double prixDeBase) {
        this.prixDeBase = prixDeBase;
    }

    public double getPrixFinale() {
        return prixFinale;
    }

    public void setPrixFinale(double prixFinale) {
        this.prixFinale = prixFinale;
    }

    public Assurance getAssurance() {
        return assurance;
    }

    public void setAssurance(Assurance assurance) {
        this.assurance = assurance;
    }

    public Contrat getContrat() {
        return contrat;
    }

    public void setContrat(Contrat contrat) {
        this.contrat = contrat;
    }
}
