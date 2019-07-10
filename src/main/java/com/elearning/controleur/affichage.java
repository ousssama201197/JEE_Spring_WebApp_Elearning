/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elearning.controleur;

import com.elearning.DaoImp.CoursDaoImp;
import com.elearning.DaoImp.DocumentDaoImp;
import com.elearning.DaoImp.EtudiantCoursDaoImp;
import com.elearning.DaoImp.ExamenDaoImp;
import com.elearning.DaoImp.QuizDaoImp;
import com.elearning.DaoImp.UtilisateurDaoImp;
import com.elearning.entities.Examen;
import com.elearning.entities.Quiz;
import com.elearning.entities.Utilisateur;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Amina
 */
@Controller
public class affichage {

    @Autowired
    public UtilisateurDaoImp DaoUtilisateur;
    @Autowired
    public CoursDaoImp DaoCours;
    @Autowired
    public EtudiantCoursDaoImp DaoEtudiantCours;
    @Autowired
    public DocumentDaoImp DaoDoc;
    @Autowired
    public ExamenDaoImp DaoExamen;
    @Autowired
    public QuizDaoImp DaoQuiz;

    @GetMapping(value = "/affichage")
    public ModelAndView index(HttpServletRequest request) {
        ModelAndView model = new ModelAndView();
        try {
            String username = request.getSession(true).getAttribute("login").toString();
            Utilisateur etud = DaoUtilisateur.ExistsByUsername(username);
            if (etud != null) {
                if (etud.getType().equals("etudiant")) {

                    model.addObject("listedocument", DaoDoc.CoursByName(new Long(request.getParameter("id"))));
                    List<Examen> listEx = DaoExamen.ExamenBycours(new Long(request.getParameter("id")));
                    int i = 0;
                    Examen x = null;
                    Date now = new Date();
                    Quiz q =null ;
                    try {
                        while ((x = listEx.get(i)) != null) {

                            if (now.compareTo(x.getDate_expiration()) == -1) {
                               q = DaoQuiz.QuizByexamen(x.getId());

                                model.addObject("q", q.getQuestion());
                                model.addObject("id", q.getId());
                                model.addObject("c1", q.getChoix1());
                                model.addObject("c2", q.getChoix2());
                                model.addObject("c3", q.getChoix3());
                            }
                            i++;
                        }
                    } catch (Exception e) {
                    }

                    
                    if (q == null) {
                        model.addObject("erreur", "none");
                        model.addObject("message", "pas d'examen");
                        model.setViewName("Affcours");
                        return model;
                    }
                 model.addObject("date",x.getDate_expiration());
                 
                    model.setViewName("Affcours");
                    return model;
                } else if (etud.getType().equals("ens")) {
                    model.addObject("listecours", DaoEtudiantCours.Coursinvalide(false, username));
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
            model.setViewName("login");
            return model;
        }
    }

}
