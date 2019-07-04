package com.elearning.entities;


import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class EtudiantExamen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Long Note;
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

}
