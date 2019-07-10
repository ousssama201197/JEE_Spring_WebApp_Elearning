package com.elearning.controleur;

import com.elearning.DaoImp.CoursDaoImp;
import com.elearning.DaoImp.EtudiantCoursDaoImp;
import com.elearning.DaoImp.UtilisateurDaoImp;
import com.elearning.entities.Cours;
import com.elearning.entities.EtudiantCours;
import com.elearning.entities.Utilisateur;
import com.elearning.outiles.Util;
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

                } else if (etud.getType().equals("ens")) {
                    // infos
                    System.err.println("oussama" + DaoEtudiantCours.Coursinvalide(false, username).get(0).getId());
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
            System.err.println("erreur");
            model.setViewName("login");
            return model;
        }
    }

    @GetMapping(value = "/valider")
    public ModelAndView validationCours(HttpServletRequest request) {
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

                    EtudiantCours coursetudiant = DaoEtudiantCours.get(new Long(request.getParameter("id")));
                    Utilisateur etudiant = DaoUtilisateur.get(new Long(request.getParameter("id2")));
                   
                    coursetudiant.setValider(true);
                    DaoEtudiantCours.save(coursetudiant);
                    String msg = "votre inscription au Cours  : " + coursetudiant.getCours().getName() + "\n"
                            + "Nom de l'enseigant  : " + coursetudiant.getCours().getEnseignant().getNom();

                    String subject = "E-learning,inscription a été validé";
                    Util.sendMail(msg, subject, etudiant.getEmail());

                    model.addObject("message", "<div class=\"alert alert-success alert-block fade in\">\n"
                            + "                                <button type=\"button\" class=\"close close-sm\" data-dismiss=\"alert\">\n"
                            + "                                    <i class=\"fa fa-times\"></i>\n"
                            + "                                </button>\n"
                            + "<p> cours a été validé</p>\n"
                            + "                            </div>");
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
        } catch (Exception e) {
            model.setViewName("login");
            return model;
        }

    }

    @GetMapping(value = "/delete")
    public ModelAndView SupprimerCours(HttpServletRequest request) {
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

                    Cours cours = DaoCours.get(Long.parseLong(request.getParameter("id")));
                    Utilisateur etudiant = DaoUtilisateur.get(Long.parseLong(request.getParameter("id2")));
                    String msg = "votre inscription au Cours  : " + cours.getName() + "\n"
                            + "Nom de l'enseigant  : " + cours.getEnseignant().getNom();

                    String subject = "E-learning,mot de passe oublié";
                    Util.sendMail(msg, subject, etudiant.getEmail());

                    model.addObject("message", "<div class=\"alert alert-success alert-block fade in\">\n"
                            + "                                <button type=\"button\" class=\"close close-sm\" data-dismiss=\"alert\">\n"
                            + "                                    <i class=\"fa fa-times\"></i>\n"
                            + "                                </button>\n"
                            + "<p> cours ajouté</p>\n"
                            + "                            </div>");
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
