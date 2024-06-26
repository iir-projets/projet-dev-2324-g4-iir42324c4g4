package org.sid.cinema.service;


import java.time.LocalTime;
import java.util.Random;
import java.util.stream.Stream;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.List;

import org.sid.cinema.dao.AdminRepository;
import org.sid.cinema.dao.CategorieRepository;
import org.sid.cinema.dao.CinemaRepository;
import org.sid.cinema.dao.FilmRepository;
import org.sid.cinema.dao.PlaceRepository;
import org.sid.cinema.dao.ProjectionRepository;
import org.sid.cinema.dao.SalleRepository;
import org.sid.cinema.dao.SeanceRepository;
import org.sid.cinema.dao.TicketRepository;
import org.sid.cinema.dao.VilleRepository;
import org.sid.cinema.entities.Admin;
import org.sid.cinema.entities.Categorie;
import org.sid.cinema.entities.Cinema;
import org.sid.cinema.entities.Film;
import org.sid.cinema.entities.Place;
import org.sid.cinema.entities.Projection;
import org.sid.cinema.entities.Salle;
import org.sid.cinema.entities.Seance;
import org.sid.cinema.entities.Ticket;
import org.sid.cinema.entities.Ville;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CinemaInitServiceImpl implements ICinemaInitService {
    @Autowired
	private VilleRepository villeRepository;
    @Autowired
  	private CinemaRepository cinemaRepository;
    @Autowired
  	private PlaceRepository placeRepository;
    @Autowired
  	private SeanceRepository seanceRepository;
    @Autowired
  	private FilmRepository filmRepository;
    @Autowired
    private SalleRepository salleRepository;
    @Autowired
  	private ProjectionRepository projectionRepository;
    @Autowired
  	private CategorieRepository categorieRepository;
    @Autowired
  	private TicketRepository ticketRepository;
    @Autowired
  	private AdminRepository adminRepository;
	@Override
	public void initVilles() {
		Stream.of("Casablanca","Marrakech","Rabat","Tanger").forEach(nameville->{
			Ville ville=new Ville();
			ville.setName(nameville);
			villeRepository.save(ville);
		});
		
	}

	@Override
	public void initCinemas() {
		villeRepository.findAll().forEach(v->{
			Stream.of("MEGARAMA","COLISEE","ROYAL","PARADISE")
			.forEach(nameCinema->{
				Cinema cinema=new Cinema();
				cinema.setName(nameCinema);
				cinema.setNombreSalles(3+(int)(Math.random()*7));
				cinema.setVille(v);
				cinemaRepository.save(cinema);
			});
		});
		
	}

	@Override
	public void initSalles() {
	    cinemaRepository.findAll().forEach(cinema -> { 
	        for (int i = 0; i < cinema.getNombreSalles(); i++) {
	            Salle salle = new Salle();
	            salle.setName("salle" + (i + 1));
	            salle.setCinema(cinema);
	            salle.setNombrePlace(15 + (int) (Math.random() * 20));
	            salleRepository.save(salle);
	        }
	    });
	}


	@Override
	public void initPlaces() {
		salleRepository.findAll().forEach(salle->{
			for(int i=0;i<salle.getNombrePlace();i++) {
				Place place=new Place();
				place.setNumero(i+1);
				place.setSalle(salle);
				placeRepository.save(place);
			}
		});
		
	}

	@Override
	public void initSeances() {
		
		Stream.of("12:00","15:00","17:00","19:00","21:00").forEach(s->{
			Seance seance=new Seance();
			try {
	            LocalTime time = LocalTime.parse(s);
	            seance.setHureDebut(time);
	            seanceRepository.save(seance);
		    } catch (DateTimeParseException e) {
		    	e.printStackTrace();
		    	seanceRepository.save(seance);
		    }
		});
		
	}

	@Override
	public void initCategories() {
		Stream.of("Histoire","Action","Fiction","Drama").forEach(cat->{
			Categorie categorie=new Categorie();
			categorie.setName(cat);
			categorieRepository.save(categorie);
			
		});
		
	}

	@Override
	public void initFilms() {
		double[] durees=new double[] {1, 1.5,2.5,3};
		List<Categorie> categories=categorieRepository.findAll();
		Stream.of("Cat Women","Forest","game of thrones","Iron Man", "Seigneur des anneaux")
		.forEach(titreFilm->{
			Film film=new Film();
			film.setTitre(titreFilm);
			film.setDuree(durees[new Random().nextInt(durees.length)]);
			film.setPhoto(titreFilm.replaceAll(" ", "")+".jpg");
			film.setCategorie(categories.get(new Random().nextInt(categories.size())));
			filmRepository.save(film);
		});
		
	}

	@Override
	public void initProjections() {
		double[] prices=new double[] {30,50,60,70,90,100};
		List<Film> films=filmRepository.findAll();
		villeRepository.findAll().forEach(ville->{
			ville.getCinemas().forEach(cinema->{
				cinema.getSalles().forEach(salle->{
					int index=new Random().nextInt(films.size());
					Film film=films.get(index);
						seanceRepository.findAll().forEach(seance->{
							Projection projection=new Projection();
							projection.setDateProjection(new Date());
							projection.setFilm(film);
							projection.setPrix(prices[new Random().nextInt(prices.length)]);
							projection.setSalle(salle);
							projection.setSeance(seance);
							projectionRepository.save(projection);
							
						});
					});
				});
			});
		
	}

	@Override
	public void initTickets() {
		projectionRepository.findAll().forEach(p->{
			p.getSalle().getPlaces().forEach(palce->{
				Ticket ticket=new Ticket();
				ticket.setPlace(palce);
				ticket.setPrix(p.getPrix());
				ticket.setProjection(p);
				ticket.setReserve(false);
				ticketRepository.save(ticket);
			});
		});
		
	}
	 @Override
	    public void initAdmins() {
	        Admin admin = new Admin();
	        admin.setUsername("aziza");
	        admin.setPassword("passwd123");
	        adminRepository.save(admin);
	    }


}
