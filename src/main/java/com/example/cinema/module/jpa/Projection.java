package com.example.cinema.module.jpa;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "projection")
public class Projection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Date date;

    private Integer duree;

    private double tarif;

    @ManyToOne
    @JoinColumn(name = "film_id")
    private Film film;

    @ManyToOne
    @JoinColumn(name = "salle_id")
    private Salle salle;

    // Getters and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getDuree() {
        return duree;
    }

    public void setDuree(Integer duree) {
        this.duree = duree;
    }

    public double getTarif() {
        return tarif;
    }

    public void setTarif(double tarif) {
        this.tarif = tarif;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Salle getSalle() {
        return salle;
    }

    public void setSalle(Salle salle) {
        this.salle = salle;
    }

    @Override
    public String toString() {
        return "Projection{" +
                "id=" + id +
                ", date=" + date +
                ", duree=" + duree +
                ", tarif=" + tarif +
                ", film=" + film +
                ", salle=" + salle +
                '}';
    }
}
