/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elearning.DaoImp;


import com.elearning.Dao.CoursDao;
import com.elearning.entities.Cours;
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
@Service
@Transactional
public class CoursDaoImp{
    @Autowired  CoursDao repo;

      
    public void save(Cours e) {
        repo.save(e);
    }
     
    public List<Cours> listAll() {
        return (List<Cours>) repo.findAll();
    }
     
    public Cours get(Long id) {
        return repo.findById(id).get();
    }
    
    public void delete(Long id) {
        repo.deleteById(id);
    }
    
    public List<Cours> CoursByEnseignant(Long id){
   return  repo.coursByEnseignant(id);
    }    
    public Cours CoursByName(String name){
   return  repo.coursByName(name);
    }
     
}

 
    
   

