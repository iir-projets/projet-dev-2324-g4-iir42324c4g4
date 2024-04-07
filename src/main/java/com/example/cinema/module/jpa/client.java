package com.example.cinema.module.jpa;

import javax.persistence.*;

@Entity
@Table(name = "client")
public class client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer client_id;

    private String email;

    private String password;

    public Integer getClient_id() {
        return client_id;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "client{" +
                "client_id=" + client_id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setClient_id(Integer client_id) {
        this.client_id = client_id;
    }
// Getters and setters
}
