package com.example.cinema.module.jpa;

import javax.persistence.*;

@Entity
@Table(name = "salle")
public class Salle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer salle_id;

    private Integer nbsiege;

    private String typesiege;

    // Getters and setters
    public Integer getSalle_id() {
        return salle_id;
    }

    public void setSalle_id(Integer salle_id) {
        this.salle_id = salle_id;
    }

    public Integer getNbsiege() {
        return nbsiege;
    }

    public void setNbsiege(Integer nbsiege) {
        this.nbsiege = nbsiege;
    }

    public String getTypesiege() {
        return typesiege;
    }

    public void setTypesiege(String typesiege) {
        this.typesiege = typesiege;
    }

    @Override
    public String toString() {
        return "Salle{" +
                "salle_id=" + salle_id +
                ", nbsiege=" + nbsiege +
                ", typesiege='" + typesiege + '\'' +
                '}';
    }
}
