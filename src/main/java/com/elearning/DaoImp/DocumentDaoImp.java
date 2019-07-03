/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elearning.DaoImp;


import com.elearning.Dao.DocumentDao;
import com.elearning.entities.Document;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
@Service
@Transactional
public class DocumentDaoImp{
    @Autowired  DocumentDao repo;

      
    public void save(Document e) {
        repo.save(e);
    }
     
    public List<Document> listAll() {
        return (List<Document>) repo.findAll();
    }
     
    public Document get(Long id) {
        return repo.findById(id).get();
    }
    
    public void delete(Long id) {
        repo.deleteById(id);
    }
    
   
     
}

 
    
   

