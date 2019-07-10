/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elearning.DaoImp;

import com.elearning.Dao.EtudiantCoursDao;
import com.elearning.entities.EtudiantCours;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EtudiantCoursDaoImp {

    @Autowired
    EtudiantCoursDao repo;

    public void save(EtudiantCours e) {
        repo.save(e);
    }

    public List<EtudiantCours> listAll() {
        return (List<EtudiantCours>) repo.findAll();
    }

    public EtudiantCours get(Long id) {
        return repo.findById(id).get();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public List<EtudiantCours> CoursByEtudiant(String username) {
        return repo.coursByEtudiant(username);
    }

    public List<EtudiantCours> CoursByEnseignant(String username) {
        return repo.coursByEnseignant(username);
    }

    public List<EtudiantCours> Coursinvalide(Boolean bool, String username) {
        return repo.coursInvalide(bool, username);
    }
    
     public List<EtudiantCours> alletudiantByCours(Long id) {
        return repo.AlletudiantByCours(id);
    }
}
