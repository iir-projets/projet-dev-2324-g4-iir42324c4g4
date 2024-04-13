import React from 'react';
import './Home.css'; // Importer le fichier CSS

function Home() {
  return (
    <div className="home">
      <header className="header">
        <h1>CinéRésa</h1>
        <nav className="navbar">
          <a href="#">Offre Spéciale</a>
          <a href="#">Programme</a>
          <a href="#">À Propos</a>
        </nav>
      </header>

      <section className="description">
        <p>Réservez vos billets de cinéma dès maintenant</p>
      </section>

      <div className="subtitle">
        Réservez dès maintenant vos places pour les derniers films à 
        <br></br>
         l'affiche sur CinéRésa et vivez une expérience cinématographique inoubliable !
      </div>

      <a href="#" className="learn-more">En savoir plus</a>
    </div>
  );


}

export default Home;
