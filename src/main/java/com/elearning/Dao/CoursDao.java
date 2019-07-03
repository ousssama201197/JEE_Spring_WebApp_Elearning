
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
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
 
public interface CoursDao  extends CrudRepository<Cours, Long>  {

    @Override
    public void delete(Cours t);

    @Override
    public Iterable<Cours> findAll();

    @Override
    public Optional<Cours> findById(Long id);

    @Override
    public boolean existsById(Long id);

    @Override
    public long count();

    @Override
    public void deleteAll();

    @Override
    public void deleteAll(Iterable<? extends Cours> itrbl);

    @Override
    public void deleteById(Long id);

    @Override
    public boolean equals(Object obj);

    @Override
    public Iterable<Cours> findAllById(Iterable<Long> itrbl); 

     @Query(value = "SELECT c FROM Cours c WHERE c.enseignant.id = :idenseignant") // ?1 , ?2 selon l'order dans la fonction 
    public List<Cours> coursByEnseignant(@Param("idenseignant") Long keyword);
     
} 