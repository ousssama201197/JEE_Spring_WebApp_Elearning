package com.elearning.controleur;

import com.elearning.DaoImp.CoursDaoImp;
import com.elearning.DaoImp.EtudiantCoursDaoImp;
import com.elearning.DaoImp.UtilisateurDaoImp;
import com.elearning.entities.Utilisateur;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class HomeEnseigant {

   
    @Autowired
    public UtilisateurDaoImp DaoUtilisateur;
    @Autowired
    public CoursDaoImp DaoCours;
    @Autowired
    public EtudiantCoursDaoImp DaoEtudiantCours;


    @RequestMapping(value = "/home_enseigant")
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

                } else 
                    
                {
                    if (etud.getType().equals("ens")) {
                    // infos
                        System.err.println("oussama" + DaoEtudiantCours.Coursinvalide(false,username).get(0).getId());
                    model.addObject("listecours", DaoEtudiantCours.Coursinvalide(false,username));
                    model.setViewName("home_enseigant");
                    return model;

                } else {
                    model.setViewName("login");
                    return model;
                }
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
