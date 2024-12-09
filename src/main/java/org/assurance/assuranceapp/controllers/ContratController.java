package org.assurance.assuranceapp.controllers;

import jakarta.servlet.http.HttpSession;
import org.assurance.assuranceapp.models.Contrat;
import org.assurance.assuranceapp.models.Devis;
import org.assurance.assuranceapp.service.serviceInterfaces.ContratServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

@Controller
@RequestMapping("/contrat")
public class ContratController {

    @Autowired
    private ContratServiceInterface contratService;

    @GetMapping("/confirmation")
    public String showConfirmationPage(Model model) {
//        model.addAttribute("assuranceSante", new AssuranceSante());
        return "confirmation";
    }

    @PostMapping("/registerContrat")
    public String registerContrat(HttpSession httpSession) {

        Devis devis = (Devis) httpSession.getAttribute("devis");

        System.out.println("THe Devis in Contrat Controller is" + devis);
        if (devis != null) {
            LocalDate startDate = LocalDate.now();
            LocalDate endDate = startDate.plusYears(1);

            // Create a new Contrat object with relevant details
            Contrat contrat = new Contrat();
            contrat.setDateDebut(startDate);
            contrat.setDateFin(endDate);
            contrat.setStatus("ACTIVE");
            contrat.setDocument("test Document"); // Update as necessary
            contrat.setDevis(devis);


            contratService.save(contrat);

            return "redirect:contratSuccess";
        }

        // If Devis is not found, redirect to an error page
        return "redirect:/errorPage";
    }
    @GetMapping("/contratSuccess")
    public String showContratSuccessPage() {
        return "contratSuccess";
    }
}
