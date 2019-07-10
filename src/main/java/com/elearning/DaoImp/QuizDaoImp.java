/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elearning.DaoImp;


import com.elearning.Dao.QuizDao;
import com.elearning.entities.Cours;
import com.elearning.entities.Quiz;
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
@Service
@Transactional
public class QuizDaoImp{
    @Autowired  QuizDao repo;

      
    public void save(Quiz e) {
        repo.save(e);
    }
     
    public List<Quiz> listAll() {
        return (List<Quiz>) repo.findAll();
    }
     
    public Quiz get(Long id) {
        return repo.findById(id).get();
    }
    
    public void delete(Long id) {
        repo.deleteById(id);
    }
     public Quiz QuizByexamen(Long id){
   return  repo.QuizByexamen(id);
    }
     
}

 
    
   

