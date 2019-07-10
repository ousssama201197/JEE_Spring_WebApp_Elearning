
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
import com.elearning.entities.Examen;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
 
public interface ExamenDao  extends CrudRepository<Examen, Long>  {

    @Override
    public void delete(Examen t);

    @Override
    public Iterable<Examen> findAll();

    @Override
    public Optional<Examen> findById(Long id);

    @Override
    public boolean existsById(Long id);

    @Override
    public long count();

    @Override
    public void deleteAll();

    @Override
    public void deleteAll(Iterable<? extends Examen> itrbl);

    @Override
    public void deleteById(Long id);

    @Override
    public boolean equals(Object obj);

    @Override
    public Iterable<Examen> findAllById(Iterable<Long> itrbl); 
    
     
} 