package org.assurance.assuranceapp.models;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@DiscriminatorValue("AssuranceSante")
@Table(name = "assurancesante")
public class AssuranceSante extends Assurance {
    private int age;
    @Column(name = "historiquesante")
    private String historiqueSante;
    @Column(name = "typecouverture")
    private String typeCouverture;

    public AssuranceSante() {
    }

    public AssuranceSante(Utilisateur utilisateur, Devis devis, String historiqueSante, String typeCouverture, int age) {
        super(utilisateur, devis);
        this.historiqueSante = historiqueSante;
        this.typeCouverture = typeCouverture;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHistoriqueSante() {
        return historiqueSante;
    }

    public void setHistoriqueSante(String historiqueSante) {
        this.historiqueSante = historiqueSante;
    }

    public String getTypeCouverture() {
        return typeCouverture;
    }

    public void setTypeCouverture(String typeCouverture) {
        this.typeCouverture = typeCouverture;
    }


}
