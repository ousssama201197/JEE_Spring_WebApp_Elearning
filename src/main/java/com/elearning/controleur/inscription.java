/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elearning.controleur;

import com.elearning.DaoImp.UtilisateurDaoImp;
import com.elearning.entities.Utilisateur;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.elearning.outiles.Util;

/**
 *
 * @author Amina
 */
@Controller
public class inscription {

    @Autowired
    public UtilisateurDaoImp DaoUtilisateur;

    @RequestMapping(value = "/inscription")
    public String index(HttpServletRequest request, Model model) {
        try {
            String username = request.getSession(true).getAttribute("login").toString();
            Utilisateur user = DaoUtilisateur.ExistsByUsername(username);

            if (!user.getType().equals("")) {
                model.addAttribute("username", user.getEmail());
                return "Ajoutercompte";
            } else {
                return "inscription";
            }

        } catch (NullPointerException e) {
            System.err.println("erreur");
            return "inscription";
        } 

    }

   @RequestMapping(value = "/saveuser")
    public ModelAndView nouveau(HttpServletRequest request) {
        ModelAndView model = new ModelAndView();

        try {

            String username = request.getSession(true).getAttribute("login").toString();
            Utilisateur user = DaoUtilisateur.ExistsByUsername(username);

            if (user != null) {
                if (user.getType().equals("Etudiant")) {
                    model.setViewName("home_etudiant");
                    return model;
                } else if (user.getType().equals("Enseignant")) {
                    model.setViewName("home_enseignant");
                    return model;
                }
            } else {

                model.setViewName("login");
                return model;
            }

            model.setViewName("login");
            return model;
        } catch (NullPointerException e) {
            System.err.println("erreurinssession");

            String nom = request.getParameter("nom");
            String prenom = request.getParameter("prenom");
            String username = request.getParameter("username");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String cpassword = request.getParameter("cpassword");
            String adresse = request.getParameter("adresse");
            String matricule = request.getParameter("mat");
            if (password.equals(cpassword)) {

                if (DaoUtilisateur.ExistsByUsername(username) == null) {

                    Utilisateur etudiant = new Utilisateur();
                    etudiant.setAdress(adresse);
                    etudiant.setEmail(email);
                    etudiant.setPassword(Util.sha256(password));
                    etudiant.setMatricule(matricule);
                    etudiant.setNom(nom);
                    etudiant.setPrenom(prenom);
                    etudiant.setUsername(username);

                    DaoUtilisateur.save(etudiant);
                    model.addObject("newinscription", "<div class=\"alert alert-success\"\n"
                            + "style=\"margin-left : 20px;margin-right : 20px;>"
                            + "                                <h5>\n"
                            + "                                    <i class=\"icon-ok-sign\"></i>\n"
                            + "                                    maintenant vous pouvez essayer notre platforme !\n"
                            + "                                </h5>\n"
                            + "                               \n"
                            + "                            </div>");

                    model.setViewName("login");
                    return model;
                    
                } else {
                    model.addObject("erreur", "<div class=\"row\">"
                            + "<div style='margin-left : 20%;'> "
                            + "<span  class=\"alert alert-danger\">nom d'utilisateur existe déja ;( </span>"
                            + "</div>"
                            + "</div>");

                    model.setViewName("inscription");
                    return model;
                }
            } else {
                model.addObject("erreur", "<span  class=\"alert alert-danger\">vérifier mot de passe</span>");
                model.addObject("erreur2", "has-error");
                model.setViewName("inscription");
                return model;

            }

        }

    }

}
