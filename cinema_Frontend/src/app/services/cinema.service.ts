import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CinemaService {

  public host: string = "http://localhost:8080";

  constructor(private http: HttpClient) { }

  public getVilles() {
    return this.http.get(this.host + "/villes");
  }

  GetCinemas(v: any) {
    return this.http.get(v._links.cinemas.href);
  }

  getSalles(c: any) {
    return this.http.get(c._links.Salles.href);
  }
  getFilmsForSalle(salle: any): Observable<any> {
    return this.http.get(salle._links.films.href);
  }

  getProjections(salle: any) {
    let url = salle._links.projections.href.replace("{?projection}", "");
    return this.http.get(url + "?projection=p1");
  }

  getTicketsPlaces(p: any) {
    let url = p._links.tickets.href.replace("{?projection}", "");
    return this.http.get(url + "?projection=ticketProj");
  }

  payerTickets(dataform:any){
    return this.http.post(this.host+"/payerTickets",dataform)
  }
  login(username: string, password: string) {
    const headers = { 'Content-Type': 'application/json' };
    const body = { username, password };
  
    return this.http.post<any>(this.host + '/login', body, { headers, responseType: 'text' as 'json' });
  }
  
  

  // Méthode pour mettre à jour une salle
  updateSalle(salle: any): Observable<any> {
    const url = `${this.host}/salles/${salle.id}`;
    const body = {
      name: salle.nouveauNom,
      nombrePlace: salle.nouveauNombrePlaces
    };
    return this.http.put(url, body);
  }

// Dans le service CinemaService
// Ajoutez une méthode pour envoyer les données de la nouvelle salle au backend
ajouterSalle(cinema: any, nouvelleSalle: any): Observable<any> {
  // Construisez l'URL pour ajouter la salle au cinéma spécifié
  const url = `${this.host}/cinemas/${cinema.id}/salles`;

  // Construisez le corps de la requête avec les données de la nouvelle salle
  const body = {
    name: nouvelleSalle.nom,
    nombrePlace: nouvelleSalle.nombrePlaces
  };

  // Effectuez une requête HTTP POST pour ajouter la salle
  return this.http.post(url, body);
}
getFilms(cinema: any): Observable<any> {
  return this.http.get(cinema._links.films.href);
}

updateFilm(film: any): Observable<any> {
  // Implémentez la logique de mise à jour du film côté serveur ici
  // Remplacez le retour par un appel HTTP PUT vers votre API avec le film modifié
  return this.http.put(this.host + '/films/' + film.id, film);
}


  
  


  
}
