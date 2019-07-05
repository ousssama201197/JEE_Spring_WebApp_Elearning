package com.elearning.controleur;

import com.elearning.DaoImp.CoursDaoImp;
import com.elearning.DaoImp.UtilisateurDaoImp;
import com.elearning.entities.Utilisateur;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String index(HttpServletRequest request) {
        try {
            String username = request.getSession(true).getAttribute("login").toString();
            Utilisateur etud = DaoUtilisateur.ExistsByUsername(username);
            if (etud != null) {
                if (etud.getType().equals("etudiant")) {
                    // infos
                    return "redirect:/home_etudiant";

                } else if (etud.getType().equals("ens")) {
                    return "nouveau_cours";

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

//                    request.getParameter("name");
//                    request.getParameter("description");
//                    Cours cours = new Cours();
//                    cours.setEnseignant(etud);
//                    cours.setName(username);
}
