package com.elearning.controleur;

import com.elearning.DaoImp.CoursDaoImp;
import com.elearning.DaoImp.UtilisateurDaoImp;
import com.elearning.entities.Etudiant;
import com.elearning.entities.Utilisateur;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


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

    @GetMapping(value = "/login")
    public String auth(HttpServletRequest request,Model model) {

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
    private static String getFilename(Part part) {
        for (String cd : part.getHeader("content-disposition").split(";")) {
            if (cd.trim().startsWith("filename")) {
                return cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }
}
