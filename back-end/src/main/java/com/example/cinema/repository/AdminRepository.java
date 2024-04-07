package com.example.cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.cinema.module.jpa.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}
