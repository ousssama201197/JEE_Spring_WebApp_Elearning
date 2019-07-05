package com.elearning.controleur;

import com.elearning.DaoImp.CoursDaoImp;
import com.elearning.DaoImp.UtilisateurDaoImp;
import com.elearning.entities.Utilisateur;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class HomeEnseigant {

    @Autowired
    public UtilisateurDaoImp DaoUtilisateur;
    @Autowired
    public CoursDaoImp DaoCours;



    @RequestMapping(value = "/home_enseigant")
    public String index(HttpServletRequest request) {
       try {
            String username = request.getSession(true).getAttribute("login").toString();
            Utilisateur etud = DaoUtilisateur.ExistsByUsername(username);
            if (etud != null) {
                if (etud.getType().equals("etudiant")) {
                    // infos
                    return "redirect:/home_etudiant";
                } else if (etud.getType().equals("ens")) {
                      return "home_enseigant";
// traitement 
                } else {
                    return "login";
                }

            } else {
                return "login";
            }
        } catch (NullPointerException e) {
            System.err.println("erreur");
            return "login";
        }
        }

    }
