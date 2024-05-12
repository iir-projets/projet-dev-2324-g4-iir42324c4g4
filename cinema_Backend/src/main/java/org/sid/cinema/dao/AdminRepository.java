package org.sid.cinema.dao;

import org.sid.cinema.entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;


@RepositoryRestResource
@CrossOrigin("*")
public interface AdminRepository extends JpaRepository<Admin, Long> {
   
}


