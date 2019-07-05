package com.elearning.controleur;

import com.elearning.DaoImp.CoursDaoImp;
import com.elearning.DaoImp.EtudiantCoursDaoImp;
import com.elearning.DaoImp.UtilisateurDaoImp;
import com.elearning.DaoImp.UtilisateurDaoImp;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
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

}
