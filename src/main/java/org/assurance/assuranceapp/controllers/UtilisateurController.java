package org.assurance.assuranceapp.controllers;


import org.assurance.assuranceapp.models.Utilisateur;
import org.assurance.assuranceapp.service.UtilisateurService;
import org.assurance.assuranceapp.service.serviceInterfaces.UtilisateurServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.UUID;


@Controller
@RequestMapping("/utilisateur")
public class UtilisateurController {

    @Autowired
    private UtilisateurServiceInterface userService;


    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        // Initialize a new Utilisateur object and add to the model
        Utilisateur utilisateur = new Utilisateur();
        model.addAttribute("utilisateur", utilisateur);
        return "register"; // Return to the JSP page name
    }

    @PostMapping(value = "/saveUtilisateur")
    public String saveUtilisateur(@ModelAttribute("utilisateur") Utilisateur theUtilisateur) {
        userService.save(theUtilisateur);
        return "redirect:/utilisateur/list";
    }


    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("utilisateur", new Utilisateur()); // Create a new instance of Utilisateur for the form
        return "login"; // Return the view name for the login page
    }

//    // Handle login form submission
//    @PostMapping("/login")
//    public String loginUser(@RequestParam String username,
//                            @RequestParam String password,
//                            Model model) {
//        Utilisateur user = userService.findByUsername(username);
//        if (user != null && user.getPassword().equals(password)) {
//            // Implement session or redirect logic
//            return "welcome";  // Redirect to a welcome page or dashboard
//        } else {
//            model.addAttribute("error", "Invalid username or password");
//            return "login";
//        }
//    }










    @RequestMapping("/test")
    public ModelAndView home() {
        List<Utilisateur> listCustomer = userService.findAll();
        ModelAndView mav = new ModelAndView("test");
        mav.addObject("listCustomer", listCustomer);
        return mav;
    }


    @GetMapping("/list")
    public String listUtilisateurs(Model theModel) {
        List<Utilisateur> theUtilisateurs = userService.findAll();
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
//    @PostMapping(value = "/saveUtilisateur")
//    public String saveUtilisateur(@ModelAttribute("utilisateur") Utilisateur theUtilisateur) {
//        userService.save(theUtilisateur);
//        return "redirect:/utilisateur/list";
//    }

//    @GetMapping("/updateForm")
//    public String showFormForUpdate(@RequestParam("utilisateurId") UUID theId,
//                                    Model theModel) {
//        Utilisateur theUtilisateur = userService.findById(theId);
//        theModel.addAttribute("utilisateur", theUtilisateur);
//        return "utilisateur-form";
//    }

    @GetMapping("/delete")
    public String deleteUtilisateur(@RequestParam("utilisateurId") UUID theId) {
        userService.deleteById(theId);
        return "redirect:/utilisateur/list";
    }
}
