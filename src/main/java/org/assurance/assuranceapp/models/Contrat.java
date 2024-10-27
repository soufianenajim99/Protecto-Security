package org.assurance.assuranceapp.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
public class Contrat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private LocalDate dateDebut;
    private LocalDate dateFin;
    private String status;
    private String document;

    @OneToOne
    @JoinColumn(name = "devis_id")
    private Devis devis;

    public Contrat() {
    }

    public Contrat(LocalDate dateDebut, LocalDate dateFin, String document, String status, Devis devis) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.document = document;
        this.status = status;
        this.devis = devis;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public Devis getDevis() {
        return devis;
    }

    public void setDevis(Devis devis) {
        this.devis = devis;
    }
}
