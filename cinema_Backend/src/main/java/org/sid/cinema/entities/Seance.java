package org.sid.cinema.entities;

import java.time.LocalTime;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Entity
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Seance {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private LocalTime hureDebut;

}
