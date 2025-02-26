package com.elearning.controleur;

import com.elearning.DaoImp.CoursDaoImp;
import com.elearning.DaoImp.EtudiantCoursDaoImp;
import com.elearning.DaoImp.UtilisateurDaoImp;
import com.elearning.entities.Utilisateur;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.elearning.outiles.Util;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Login {

    @Autowired
    public UtilisateurDaoImp DaoUtilisateur;
    @Autowired
    public CoursDaoImp DaoCours;
    @Autowired
    public EtudiantCoursDaoImp DaoEtudiantCours;

    @RequestMapping(value = "/")
    public ModelAndView index(HttpServletRequest request) {
        ModelAndView model = new ModelAndView();
        try {
            String username = request.getSession(true).getAttribute("login").toString();
            Utilisateur etud = DaoUtilisateur.ExistsByUsername(username);
            if (etud != null) {
                if (etud.getType().equals("etudiant")) {
                    // infos
                    model.addObject("listCours", DaoEtudiantCours.CoursByEtudiant(username));
                    model.addObject("username", etud.getNom() + "  " + etud.getPrenom());

                    model.setViewName("home_etudiant");
                    return model;

                } else if (etud.getType().equals("ens")) {
                    // infos
                    model.addObject("listecours", DaoEtudiantCours.Coursinvalide(false, username));
                    model.setViewName("home_enseigant");
                    model.addObject("username", etud.getNom() + "  " + etud.getPrenom());

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

    @GetMapping(value = "/mdpoublier/restauration")
    public String mdpoublier(HttpServletRequest request, Model model) {
        try {
            
            String email = request.getParameter("email");
            System.err.println("rachid" + email);
            Utilisateur user = DaoUtilisateur.ExistsByEmail(email);
            String msg = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\"\n"
                    + "        \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n"
                    + "<!-- saved from url=(0014)about:internet -->\n"
                    + "<html xmlns=\"http://www.w3.org/1999/xhtml\">\n"
                    + "<head>\n"
                    + "    <title>relance.png</title>\n"
                    + "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"/>\n"
                    + "    <style type=\"text/css\">\n"
                    + ".block{\n"
                    + "\n"
                    + "\n"
                    + "margin-left:33.333333%;\n"
                    + "width: 600px;\n"
                    + "height: 650px;\n"
                    + "padding: 19px;\n"
                    + "background-color:  #fff;\n"
                    + "border-radius: 6px;\n"
                    + "\n"
                    + "\n"
                    + "}\n"
                    + ".block2{\n"
                    + "\n"
                    + "\n"
                    + "margin-left:33.333333%;\n"
                    + "width: 600px;\n"
                    + "height: 100px;\n"
                    + "padding: 19px;\n"
                    + "background-color:  #fff;\n"
                    + "border-radius: 6px;\n"
                    + "\n"
                    + "\n"
                    + "}\n"
                    + ".img{\n"
                    + "margin-left : 30%;\n"
                    + "}\n"
                    + "\n"
                    + ".btn{\n"
                    + "background-color:  #3498DB;\n"
                    + "margin-left:34.333333%;\n"
                    + "border-radius: 3px;\n"
                    + "color: white;\n"
                    + "border: none;\n"
                    + "height: 50px;\n"
                    + "width: 150px;\n"
                    + "\n"
                    + "}\n"
                    + "\n"
                    + ".btn2{\n"
                    + "color: white;\n"
                    + "text-decoration: none;\n"
                    + "}\n"
                    + "\n"
                    + "    </style>\n"
                    + "</head>\n"
                    + "\n"
                    + "<body style = \" background-color:  #DADFE1;\">\n"
                    + "\n"
                    + "\n"
                    + "        <div class=\"block\">\n"
                    + "\n"
                    + "       <img class=\"img\" src=\"\" />\n"
                    + "\n"
                    + "             <h2>Salut " + user.getNom() + "  " + user.getPrenom() + " </h2>\n"
                    + "             <h2>  Veuillez changer votre mot de passe dans la page ci dessous: </h2>\n"
                    + "\n"
                    + "\n"
                    + "<a href=\'http://localhost:8080/learning2/mdp/restauration?code=" + Util.sha256(user.getEmail() + user.getNom() + user.getTelephone()) + "' class=\"btn2\"><button class=\"btn\">Récuperer votre mot de passe</button></a>"
                    + "\n"
                    + "             \n"
                    + "\n"
                    + "<br/><br/><br/><br/>\n"
                    + "\n"
                    + "                \n"
                    + "         </div>\n"
                    + "\n"
                    + "         <br/><br/>\n"
                    + "\n"
                    + "         <div class=\"block2\">\n"
                    + "          Veuillez a ne pas répondre à ce message, car il est envoyée automatiquement.\";\n"
                    + "          </div>\n"
                    + "\n"
                    + "\n"
                    + "\n"
                    + "</body>\n"
                    + "\n"
                    + "\n"
                    + "</html>";
            String subject = "E-learning,mot de passe oublié";
            Util.sendMail(msg, subject, email);

            model.addAttribute("message", "<div class=\"alert alert-success alert-block fade in\">\n"
                    + "                                <button type=\"button\" class=\"close close-sm\" data-dismiss=\"alert\">\n"
                    + "                                    <i class=\"fa fa-times\"></i>\n"
                    + "                                </button>\n"
                    + "                                <h4>\n"
                    + "                                    <i class=\"icon-ok-sign\"></i>\n"
                    + "                                    Success!\n"
                    + "                                </h4>\n"
                    + "<p> verifier votre boite mail un lien de recuperation a été envoyer</p>\n"
                    + "                            </div>");
            return "mdpoublier";

        } catch (NullPointerException e) {
            model.addAttribute("message", "<div class=\"row\">"
                    + "<div style='margin-left : 20%;'> "
                    + "<span  class=\"alert alert-danger\">votre compte n'existe pas ;( </span>"
                    + "</div>"
                    + "</div>"
                    + "");
            return "mdpoublier";
        }
    }

    @GetMapping(value = "/mdp/restauration")
    public String resetmdp(HttpServletRequest request) {
        request.getParameter("code");
        try {
            System.err.println(request.getSession(true).getAttribute("login").toString());
            return "index";
        } catch (NullPointerException e) {
            System.err.println("erreur");
            return "login";
        }

    }

    @GetMapping(value = "/mdpoublier")
    public String resetmdp() {
        return "mdpoublier";
    }

    @GetMapping(value = "/login")
    public ModelAndView auth(HttpServletRequest request) {
        ModelAndView model = new ModelAndView();
        if (request.getSession(true).getAttribute("login") != null) {
            return index(request);
        }

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //   String type = request.getParameter("type");
        try {
            request.getSession(true).setAttribute("login", username);

            if (username.equals("") || password.equals("")) {
                model.setViewName("login");
                return model;

            } else {
                Utilisateur etud = DaoUtilisateur.login(username, Util.sha256(password));
                if (etud != null) {

                    if (etud.getType().equals("etudiant")) {

                        // infos
                        model.addObject("listCours", DaoEtudiantCours.CoursByEtudiant(username));
                        model.addObject("username", etud.getNom() + "  " + etud.getPrenom());
                        model.setViewName("home_etudiant");
                        return model;

                    } else if (etud.getType().equals("ens")) {
                        // infos

                        model.setViewName("home_enseigant");
                        model.addObject("listecours", DaoEtudiantCours.Coursinvalide(false, username));
                        model.setViewName("home_enseigant");
                        model.addObject("listeEtudiantCours", DaoEtudiantCours.CoursByEnseignant(etud.getUsername()));
                        return model;
                    }

                }

            }

        } catch (NullPointerException e) {
            model.setViewName("login");
            model.addObject("erreur", "<span  class=\"alert alert-danger\""
                    + " style=\"margin-left : 20px;\">"
                    + "  nom d'utilisateur où mot de passse incorrect </span>");
            return model;
        }
        model.setViewName("login");
        model.addObject("erreur", "<span  class=\"alert alert-danger\""
                + " style=\"margin-left : 20px;margin-right : 20px;\">"
                + "  erreur </span>");
        return model;
    }

//    @PostMapping(value = "/jsp/index")
//    public String submit(HttpServletRequest request) throws IOException, FileUploadException, ServletException {
//        InputStream inputfile = request.getPart("file").getInputStream();
//        OutputStream outputStream = null;
//        File file = new File("C:\\Users\\Amina\\Desktop\\" + getFilename(request.getPart("file")));
//        if (!file.exists()) {
//            file.createNewFile();
//        }
//        outputStream = new FileOutputStream(file);
//        IOUtils.copy(inputfile, outputStream);
//        inputfile.close();
//        return "index";
//    }
   
    @RequestMapping(value = "/logout")
    public String filedown(HttpServletRequest request) {
        request.getSession(true).removeAttribute("login");
        return "login";
    }
}
