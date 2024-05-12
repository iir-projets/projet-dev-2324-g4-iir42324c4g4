import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { CinemaService } from '../services/cinema.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  username: string = '';
  password: string = '';

  constructor(private router: Router, private cinemaService: CinemaService) { } 

  login() {
    // Vérifier si les champs username et password sont vides
    if (!this.username || !this.password) {
      console.error('Veuillez remplir tous les champs.');
      return;
    }
  
    // Appeler le service pour la connexion
    this.cinemaService.login(this.username, this.password).subscribe(
      (response: any) => {
        if (response === 'Authentication successful') { // Ce code doit être ajusté
          console.log('Authentification réussie');
          this.router.navigate(['/admin-dashboard']);
        } else {
          console.error('Réponse non valide:', response);
        }
      }, 
      (error: any) => {
        console.error('Erreur d\'authentification :', error);
      }
    );
    
  }
  
  
}
