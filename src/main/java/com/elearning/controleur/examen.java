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
import com.elearning.entities.Utilisateur;
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
public class examen {
    
    @Autowired
    public UtilisateurDaoImp DaoUtilisateur;
    @Autowired
    public CoursDaoImp DaoCours;
    @Autowired
    public EtudiantCoursDaoImp DaoEtudiantCours;

    @RequestMapping(value = "/ajouter_examen")
    public ModelAndView index(HttpServletRequest request) {
        ModelAndView model = new ModelAndView();
        try {
            String username = request.getSession(true).getAttribute("login").toString();
            Utilisateur etud = DaoUtilisateur.ExistsByUsername(username);
            if (etud != null) {
                if (etud.getType().equals("etudiant")) {
                    // infos
                    model.addObject("listCours", DaoEtudiantCours.CoursByEtudiant(username));
                    model.setViewName("home_etudiant");
                    return model;

                } else if (etud.getType().equals("ens")) {
                    // infos
                    model.addObject("listecours", DaoCours.CoursByEnseignant(etud.getId()));
                    model.setViewName("nouveau_examen");
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

    @RequestMapping(value = "/saveexam")
    public ModelAndView saveexam(HttpServletRequest request) {
        ModelAndView model = new ModelAndView();
        try {
            String username = request.getSession(true).getAttribute("login").toString();
            Utilisateur etud = DaoUtilisateur.ExistsByUsername(username);
            if (etud != null) {
                if (etud.getType().equals("etudiant")) {
                    // infos
                    model.addObject("listCours", DaoEtudiantCours.CoursByEtudiant(username));
                    model.setViewName("home_etudiant");
                    return model;

                } else if (etud.getType().equals("ens")) {
                    // infos
                 
                   String c1 =  request.getParameter("c1");
                   String c2 =   request.getParameter("c2");
                   String c3  =   request.getParameter("c3");
                   String question  =    request.getParameter("question");
                   Cours cours = DaoCours.get(new Long(request.getParameter("idcours")));
                    
                    model.addObject("message", "<div class=\"alert alert-success alert-block fade in\">\n"
                            + "                                <button type=\"button\" class=\"close close-sm\" data-dismiss=\"alert\">\n"
                            + "                                    <i class=\"fa fa-times\"></i>\n"
                            + "                                </button>\n"
                            + "<p>Document ajouter</p>\n"
                            + "                            </div>");
                    model.setViewName("nouveau_examen");
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
