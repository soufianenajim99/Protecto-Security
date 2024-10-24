package org.assurance.assuranceapp.controllers;


import org.assurance.assuranceapp.models.Utilisateur;
import org.assurance.assuranceapp.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
@RequestMapping("/utilisateur")
public class UtilisateurController {

    @Autowired
    private UtilisateurService userService;


    @RequestMapping("/test")
    public ModelAndView home() {
        List<Utilisateur> listCustomer = userService.listAll();
        ModelAndView mav = new ModelAndView("test");
        mav.addObject("listCustomer", listCustomer);
        return mav;
    }


    @GetMapping("/list")
    public String listUtilisateurs(Model theModel) {
        List<Utilisateur> theUtilisateurs = userService.listAll();
        theModel.addAttribute("utilisateurs", theUtilisateurs);
        return "list-utilisateurs";
    }
//
    @GetMapping("/showForm")
    public String showFormForAdd(Model theModel) {
        Utilisateur theUtilisateur = new Utilisateur();
        theModel.addAttribute("utilisateur", theUtilisateur);
        return "utilisateur-form";
    }
//
    @PostMapping(value = "/saveUtilisateur")
    public String saveUtilisateur(@ModelAttribute("utilisateur") Utilisateur theUtilisateur) {
        userService.save(theUtilisateur);
        return "redirect:/utilisateur/list";
    }

//    @GetMapping("/updateForm")
//    public String showFormForUpdate(@RequestParam("utilisateurId") UUID theId,
//                                    Model theModel) {
//        Utilisateur theUtilisateur = userService.findById(theId);
//        theModel.addAttribute("utilisateur", theUtilisateur);
//        return "utilisateur-form";
//    }

//    @GetMapping("/delete")
//    public String deleteUtilisateur(@RequestParam("utilisateurId") UUID theId) {
//        userService.delete(theId);
//        return "redirect:/utilisateur/list";
//    }
}
