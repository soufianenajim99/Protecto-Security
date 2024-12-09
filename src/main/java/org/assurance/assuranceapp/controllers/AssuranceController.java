package org.assurance.assuranceapp.controllers;

import jakarta.servlet.http.HttpSession;
import org.assurance.assuranceapp.models.*;
import org.assurance.assuranceapp.service.AssuranceSanteService;
import org.assurance.assuranceapp.service.ContratService;
import org.assurance.assuranceapp.service.DevisService;
import org.assurance.assuranceapp.service.serviceInterfaces.AssuranceSanteServiceInterface;
import org.assurance.assuranceapp.service.serviceInterfaces.AssuranceServiceInterface;
import org.assurance.assuranceapp.service.serviceInterfaces.ContratServiceInterface;
import org.assurance.assuranceapp.service.serviceInterfaces.DevisServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.UUID;

@Controller
@RequestMapping("/reserveAssurance")
public class AssuranceController {
    @Autowired
    private AssuranceSanteServiceInterface assuranceSanteService;

    @Autowired
    private DevisServiceInterface devisService;


    @Autowired
    private HttpSession httpSession;


    @Autowired
    private AssuranceServiceInterface assuranceService;

    @GetMapping("/HealthInsuranceForm")
    public String showHealthInsuranceForm(Model model) {
        model.addAttribute("assuranceSante", new AssuranceSante());
        return "assurance/reserveAssuranceSante"; // this is the JSP form page
    }


    @PostMapping("/HealthInsuranceForm")
    public String processHealthInsuranceReservation(AssuranceSante assuranceSante) {

        double basePrice = 150.0;
        double finalPrice = devisService.calculateFinalPrice(assuranceSante);
        Utilisateur loggedInUser = (Utilisateur) httpSession.getAttribute("loggedInUser");


        assuranceSante.setUtilisateur(loggedInUser);

        // Create and set up the Devis entity
        Devis devis = new Devis();
        devis.setId(UUID.randomUUID());
        devis.setStatus("EN_COURS");
        devis.setPrixDeBase(basePrice);
        devis.setPrixFinale(finalPrice);

        // Set bidirectional relationship
        devis.setAssurance(assuranceSante);
        assuranceSante.setDevis(devis);

        // Save AssuranceSante and Devis in one go
        assuranceSanteService.save(assuranceSante);
       Devis savedDevis = devisService.findDevisByAssuranceId(assuranceSante.getId());

        httpSession.setAttribute("devis", devis);

        return "redirect:/contrat/confirmation"; // redirect to a confirmation page
    }


}
