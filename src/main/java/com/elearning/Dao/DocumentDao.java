
package com.elearning.Dao;

/**
 *
 * @author Amina
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.elearning.entities.Document;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
 
public interface DocumentDao  extends CrudRepository<Document, Long>  {

    @Override
    public void delete(Document t);

    @Override
    public Iterable<Document> findAll();

    @Override
    public Optional<Document> findById(Long id);

    @Override
    public boolean existsById(Long id);

    @Override
    public long count();

    @Override
    public void deleteAll();

    @Override
    public void deleteAll(Iterable<? extends Document> itrbl);

    @Override
    public void deleteById(Long id);

    @Override
    public boolean equals(Object obj);

    @Override
    public Iterable<Document> findAllById(Iterable<Long> itrbl); 

      
  @Query(value = "SELECT c FROM Document c WHERE c.cours.id = :id") // ?1 , ?2 selon l'order dans la fonction 
  public List<Document>  DocumentBycours(@Param("id") Long keyword);
    
} 