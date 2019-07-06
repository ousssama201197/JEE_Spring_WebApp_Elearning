package com.elearning.controleur;

import com.elearning.DaoImp.CoursDaoImp;
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
public class NouveauCours {

    @Autowired
    public UtilisateurDaoImp DaoUtilisateur;
    @Autowired
    public CoursDaoImp DaoCours;

    @RequestMapping("/nouveau_cours")
    public ModelAndView index(HttpServletRequest request) {
        try {
            String username = request.getSession(true).getAttribute("login").toString();
            Utilisateur etud = DaoUtilisateur.ExistsByUsername(username);
            if (etud != null) {
                if (etud.getType().equals("etudiant")) {
                    // infos

                    ModelAndView model = new ModelAndView("home_etudiant");
                    model.addObject("username", etud.getNom() + "  " + etud.getPrenom());
                    return model;

                } else if (etud.getType().equals("ens")) {
                    ModelAndView model = new ModelAndView("nouveau_cours");
                    model.addObject("username", etud.getNom() + "  " + etud.getPrenom());

                    return model;

// traitement 
                } else {
                    ModelAndView model = new ModelAndView("login");
                    return model;
                }

            } else {
                ModelAndView model = new ModelAndView("login");
                return model;
            }
        } catch (NullPointerException e) {
            System.err.println("erreur");
            ModelAndView model = new ModelAndView("login");
            return model;
        }
    }
    
    
    
    @RequestMapping("/nouveau_cours/save")
    public ModelAndView save(HttpServletRequest request) {
        try {
            String username = request.getSession(true).getAttribute("login").toString();
            Utilisateur etud = DaoUtilisateur.ExistsByUsername(username);
            if (etud != null) {
                if (etud.getType().equals("etudiant")) {
                    // infos

                    ModelAndView model = new ModelAndView("home_etudiant");
                    model.addObject("username", etud.getNom() + "  " + etud.getPrenom());
                    return model;

                } else if (etud.getType().equals("ens")) {
                    
                    Cours cours = new Cours();
                    cours.setEnseignant(etud);
                    cours.setName(request.getParameter("name"));
                    DaoCours.save(cours);
                    String dis = request.getParameter("dis");
                    
                    ModelAndView model = new ModelAndView("nouveau_cours");
                    model.addObject("message", "<div class=\"alert alert-success alert-block fade in\">\n"
                    + "                                <button type=\"button\" class=\"close close-sm\" data-dismiss=\"alert\">\n"
                    + "                                    <i class=\"fa fa-times\"></i>\n"
                    + "                                </button>\n"
                    + "<p> cours ajouté</p>\n"
                    + "                            </div>");
                    model.addObject("username", etud.getNom() + "  " + etud.getPrenom());
                    return model;

// traitement 
                } else {
                    ModelAndView model = new ModelAndView("login");
                    return model;
                }

            } else {
                ModelAndView model = new ModelAndView("login");
                return model;
            }
        } catch (NullPointerException e) {
            System.err.println("erreur");
            ModelAndView model = new ModelAndView("login");
            return model;
        }
    }

//                    request.getParameter("name");
//                    request.getParameter("description");
//                    Cours cours = new Cours();
//                    cours.setEnseignant(etud);
//                    cours.setName(username);
}
