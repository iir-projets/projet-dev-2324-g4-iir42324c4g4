import { Component, OnInit } from '@angular/core';
import { CinemaService } from '../services/cinema.service';




@Component({
  selector: 'app-cinema',
  templateUrl: './cinema.component.html',
  styleUrl: './cinema.component.css'
})
export class CinemaComponent implements OnInit {

  public villes:any; 
  public cinemas:any;
  public currentVille:any;
  public currentCinema:any;
  public salles:any;
  public currentProjection:any;
  public selectedTickets:any;
 

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
onGetTicketsPlaces(p:any){
  this.currentProjection=p;
  this.cinemaService.getTicketsPlaces(p)
  .subscribe(data =>{
    this.currentProjection.tickets=data;
    this.selectedTickets=[];
  }, err => {
    console.log(err);
  });

}
onSelectTicket(t:any) {
  if(!t.selected){
    t.selected=true;
    this.selectedTickets.push(t);
  }
  else{
    t.selected=false;
    this.selectedTickets.splice(this.selectedTickets.indexOf(t),1);
  }
  console.log(this.selectedTickets)
 

}
getTicketClass(t:any){
  let str="btn ticket ";
  if(t.reserve==true){
    str+="btn-danger";
  }
  else if(t.selected){
    str+="btn-warning"
  }
  else{
    str+="btn-success"
  }
  return str ;
}
onPayTickets(dataform:any){
  let tickets:any=[];
  this.selectedTickets.forEach((t:any)=>{
    tickets.push(t.id);
  });
  dataform.tickets=tickets;
  console.log(dataform);
  this.cinemaService.payerTickets(dataform)
  .subscribe(data =>{
   alert("Tickets Réservés avec succès!")
   this.onGetTicketsPlaces(this.currentProjection);
  }, err => {
    console.log(err);
  });
}            

    };
