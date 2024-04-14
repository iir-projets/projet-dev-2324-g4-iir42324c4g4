// Home.js
import React from 'react';
import { Link } from 'react-router-dom';
import './Home.css'; // Assurez-vous que le chemin est correct ici

function Home() {
  return (
    <div className="home">
      <header className="header">
        <h1>CinéRésa</h1>
        <nav className="navbar">
          <Link to="/">Acceuil</Link>
          <Link to="/horaires">Horaires</Link>
          <Link to="/Programme">Programmes</Link>
          <Link to="/tarifs">Tarifs</Link>
          <Link to="/contact">Contact</Link>
        </nav>
      </header>

      <section className="description">
        <p>Réservez vos billets de cinéma dès maintenant</p>
      </section>

      <div className="subtitle">
        Réservez dès maintenant vos places pour les derniers films à
        <br />
        l'affiche sur CinéRésa et vivez une expérience cinématographique inoubliable !
      </div>

      <a href="#" className="learn-more">En savoir plus</a>
    </div>
  );
}

export default Home;
