package com.elearning.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class EtudiantCours {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_etudiant;
	private Long id_cours;
	private Date Date_inscription;
	private Boolean valider;

    public Long getId_etudiant() {
        return id_etudiant;
    }

    public void setId_etudiant(Long id_etudiant) {
        this.id_etudiant = id_etudiant;
    }

    public Long getId_cours() {
        return id_cours;
    }

    public void setId_cours(Long id_cours) {
        this.id_cours = id_cours;
    }

    public Date getDate_inscription() {
        return Date_inscription;
    }

    public void setDate_inscription(Date Date_inscription) {
        this.Date_inscription = Date_inscription;
    }

    public Boolean getValider() {
        return valider;
    }

    public void setValider(Boolean valider) {
        this.valider = valider;
    }

        
        
}