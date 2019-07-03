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
import com.elearning.entities.Etudiant;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface EtudiantDao extends CrudRepository<Etudiant, Long> {

    @Override
    public void delete(Etudiant t);

    @Override
    public Iterable<Etudiant> findAll();

    @Override
    public Optional<Etudiant> findById(Long id);

    @Override
    public boolean existsById(Long id);

    @Override
    public long count();

    @Override
    public void deleteAll();

    @Override
    public void deleteAll(Iterable<? extends Etudiant> itrbl);

    @Override
    public void deleteById(Long id);

    @Override
    public boolean equals(Object obj);

    @Override
    public Iterable<Etudiant> findAllById(Iterable<Long> itrbl);

    @Query(value = "SELECT c FROM Etudiant c WHERE c.username = :username AND c.password= :password") // ?1 , ?2 selon l'order dans la fonction 
    public List<Etudiant> login(@Param("username") String keyword, @Param("password") String keyword2);

}
