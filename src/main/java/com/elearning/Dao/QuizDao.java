
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
import com.elearning.entities.Cours;
import com.elearning.entities.Document;
import com.elearning.entities.Quiz;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
 
public interface QuizDao  extends CrudRepository<Quiz, Long>  {

    @Override
    public void delete(Quiz t);

    @Override
    public Iterable<Quiz> findAll();

    @Override
    public Optional<Quiz> findById(Long id);

    @Override
    public boolean existsById(Long id);

    @Override
    public long count();

    @Override
    public void deleteAll();

    @Override
    public void deleteAll(Iterable<? extends Quiz> itrbl);

    @Override
    public void deleteById(Long id);

    @Override
    public boolean equals(Object obj);

    @Override
    public Iterable<Quiz> findAllById(Iterable<Long> itrbl); 

  @Query(value = "SELECT c FROM Quiz c WHERE c.examen.id = :id") // ?1 , ?2 selon l'order dans la fonction 
  public Quiz  QuizByexamen(@Param("id") Long keyword);
  
} 