package com.elearning.controleur;

import com.elearning.DaoImp.CoursDaoImp;
import com.elearning.DaoImp.EnseignantDaoImp;
import com.elearning.DaoImp.EtudiantDaoImp;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value = "/home_etudiant")
public class HomeEtudiant {

    @Autowired
    public EnseignantDaoImp DaoEnseigant;
    @Autowired
    public CoursDaoImp DaoCours;
    @Autowired
    public EtudiantDaoImp DaoEtudiant;

    @GetMapping
    public String base(HttpServletRequest request) {

            return "home_etudiant";
        }

    }

