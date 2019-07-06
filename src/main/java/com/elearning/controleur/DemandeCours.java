/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elearning.controleur;

import com.elearning.DaoImp.CoursDaoImp;
import com.elearning.DaoImp.EtudiantCoursDaoImp;
import com.elearning.DaoImp.UtilisateurDaoImp;
import com.elearning.entities.Cours;
import com.elearning.entities.EtudiantCours;
import com.elearning.entities.Utilisateur;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Amina
 */
@Controller
public class DemandeCours {

    @Autowired
    public CoursDaoImp DaoCours;
    @Autowired
    public UtilisateurDaoImp DaoEtudiant;
    @Autowired
    public EtudiantCoursDaoImp DaoEtudiantCours;

    @RequestMapping(value = "/sinscrireCours")
    public ModelAndView demandecours(HttpServletRequest request) {
 ModelAndView model = new ModelAndView();
        try {
            String username = request.getSession(true).getAttribute("login").toString();
            Utilisateur etud = DaoEtudiant.ExistsByUsername(username);
            if (etud != null) {
                if (etud.getType().equals("etudiant")) {
                     
                    model.setViewName("inscrireDansUnCours");
                    return model;

                } else if (etud.getType().equals("ens")) {
                    // infos

                    model.setViewName("home_enseigant");
                    
                    return model;

                } else {
                    model.setViewName("login");
                    return model;
                }

            } else {
                model.setViewName("login");
                return model;
            }
        } catch (NullPointerException e) {
            System.err.println("erreur");
            model.setViewName("login");
            return model;
        }
    }

    @RequestMapping(value = "/DemandeCours")
    public ModelAndView savedemandecours(HttpServletRequest request) {
        ModelAndView model = new ModelAndView();
        try {
            String username = request.getSession(true).getAttribute("login").toString();
            Utilisateur etud = DaoEtudiant.ExistsByUsername(username);
            if (etud != null) {
                if (etud.getType().equals("etudiant")) {
                    // infos
                    
                    
                    Cours cours = DaoCours.CoursByName(request.getParameter("name"));
                    if(cours != null){ 
                    EtudiantCours EtCo = new EtudiantCours();
                    EtCo.setCours(cours);
                    EtCo.setEtudiant(etud);
                    Date d = new Date();
                    EtCo.setDate_inscription(d);
                    EtCo.setValider(false);
                    DaoEtudiantCours.save(EtCo);
                    model.addObject("message", "<div class=\"alert alert-success alert-block fade in\">\n"
                            + "                                <button type=\"button\" class=\"close close-sm\" data-dismiss=\"alert\">\n"
                            + "                                    <i class=\"fa fa-times\"></i>\n"
                            + "                                </button>\n"
                            + "<p>demande d'inscription envoyer</p>\n"
                            + "                            </div>");
                    model.setViewName("inscrireDansUnCours");
                    return model;
                    
                    }else{
                                        model.addObject("message", "<div class=\"alert alert-danger alert-block fade in\">\n"
                            + "                                <button type=\"button\" class=\"close close-sm\" data-dismiss=\"alert\">\n"
                            + "                                    <i class=\"fa fa-times\"></i>\n"
                            + "                                </button>\n"
                            + "<p>cours n'existe pas,verifier nom du cours</p>\n"
                            + "                            </div>");
                    model.setViewName("inscrireDansUnCours");
                      model.addObject("username", etud.getNom() + "  " + etud.getPrenom());
                    return model;   
                    }
                } else if (etud.getType().equals("ens")) {
                    // infos

                    model.setViewName("home_enseigant");
 model.addObject("username", etud.getNom() + "  " + etud.getPrenom());

                    return model;

                } else {
                    model.setViewName("login");
                    return model;
                }

            } else {
                model.setViewName("login");
                return model;
            }
        } catch (NullPointerException e) {
            System.err.println("erreur");
            model.setViewName("login");
            return model;
        }
    }

}
