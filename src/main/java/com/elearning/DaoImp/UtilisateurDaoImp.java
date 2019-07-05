/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elearning.DaoImp;

import com.elearning.Dao.UtilisateurDao;
import com.elearning.Dao.UtilisateurDao;
import com.elearning.entities.Utilisateur;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UtilisateurDaoImp {

    @Autowired
    UtilisateurDao repo;

    public void save(Utilisateur e) {
        repo.save(e);
    }

    public List<Utilisateur> listAll() {
        return (List<Utilisateur>) repo.findAll();
    }

    public Utilisateur get(Long id) {
        return repo.findById(id).get();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public Utilisateur login(String user, String pass) {
        return repo.login(user, pass);
    }
  public Utilisateur ExistsByUsername(String user) {
        return repo.ExistsByUsername(user);
    }
    public Utilisateur ExistsByEmail(String email) {
        return repo.ExistsByEmail(email);
    }
    
}
