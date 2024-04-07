package com.example.cinema.module.jpa;

import javax.persistence.*;

@Entity
@Table(name = "billet")
public class Billet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer prix;

    private Integer quantite;

    @ManyToOne
    @JoinColumn(name = "projection_id")
    private Projection projection;

    @ManyToOne
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;

    // Getters and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPrix() {
        return prix;
    }

    public void setPrix(Integer prix) {
        this.prix = prix;
    }

    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

    public Projection getProjection() {
        return projection;
    }

    public void setProjection(Projection projection) {
        this.projection = projection;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }
}
