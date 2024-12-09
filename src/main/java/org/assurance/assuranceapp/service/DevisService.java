package org.assurance.assuranceapp.service;

import org.assurance.assuranceapp.models.*;
import org.assurance.assuranceapp.repository.DevisRepositoryImpl;
import org.assurance.assuranceapp.repository.repositoryInterfaces.DevisRepository;
import org.assurance.assuranceapp.service.serviceInterfaces.DevisServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class DevisService implements DevisServiceInterface {
    private static final double BASE_PRICE_HEALTH = 150.0;
    private static final double BASE_PRICE_HOME = 300.0;
    private static final double BASE_PRICE_AUTO = 500.0;
    @Autowired
    DevisRepository repo;

    @Transactional
    public Devis save(Devis devis) {
        repo.save(devis);
        return devis;
    }

    @Transactional
    public List<Devis> findAll() {
        return repo.findAll();
    }

    @Transactional
    public Devis findById(UUID id) {
        return repo.findById(id);
    }

    @Transactional
    public void deleteById(UUID id) {
        repo.deleteById(id);
    }


    // Main method to calculate final price based on assurance type
    public double calculateFinalPrice(Assurance assurance) {
        if (assurance instanceof AssuranceSante) {
            return calculateHealthInsurancePrice((AssuranceSante) assurance);
        } else if (assurance instanceof AssuranceHabitation) {
            return calculateHomeInsurancePrice((AssuranceHabitation) assurance);
        } else if (assurance instanceof AssuranceAutomobile) {
            return calculateAutoInsurancePrice((AssuranceAutomobile) assurance);
        } else {
            throw new IllegalArgumentException("Unknown assurance type");
        }
    }

    // Health Insurance Price Calculation
    private double calculateHealthInsurancePrice(AssuranceSante assurance) {
        double finalPrice = BASE_PRICE_HEALTH;

        // +20% if age > 60
        if (assurance.getAge() > 60) {
            finalPrice += BASE_PRICE_HEALTH * 0.2;
        }

        // +30% for chronic illness history
        if ("chronic".equalsIgnoreCase(assurance.getHistoriqueSante())) {
            finalPrice += BASE_PRICE_HEALTH * 0.3;
        }

        // Adjust for coverage type
        switch (assurance.getTypeCouverture().toLowerCase()) {
            case "basic":
                finalPrice -= BASE_PRICE_HEALTH * 0.1;
                break;
            case "premium":
                finalPrice += BASE_PRICE_HEALTH * 0.05;
                break;
        }

        return finalPrice;
    }

    // Home Insurance Price Calculation
    private double calculateHomeInsurancePrice(AssuranceHabitation assurance) {
        double finalPrice = BASE_PRICE_HOME;

        // +2% if property is a house
        if ("maison".equalsIgnoreCase(assurance.getTypeLogement())) {
            finalPrice += BASE_PRICE_HOME * 0.02;
        }

        // +5% if located in a risk zone
        if ("high risk".equalsIgnoreCase(assurance.getLocalisation())) {
            finalPrice += BASE_PRICE_HOME * 0.05;
        }

        // +10% if property value > 200,000 MAD
        if (assurance.getValeurBien() > 200000) {
            finalPrice += BASE_PRICE_HOME * 0.1;
        }

        // Adjust for security system
        if (assurance.isSystemeSecurite()) {
            finalPrice -= BASE_PRICE_HOME * 0.15;
        } else {
            finalPrice += BASE_PRICE_HOME * 0.15;
        }

        return finalPrice;
    }

    // Auto Insurance Price Calculation
    private double calculateAutoInsurancePrice(AssuranceAutomobile assurance) {
        double finalPrice = BASE_PRICE_AUTO;

        // +10% if driver is under 25
        if (assurance.getAgeConducteur() < 25) {
            finalPrice += BASE_PRICE_AUTO * 0.1;
        }

        // +15% for luxury vehicle
        if ("luxe".equalsIgnoreCase(assurance.getTypeVehicule())) {
            finalPrice += BASE_PRICE_AUTO * 0.15;
        }

        // +10% for professional use
        if ("professionnelle".equalsIgnoreCase(assurance.getUtilisationVehicule())) {
            finalPrice += BASE_PRICE_AUTO * 0.1;
        }

        // Adjust based on driving history
        if (assurance.getHistoriqueConduite() == "0") {
            finalPrice -= BASE_PRICE_AUTO * 0.2;
        } else {
            finalPrice += BASE_PRICE_AUTO * 0.1;
        }

        return finalPrice;
    }

    @Override
    public Devis findDevisByAssuranceId(UUID assuranceId) {
        return repo.findByAssuranceId(assuranceId);
    }









}
