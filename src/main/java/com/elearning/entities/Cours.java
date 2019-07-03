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

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idcours;

    public Cours() {
    }

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name="idenseignant" , referencedColumnName = "id")
    private Enseignant enseignant ;

    public Long getIdcours() {
        return idcours;
    }

    public void setIdcours(Long idcours) {
        this.idcours = idcours;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Enseignant getEnseignant() {
        return enseignant;
    }

    public void setEnseignant(Enseignant enseignant) {
        this.enseignant = enseignant;
    }
   
    
    
    
    
    
    

}
