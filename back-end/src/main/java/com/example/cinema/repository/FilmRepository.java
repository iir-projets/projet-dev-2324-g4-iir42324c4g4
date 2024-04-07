package com.example.cinema.repository;

import com.example.cinema.module.jpa.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film, Long> {
    // Add custom query methods if needed
}
