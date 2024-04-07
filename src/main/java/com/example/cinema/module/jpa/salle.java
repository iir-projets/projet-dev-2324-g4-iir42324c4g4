package com.example.cinema.module.jpa;
import javax.persistence.*;
@Entity
@Table(name = "salle")
public class salle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer salle_id;

    private Integer nbsiege;

    public salle(Integer id) {
        this.salle_id = id;
    }

    private String typesiege;

    // Getters and setters

    public Integer getId() {
        return salle_id;
    }

    public String getTypesiege() {
        return typesiege;
    }

    public void setTypesiege(String typesiege) {
        this.typesiege = typesiege;
    }

    public Integer getNbsiege() {
        return nbsiege;
    }

    public Integer getSalle_id() {
        return salle_id;
    }

    public void setSalle_id(Integer salle_id) {
        this.salle_id = salle_id;
    }

    @Override
    public String toString() {
        return "salle{" +
                "salle_id=" + salle_id +
                ", nbsiege=" + nbsiege +
                ", typesiege='" + typesiege + '\'' +
                '}';
    }

    public void setNbsiege(Integer nbsiege) {
        this.nbsiege = nbsiege;
    }

    public void setId(Integer id) {
        this.salle_id = id;
    }
}

