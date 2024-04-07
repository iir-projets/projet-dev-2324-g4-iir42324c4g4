package com.example.cinema.module.jpa;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "projection")
public class projection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Date date;
private double tarif;

    public double getTarif() {
        return tarif;
    }

    public void setTarif(double tarif) {
        this.tarif = tarif;
    }

    public projection(double tarif) {
        this.tarif = tarif;
    }

    private Integer duree;

    public projection(Integer duree) {
        this.duree = duree;
    }

    public projection(Date date) {
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public com.example.cinema.module.jpa.salle getSalle() {
        return salle;
    }

    public void setSalle(com.example.cinema.module.jpa.salle salle) {
        this.salle = salle;
    }

    public com.example.cinema.module.jpa.film getFilm() {
        return film;
    }

    public void setFilm(com.example.cinema.module.jpa.film film) {
        this.film = film;
    }

    public Integer getDuree() {
        return duree;
    }

    public void setDuree(Integer duree) {
        this.duree = duree;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "projection{" +
                "id=" + id +
                ", date=" + date +
                ", duree=" + duree +
                ", film=" + film +
                ", salle=" + salle +
                '}';
    }

    public projection(com.example.cinema.module.jpa.salle salle) {
        this.salle = salle;
    }

    @ManyToOne
    @JoinColumn(name = "film_id")
    private film film;

    @ManyToOne
    @JoinColumn(name = "salle_id")
    private salle salle;

    // Getters and setters
}
