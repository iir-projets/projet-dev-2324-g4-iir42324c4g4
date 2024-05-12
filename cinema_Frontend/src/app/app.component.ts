import { Component } from '@angular/core';
import { Router, NavigationEnd } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  constructor(private router: Router) {}
  title = 'Cinema-Front-End';
  isHomePage(): boolean {
    return this.router.url === '/acceuil';
  }
}