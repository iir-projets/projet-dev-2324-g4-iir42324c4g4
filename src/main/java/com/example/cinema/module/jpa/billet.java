package com.example.cinema.module.jpa;

import javax.persistence.*;

@Entity
@Table(name = "billet")
public class billet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer prix;

    private Integer quantite;

    @ManyToOne
    @JoinColumn(name = "id")
    private projection projection;
    @ManyToOne
    @JoinColumn(name = "idr")
    private reservation reservation;

    // Getters and setters
}
