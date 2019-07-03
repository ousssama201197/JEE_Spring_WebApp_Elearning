/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elearning.DaoImp;

import com.elearning.Dao.EtudiantDao;
import com.elearning.entities.Cours;
import com.elearning.entities.Etudiant;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EtudiantDaoImp {

    @Autowired
    EtudiantDao repo;

    public void save(Etudiant e) {
        repo.save(e);
    }

    public List<Etudiant> listAll() {
        return (List<Etudiant>) repo.findAll();
    }

    public Etudiant get(Long id) {
        return repo.findById(id).get();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public List<Etudiant> login(String user, String pass) {
        return repo.login(user, pass);
    }
}
