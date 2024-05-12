import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CinemaComponent } from './cinema/cinema.component';
import { HttpClientModule, provideHttpClient } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { GestionFilmsComponent } from './gestion-films/gestion-films.component';
import { GestionSallesComponent } from './gestion-salles/gestion-salles.component';
import { LoginComponent } from './login/login.component';
import { AcceuilComponent } from './acceuil/acceuil.component';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { AdminNavbarComponent } from './admin-navbar/admin-navbar.component';
import { ClientNavbarComponent } from './client-navbar/client-navbar.component';

@NgModule({
  declarations: [
    AppComponent,
    CinemaComponent,
    GestionFilmsComponent,
    GestionSallesComponent,
    LoginComponent,
    AcceuilComponent,
    AdminDashboardComponent,
    AdminNavbarComponent,
    ClientNavbarComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule , HttpClientModule , FormsModule
  ],
  providers: [
    provideClientHydration()
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
