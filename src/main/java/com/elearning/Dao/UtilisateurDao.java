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
import com.elearning.entities.Utilisateur;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UtilisateurDao extends CrudRepository<Utilisateur, Long> {

    @Override
    public void delete(Utilisateur t);

    @Override
    public Iterable<Utilisateur> findAll();

    @Override
    public Optional<Utilisateur> findById(Long id);

    @Override
    public boolean existsById(Long id);

    @Override
    public long count();

    @Override
    public void deleteAll();

    @Override
    public void deleteAll(Iterable<? extends Utilisateur> itrbl);

    @Override
    public void deleteById(Long id);

    @Override
    public boolean equals(Object obj);

    @Override
    public Iterable<Utilisateur> findAllById(Iterable<Long> itrbl);

    @Query(value = "SELECT c FROM Utilisateur c WHERE c.username = :username AND c.password= :password") // ?1 , ?2 selon l'order dans la fonction 
    public List<Utilisateur> login(@Param("username") String keyword, @Param("password") String keyword2);

    @Query(value = "SELECT c FROM Utilisateur c WHERE c.username = :username") // ?1 , ?2 selon l'order dans la fonction 
    public Utilisateur ExistsByUsername(@Param("username") String keyword);
    
        @Query(value = "SELECT c FROM Utilisateur c WHERE c.email = :email") // ?1 , ?2 selon l'order dans la fonction 
    public Utilisateur ExistsByEmail(@Param("email") String keyword);

}
