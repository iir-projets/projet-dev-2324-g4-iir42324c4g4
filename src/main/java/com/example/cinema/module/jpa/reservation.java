package com.example.cinema.module.jpa;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "reservation")
public class reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idr;

    public Integer getIdr() {
        return idr;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "reservation{" +
                "idr=" + idr +
                ", date=" + date +
                ", duree=" + duree +
                ", client=" + client +
                '}';
    }

    public com.example.cinema.module.jpa.client getClient() {
        return client;
    }

    public void setClient(com.example.cinema.module.jpa.client client) {
        this.client = client;
    }

    public Integer getDuree() {
        return duree;
    }

    public void setDuree(Integer duree) {
        this.duree = duree;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setIdr(Integer idr) {
        this.idr = idr;
    }

    private Date date;

    private Integer duree;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private client client;


}
