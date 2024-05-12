package org.sid.cinema.entities;


import java.util.Collection;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Cinema  {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id ;
	private String name;
	private double longitude,latitude,altitude;
	private int nombreSalles;
	@OneToMany(mappedBy="cinema")
	private Collection<Salle> Salles ;
	@ManyToOne
	private Ville ville;
	
	

}
