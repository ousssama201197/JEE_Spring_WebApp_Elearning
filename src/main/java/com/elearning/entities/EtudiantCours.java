package com.elearning.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

@Entity
public class EtudiantCours {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     Long id;
    
    @ManyToOne
    @JoinColumn(name = "idetudiant", referencedColumnName = "id")
    private Utilisateur etudiant;

    @ManyToOne
    @JoinColumn(name = "idCours", referencedColumnName = "id")
    private Cours cours;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date Date_inscription;
    
    
    private Boolean valider;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Utilisateur getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Utilisateur etudiant) {
        this.etudiant = etudiant;
    }

    public Cours getCours() {
        return cours;
    }

    public void setCours(Cours cours) {
        this.cours = cours;
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
