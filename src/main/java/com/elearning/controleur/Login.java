package com.elearning.controleur;

import com.elearning.DaoImp.CoursDaoImp;
import com.elearning.DaoImp.UtilisateurDaoImp;
import com.elearning.entities.Utilisateur;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import outiles.Util;

@Controller
@RequestMapping(value = "/")
public class Login {

    @Autowired
    public UtilisateurDaoImp DaoUtilisateur;
    @Autowired
    public CoursDaoImp DaoCours;

    @GetMapping
    public String m(HttpServletRequest request) {
        try { 
            System.err.println(request.getSession(true).getAttribute("login").toString());
            return "index";
        } catch (NullPointerException e) {
            System.err.println("erreur");
            return "login";
        }

    }

    @GetMapping(value = "/mdpoublier/restauration")
    public String mdpoublier(HttpServletRequest request, Model model) {
        try{
        String email = request.getParameter("email");
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
                    + "       <img class=\"img\" src=\"http://www.orlecplus.com/images/homologer.png\" />\n"
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
            String subject = "Sonelgaz ,mot de passe oublié";
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

        }catch(NullPointerException e){
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
    public String auth(HttpServletRequest request, Model model) {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String type = request.getParameter("type");
        try {
            request.getSession(true).setAttribute("login", username);

            if (username.equals("") || password.equals("")) {

                return "login";
            } else {
                if (type.equals("etudiant")) {
                    try {
                        Utilisateur etud = DaoUtilisateur.login(username, password).get(0);

                        return "redirect:/home_etudiant";

                    } catch (IndexOutOfBoundsException e) {

                        System.err.println("erreur null");
                        model.addAttribute("erreur", "<span  class=\"alert alert-danger\">  erreur </span>");

                        return "login";
                    }

                } else if (type.equals("ens")) {
                    return "redirect:/home_enseigant";
                }
                return "login";
            }

        } catch (NullPointerException e) {
            System.err.println("erreur");
            return "login";
        }

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
}
