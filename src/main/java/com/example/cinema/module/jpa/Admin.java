package com.example.cinema.module.jpa;

import javax.persistence.*;

@Entity
@Table(name = "admin")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "admin_id")
    private Long adminId;

    @Column(name = "nom", nullable = false)
    private String nom;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "film_id", nullable = true)
    private Long filmId;

    @Column(name = "salle_id", nullable = true)
    private Long salleId;

    // Getters and setters
    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getFilmId() {
        return filmId;
    }

    public void setFilmId(Long filmId) {
        this.filmId = filmId;
    }

    public Long getSalleId() {
        return salleId;
    }

    public void setSalleId(Long salleId) {
        this.salleId = salleId;
    }

    // toString method
    @Override
    public String toString() {
        return "Admin{" +
                "adminId=" + adminId +
                ", nom='" + nom + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", filmId=" + filmId +
                ", salleId=" + salleId +
                '}';
    }
}
