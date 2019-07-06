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

@Controller
public class HomeEtudiant {

    @Autowired
    public CoursDaoImp DaoCours;
    @Autowired
    public UtilisateurDaoImp DaoEtudiant;
    @Autowired
    public EtudiantCoursDaoImp DaoEtudiantCours;

    @RequestMapping(value="/home_etudiant")
    public ModelAndView base(HttpServletRequest request) {
        try {
            String username = request.getSession(true).getAttribute("login").toString();
            
            ModelAndView model =  new ModelAndView("home_etudiant");
            model.addObject("listCours", DaoEtudiantCours.CoursByEtudiant(username));
            return model;
             
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.err.println("erreur");
                  ModelAndView model =  new ModelAndView("login");
            return model;
        }
    }
    

            
@RequestMapping(value="/DemandeCours")
    public ModelAndView  demandecours(HttpServletRequest request) {
 ModelAndView model = new ModelAndView();
        try {
            String username = request.getSession(true).getAttribute("login").toString();
            Utilisateur etud = DaoEtudiant.ExistsByUsername(username);
            if (etud != null) {
                if (etud.getType().equals("etudiant")) {
                    // infos
                   Cours cours  =  DaoCours.CoursByName(request.getParameter("name"));
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
                    model.setViewName("home_etudiant");
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


}
