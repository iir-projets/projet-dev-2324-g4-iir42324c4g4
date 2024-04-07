package com.example.cinema.module.jpa;

import javax.persistence.*;

@Entity
@Table(name = "film")
public class film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer film_id;

    private String nom;

    private byte[] image;
    public Integer getId() {
        return film_id;
    }

    public film() {
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    private String description;

    public film(byte[] image) {
        this.image = image;
    }

    public void setId(Integer id) {
        this.film_id = id;
    }

    @Override
    public String toString() {
        return "film{" + "id=" + film_id + ", nom='" + nom + '\'' + ", description='" + description + '\'' + '}';
    }
// Getters and setters
}
