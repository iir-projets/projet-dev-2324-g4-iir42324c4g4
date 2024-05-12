import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CinemaComponent } from './cinema/cinema.component';
import { LoginComponent } from './login/login.component';
import { AcceuilComponent } from './acceuil/acceuil.component';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { GestionFilmsComponent } from './gestion-films/gestion-films.component';
import { GestionSallesComponent } from './gestion-salles/gestion-salles.component';

const routes: Routes = [
  {
    path:"cinema",
    component: CinemaComponent
  },
  {
    path:"login",
    component: LoginComponent
  },
  {
    path:"acceuil",
    component: AcceuilComponent
  },
  { path: 'admin-dashboard', 
  component: AdminDashboardComponent },

  { path: 'gestion-films', 
  component: GestionFilmsComponent },

  { path: 'gestion-salles', 
  component: GestionSallesComponent },
  

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
