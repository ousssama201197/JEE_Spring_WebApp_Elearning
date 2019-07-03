
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
import com.elearning.entities.Enseignant;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
 
public interface EnseignantDao  extends CrudRepository<Enseignant, Long>  {

    @Override
    public void delete(Enseignant t);

    @Override
    public Iterable<Enseignant> findAll();

    @Override
    public Optional<Enseignant> findById(Long id);

    @Override
    public boolean existsById(Long id);

    @Override
    public long count();

    @Override
    public void deleteAll();

    @Override
    public void deleteAll(Iterable<? extends Enseignant> itrbl);

    @Override
    public void deleteById(Long id);

    @Override
    public boolean equals(Object obj);

    @Override
    public Iterable<Enseignant> findAllById(Iterable<Long> itrbl);

    @Query(value = "SELECT c FROM Enseignant c WHERE c.username = :username AND c.password= :password") // ?1 , ?2 selon l'order dans la fonction 
    public List<Enseignant> login(@Param("username") String keyword, @Param("password") String keyword2);
}