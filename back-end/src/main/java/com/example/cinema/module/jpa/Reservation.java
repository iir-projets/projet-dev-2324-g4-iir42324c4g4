package com.example.cinema.module.jpa;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idr;

    private Date date;

    private Integer duree;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    // Getters and setters
    public Integer getIdr() {
        return idr;
    }

    public void setIdr(Integer idr) {
        this.idr = idr;
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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "idr=" + idr +
                ", date=" + date +
                ", duree=" + duree +
                ", client=" + client +
                '}';
    }
}
