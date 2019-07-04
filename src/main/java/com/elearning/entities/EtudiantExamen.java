package com.elearning.entities;


import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

@Entity
public class EtudiantExamen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
        @ManyToOne
    @JoinColumn(name = "idetudiant", referencedColumnName = "id")
    private Utilisateur etudiant;

    @ManyToOne
    @JoinColumn(name = "idExamen", referencedColumnName = "id")
    private Examen examen;
    
    private Long Note;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateExamen;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Long getNote() {
        return Note;
    }

    public void setNote(Long Note) {
        this.Note = Note;
    }

    public Date getDateExamen() {
        return dateExamen;
    }

    public void setDateExamen(Date dateExamen) {
        this.dateExamen = dateExamen;
    }

    public Utilisateur getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Utilisateur etudiant) {
        this.etudiant = etudiant;
    }

    

    public Examen getExamen() {
        return examen;
    }

    public void setExamen(Examen examen) {
        this.examen = examen;
    }

    
}
