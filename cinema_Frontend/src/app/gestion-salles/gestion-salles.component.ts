import { Component, OnInit } from '@angular/core';
import { CinemaService } from '../services/cinema.service';
import { error } from 'console';


@Component({
  selector: 'app-gestion-salles',
  templateUrl: './gestion-salles.component.html',
  styleUrls: ['./gestion-salles.component.css']
})
export class GestionSallesComponent implements OnInit {
  public villes:any; 
  public cinemas:any;
  public currentVille:any;
  public currentCinema:any;
  public salles:any;
  
  public nouvelleSalle: any = { nom: '', nombrePlaces: 0 };

 

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
        this.salles._embedded.salles = this.salles._embedded.salles.map((s: any) => ({
          ...s,
          nouveauNom: s.name,
          nouveauNombrePlaces: s.nombrePlace,
          modificationActive: false
        }));
      } else {
        console.error('La réponse de getSalles n\'est pas au format attendu :', data);
       
      }
    },
    err => {
      console.log(err);
    });
}



modifierSalle(s: any) {
  s.modificationActive = true;
  s.nouveauNom = s.name;
  s.nouveauNombrePlaces = s.nombrePlace;
}

validerModification(s: any) {
  s.name = s.nouveauNom;
  s.nombrePlace = s.nouveauNombrePlaces;
  s.modificationActive = false;

  this.cinemaService.updateSalle(s)
    .subscribe(updatedSalle => {
      // Afficher un message d'alerte avec les nouvelles informations
      alert('Salle modifiée avec succès : ' + s.name + '. Nouveau nombre de places : ' + s.nombrePlace);
    }, err => {
      console.log(err);
    });
}

// gestionsallescomponent.ts
supprimerSalle(salle: any) {
  // Supprimer la salle de la liste des salles affichées
  this.salles._embedded.salles = this.salles._embedded.salles.filter((s: any) => s.id !== salle.id);
  // Afficher un message d'alerte
  alert('Salle supprimée avec succès : ' + salle.name);
}
ajouterSalle() {
  // Copier les valeurs du formulaire vers la nouvelle salle
  const nouvelleSalle: any = {
    name: this.nouvelleSalle.nom,
    nombrePlace: this.nouvelleSalle.nombrePlaces
  };

  // Filtrer les salles existantes et ajouter la nouvelle salle
  if (this.salles && this.salles._embedded && this.salles._embedded.salles) {
    this.salles._embedded.salles.push(nouvelleSalle);
  } else {
    console.error('La structure de données des salles est incorrecte.');
  }

  // Réinitialiser les champs du formulaire
  this.nouvelleSalle = { name: '', nombrePlace: 0 }; // Réinitialisation de nouvelleSalle
}






}
