import { Component, OnInit } from '@angular/core';
import { CinemaService } from '../services/cinema.service';

@Component({
  selector: 'app-gestion-films',
  templateUrl: './gestion-films.component.html',
  styleUrls: ['./gestion-films.component.css']
})
export class GestionFilmsComponent implements OnInit {
  public villes: any; 
  public cinemas: any;
  public currentVille: any;
  public currentCinema: any;
  public films: any;
  public salles:any;
  public currentProjection:any;
  public nouveauFilm: any = { nom: '', duree: 0 };

  constructor(public cinemaService: CinemaService) { }

  ngOnInit() {
    this.cinemaService.getVilles()
      .subscribe(data => {
        this.villes = data;
      }, err => {
        console.log(err);
      });
  }

  onGetCinemas(v:any) {
    this.currentVille=v;
    this.salles=undefined;
    this.cinemaService.GetCinemas(v)
     .subscribe(data => {
      this.cinemas = data;
     }, err => {
      console.log(err);
  })
}
onGetSalles(c: any) {
  this.currentCinema = c;
  this.cinemaService.getSalles(c)
    .subscribe(data => {
      this.salles = data;
      if (this.salles && this.salles._embedded && this.salles._embedded.salles) {
        this.salles._embedded.salles.forEach((salle: any) => {
          this.cinemaService.getProjections(salle)
            .subscribe(data => {
              salle.projections = data;
            }, err => {
              console.log(err);
            });
        });
      }
    }, err => {
      console.log(err);
    });
}
  
  modifierSalle(salle: any) {
    // Implémentez ici la logique de modification côté frontend
    console.log('Modification de la salle : ', salle);
    // Vous pouvez envoyer une notification de succès ou d'erreur ici
}

}