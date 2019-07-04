
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
import com.elearning.entities.EtudiantCours;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
 
public interface EtudiantCoursDao  extends CrudRepository<EtudiantCours, Long>  {

    @Override
    public void delete(EtudiantCours t);

    @Override
    public Iterable<EtudiantCours> findAll();

    @Override
    public Optional<EtudiantCours> findById(Long id);

    @Override
    public boolean existsById(Long id);

    @Override
    public long count();

    @Override
    public void deleteAll();

    @Override
    public void deleteAll(Iterable<? extends EtudiantCours> itrbl);

    @Override
    public void deleteById(Long id);

    @Override
    public boolean equals(Object obj);

    @Override
    public Iterable<EtudiantCours> findAllById(Iterable<Long> itrbl); 

     
} 