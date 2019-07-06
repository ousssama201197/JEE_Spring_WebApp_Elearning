/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elearning.entities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Amina
 */
@Entity

public class Cours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Cours() {
    }

    @Column(name = "name")
    private String name;

    @Column(name = "discription")
    private String discription;
    @ManyToOne
    @JoinColumn(name="idenseignant" , referencedColumnName = "id")
    private Utilisateur enseignant ;

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Utilisateur getEnseignant() {
        return enseignant;
    }

    public void setEnseignant(Utilisateur enseignant) {
        this.enseignant = enseignant;
    }



   
    
    
    
    
    
    

}
