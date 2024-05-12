package org.sid.cinema.web;
import java.io.IOException;
import java.io.File;
import org.springframework.http.HttpHeaders;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.io.ByteArrayOutputStream;

import org.sid.cinema.dao.AdminRepository;
import org.sid.cinema.dao.FilmRepository;
import org.sid.cinema.dao.PlaceRepository;
import org.sid.cinema.dao.SalleRepository;
import org.sid.cinema.dao.TicketRepository;
import org.sid.cinema.entities.Admin;
import org.sid.cinema.entities.Film;
import org.sid.cinema.entities.Place;
import org.sid.cinema.entities.Salle;
import org.sid.cinema.entities.Ticket;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import jakarta.transaction.Transactional;
import lombok.Data;


@RestController
@CrossOrigin("*")
public class CinemaRestController {
    @Autowired 
    private FilmRepository filmRepository;
    
    @Autowired 
    private TicketRepository ticketRepository;
    
    @Autowired
    private SalleRepository salleRepository;
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private PlaceRepository placeRepository;

    @GetMapping(path="/imageFilm/{id}" ,produces=MediaType.IMAGE_JPEG_VALUE)
    public byte[] image(@PathVariable (name="id")Long id) throws Exception {
        Film f=filmRepository.findById(id).get();
        String photoName=f.getPhoto();
        File file=new File(System.getProperty("user.home")+"/cinéma/images/"+photoName);
        Path path=Paths.get(file.toURI());
        return Files.readAllBytes(path);
    }

    @PostMapping("/payerTickets")
    @Transactional
    public List<Ticket> payerTicket(@RequestBody TicketForm ticketForm) {
        List<Ticket> listTickets=new ArrayList<>();
        ticketForm.getTickets().forEach(idTicket->{
            Ticket ticket=ticketRepository.findById(idTicket).get();
            ticket.setNomClient(ticketForm.getNomClient());
            ticket.setReserve(true);
            ticketRepository.save(ticket);
            listTickets.add(ticket);
        }); 
        return listTickets;
        
    }
  
    @GetMapping("/films")
    public List<Film> getAllFilms() {
        return filmRepository.findAll();
    }

    @PostMapping("/films")
    public Film addFilm(@RequestBody Film film) {
        return filmRepository.save(film);
    }

    @PutMapping("/films/{id}")
    public Film updateFilm(@PathVariable Long id, @RequestBody Film filmDetails) {
        Film film = filmRepository.findById(id)
                                .orElseThrow(() -> new ResourceNotFoundException("Film not found with id " + id));
        film.setTitre(filmDetails.getTitre());
        film.setDescription(filmDetails.getDescription());
        film.setRealisateur(filmDetails.getRealisateur());
        film.setDateSortie(filmDetails.getDateSortie());
        film.setDuree(filmDetails.getDuree());
        film.setPhoto(filmDetails.getPhoto());
        film.setCategorie(filmDetails.getCategorie());
        
        return filmRepository.save(film);
    }

    @DeleteMapping("/films/{id}")
    public ResponseEntity<?> deleteFilm(@PathVariable Long id) {
        Film film = filmRepository.findById(id)
                                .orElseThrow(() -> new ResourceNotFoundException("Film not found with id " + id));
        filmRepository.delete(film);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/salles")
    public List<Salle> getAllSalles() {
        return salleRepository.findAll();
    }

    @PostMapping("/salles")
    public Salle addSalle(@RequestBody Salle salle) {
        return salleRepository.save(salle);
    }



    @DeleteMapping("/salles/{id}")
    public ResponseEntity<?> deleteSalle(@PathVariable Long id) {
        Salle salle = salleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Salle not found with id " + id));

        List<Place> places = placeRepository.findBySalleId(id);
        for (Place place : places) {
            ticketRepository.deleteByPlace(place);
        }

        placeRepository.deleteBySalle(salle);

        salleRepository.delete(salle);

        return ResponseEntity.ok().build();
    }


    @PostMapping(value = "/login", produces = MediaType.TEXT_PLAIN_VALUE)
    public String login(@RequestBody Map<String, String> credentials) {
        String username = credentials.get("username");
        String password = credentials.get("password");
        if ("aziza".equals(username) && "passwd123".equals(password)) {
            return "Authentication successful";
        } else {
            return "Authentication failed";
        }
    }
   
}
    

@Data
class TicketForm {
    private String nomClient;
    private int codePayement;
    private List<Long> tickets=new ArrayList<>();
}
