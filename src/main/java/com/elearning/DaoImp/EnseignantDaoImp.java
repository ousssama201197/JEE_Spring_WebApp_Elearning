/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elearning.DaoImp;

import com.elearning.Dao.EnseignantDao;
import com.elearning.Dao.EnseignantDao;
import com.elearning.entities.Enseignant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EnseignantDaoImp {

    @Autowired
    EnseignantDao repo;

    public void save(Enseignant e) {
        repo.save(e);
    }

    public List<Enseignant> listAll() {
        return (List<Enseignant>) repo.findAll();
    }

    public Enseignant get(Long id) {
        return repo.findById(id).get();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public List<Enseignant> login(String user, String pass) {
        return repo.login(user, pass);
    }

}
