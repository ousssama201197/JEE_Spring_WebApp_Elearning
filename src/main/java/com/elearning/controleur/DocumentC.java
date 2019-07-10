/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elearning.controleur;

import com.elearning.DaoImp.CoursDaoImp;
import com.elearning.DaoImp.DocumentDaoImp;
import com.elearning.DaoImp.EtudiantCoursDaoImp;
import com.elearning.DaoImp.UtilisateurDaoImp;
import com.elearning.entities.Cours;
import com.elearning.entities.Document;
import com.elearning.entities.EtudiantCours;
import com.elearning.entities.Utilisateur;
import com.elearning.outiles.Util;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Amina
 */
@Controller

public class DocumentC {

    @Autowired
    public UtilisateurDaoImp DaoUtilisateur;
    @Autowired
    public CoursDaoImp DaoCours;
    @Autowired
    public EtudiantCoursDaoImp DaoEtudiantCours;
    @Autowired
    public DocumentDaoImp DaoDoc;

    @RequestMapping(value = "/ajouter_document")
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
                    model.addObject("username", etud.getNom() + "  " + etud.getPrenom());
                    model.addObject("listecours", DaoCours.CoursByEnseignant(etud.getId()));
                    model.setViewName("ajouter_document");
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

    @PostMapping(value = "/savedoc")
    public ModelAndView savedoc(HttpServletRequest request) throws IOException, ServletException {
        ModelAndView model = new ModelAndView();
        try {
            String username = request.getSession(true).getAttribute("login").toString();
            Utilisateur etud = DaoUtilisateur.ExistsByUsername(username);
            if (etud != null) {
                if (etud.getType().equals("etudiant")) {
                    model.addObject("username", etud.getNom() + "  " + etud.getPrenom());
                    model.addObject("listCours", DaoEtudiantCours.CoursByEtudiant(username));
                    model.setViewName("");
                    return model;

                } else if (etud.getType().equals("ens")) {
                    String dec = request.getParameter("Des");

                    Cours cours = DaoCours.get(new Long(request.getParameter("idcours")));

                    InputStream inputfile = request.getPart("file").getInputStream();
                    OutputStream outputStream = null;
                    String url = "C:\\Users\\Amina\\Desktop\\" + cours.getId() + Util.getFilename(request.getPart("file"));
                    File file = new File(url);
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    outputStream = new FileOutputStream(file);
                    IOUtils.copy(inputfile, outputStream);
                    inputfile.close();
                    Document doc = new Document();
                    doc.setCours(cours);
                    doc.setUrl(url);
                    doc.setName(request.getParameter("name"));
                    doc.setType("pdf");
                    doc.setDescription(dec);
                    DaoDoc.save(doc);
                    String subject = "E-learning , nouveau document";
                    String msg = "Un nouveau document a ete ajoute  : " + cours.getName() + "\n"
                            + "Nom de l'enseigant  : " + cours.getEnseignant().getNom();

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
                            + "<p>Document ajouter</p>\n"
                            + "                            </div>");
                    model.setViewName("ajouter_document");
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

    @RequestMapping(value = "/downfile")
    public String filedown(HttpServletResponse response, HttpServletRequest req) {

        try {
            File file = new File(DaoDoc.get(new Long(req.getParameter("id"))).getUrl());
            response.setContentType("application/pdf");
            FileInputStream in = new FileInputStream(file);
            IOUtils.copy(in, response.getOutputStream());
            response.flushBuffer();
            return "login";
        } catch (IOException ex) {
            return "login";
        }

    }

}
