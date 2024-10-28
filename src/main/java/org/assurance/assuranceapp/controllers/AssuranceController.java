package org.assurance.assuranceapp.controllers;

import jakarta.servlet.http.HttpSession;
import org.assurance.assuranceapp.models.AssuranceSante;
import org.assurance.assuranceapp.models.Devis;
import org.assurance.assuranceapp.models.Utilisateur;
import org.assurance.assuranceapp.service.AssuranceSanteService;
import org.assurance.assuranceapp.service.DevisService;
import org.assurance.assuranceapp.service.serviceInterfaces.AssuranceSanteServiceInterface;
import org.assurance.assuranceapp.service.serviceInterfaces.DevisServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reserveAssurance")
public class AssuranceController {
    @Autowired
    private AssuranceSanteServiceInterface assuranceSanteService;

    @Autowired
    private DevisServiceInterface devisService;
    @Autowired
    private HttpSession httpSession;

    @GetMapping("/HealthInsuranceForm")
    public String showHealthInsuranceForm(Model model) {
        model.addAttribute("assuranceSante", new AssuranceSante());
        return "assurance/reserveAssuranceSante"; // this is the JSP form page
    }
    @PostMapping("/HealthInsuranceForm")
    public String processHealthInsuranceReservation(AssuranceSante assuranceSante) {
        // Calculate the base price and set Devis status
        double basePrice = 150.0;
        double finalPrice = devisService.calculateFinalPrice(assuranceSante);
        Utilisateur loggedInUser = (Utilisateur) httpSession.getAttribute("loggedInUser");


        Devis devis = new Devis();
        devis.setStatus("EN_COURS");
        devis.setPrixDeBase(basePrice);
        devis.setPrixFinale(finalPrice);

        // Save the Devis and AssuranceSante
        devisService.save(devis);
        assuranceSante.setDevis(devis);
        assuranceSante.setUtilisateur(loggedInUser);
        assuranceSanteService.save(assuranceSante);


        return "redirect:/confirmation"; // redirect to a confirmation page
    }
}
