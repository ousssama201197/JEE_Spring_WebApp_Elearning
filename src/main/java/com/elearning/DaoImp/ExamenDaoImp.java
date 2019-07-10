/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elearning.DaoImp;


import com.elearning.Dao.ExamenDao;
import com.elearning.entities.Cours;
import com.elearning.entities.Examen;
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
@Service
@Transactional
public class ExamenDaoImp{
    @Autowired  ExamenDao repo;

      
    public void save(Examen e) {
        repo.save(e);
    }
     
    public List<Examen> listAll() {
        return (List<Examen>) repo.findAll();
    }
     
    public Examen get(Long id) {
        return repo.findById(id).get();
    }
    
    public void delete(Long id) {
        repo.deleteById(id);
    }
     public List<Examen> ExamenBycours(Long id){
   return  repo.ExamenBycours(id);
    }
     
     
}

 
    
   

