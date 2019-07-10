/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elearning.controleur;

import com.elearning.Dao.ExamenDao;
import com.elearning.Dao.QuizDao;
import com.elearning.DaoImp.CoursDaoImp;
import com.elearning.DaoImp.DocumentDaoImp;
import com.elearning.DaoImp.EtudiantCoursDaoImp;
import com.elearning.DaoImp.ExamenDaoImp;
import com.elearning.DaoImp.QuizDaoImp;
import com.elearning.DaoImp.UtilisateurDaoImp;
import com.elearning.entities.Cours;
import com.elearning.entities.EtudiantCours;
import com.elearning.entities.Examen;
import com.elearning.entities.Quiz;
import com.elearning.entities.Utilisateur;
import com.elearning.outiles.Util;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
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
    @Autowired
    public DocumentDaoImp DaoDoc;
    @Autowired
    public ExamenDaoImp DaoExamen;
    @Autowired
    public QuizDaoImp DaoQuiz;

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
    public ModelAndView saveexam(HttpServletRequest request) throws ParseException {
        ModelAndView model = new ModelAndView();
        String username = "";
        try {
            username = request.getSession(true).getAttribute("login").toString();
             } catch (NullPointerException e) {
            System.err.println("erreur");
            model.setViewName("login");
            System.err.println(e.toString());
            return model;
        }
            Utilisateur etud = DaoUtilisateur.ExistsByUsername(username);
            if (etud != null) {
                if (etud.getType().equals("etudiant")) {
                    // infos
                    model.addObject("listCours", DaoEtudiantCours.CoursByEtudiant(username));
                    model.setViewName("home_etudiant");
                    return model;

                } else if (etud.getType().equals("ens")) {
                    // infos

                    String c1 = request.getParameter("c1");
                    String c2 = request.getParameter("c2");
                    String c3 = request.getParameter("c3");
                    String question = request.getParameter("question");
                    String reponse = request.getParameter("reponse");
                    String date = request.getParameter("date");
                    Cours cours = DaoCours.get(new Long(request.getParameter("idcours")));
                    Examen ex = new Examen();
                    Quiz q = new Quiz();

                    ex.setCours(cours);

                    SimpleDateFormat format = new SimpleDateFormat("MM-dd-yyyy");
                    ex.setDate_expiration(format.parse(date));
                      DaoExamen.save(ex);
                
                    q.setChoix1(c1);
                    q.setChoix2(c2);
                    q.setChoix3(c3);
                    q.setExamen(ex);
                    q.setQuestion(question);
                    q.setReponse(reponse);

                   
                    DaoQuiz.save(q);

                    String subject = "E-learning , nouveau examen";
                    String msg = "Un nouveau examen a ete ajoute  : " + cours.getName() + "\n"
                            + "Nom de l'enseigant  : " + cours.getEnseignant().getNom() + ""
                            + "Dead line : " + date;

                    List<EtudiantCours> list = DaoEtudiantCours.alletudiantByCours(new Long(request.getParameter("idcours")));
                    int i = 0;
                    Utilisateur user = null;
                    try {
                        while ((user = list.get(i).getEtudiant()) != null) {
                            Util.sendMail(msg, subject, user.getEmail());
                            i++;
                        }
                    } catch (Exception e) {
                    }

                    model.addObject("message", "<div class=\"alert alert-success alert-block fade in\">\n"
                            + "                                <button type=\"button\" class=\"close close-sm\" data-dismiss=\"alert\">\n"
                            + "                                    <i class=\"fa fa-times\"></i>\n"
                            + "                                </button>\n"
                            + "<p>Examen a ete ajoute</p>\n"
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
       
    }
    
    
            
    @RequestMapping(value = "/reponsequiz")
    public ModelAndView reponsequiz(HttpServletRequest request) throws ParseException {
        ModelAndView model = new ModelAndView();
        String username = "";
        try {
            username = request.getSession(true).getAttribute("login").toString();
             } catch (NullPointerException e) {
            System.err.println("erreur");
            model.setViewName("login");
            System.err.println(e.toString());
            return model;
        }
            Utilisateur etud = DaoUtilisateur.ExistsByUsername(username);
            if (etud != null) {
                if (etud.getType().equals("etudiant")) {
                  Quiz q =   DaoQuiz.get(new Long(request.getParameter("id")));
                            if(q.getReponse().equals(request.getParameter("reponse"))){
                                
                                model.addObject("message", "<div class=\"alert alert-success alert-block fade in\">\n"
                    + "                                <button type=\"button\" class=\"close close-sm\" data-dismiss=\"alert\">\n"
                    + "                                    <i class=\"fa fa-times\"></i>\n"
                    + "                                </button>\n"
                    + "<p> felicitation, la reponse est juste</p>\n"
                    + "                            </div>");
                                model.setViewName("reponse");
                             return model;
                             
                             
                            }else{         
                                model.addObject("message", "<span  class=\"alert alert-danger\""
                + " style=\"margin-left : 20px;margin-right : 20px;\">"
                + "  la reponse est fausse :( </span>");
                                model.setViewName("reponse");
                             return model;
                            
                            }
                         
                } else if (etud.getType().equals("ens")) {
                    // infos

                    return model;

                } else {
                    model.setViewName("login");
                    return model;
                }

            } else {
                model.setViewName("login");
                return model;
            }
       
    }
    
    
    
}
