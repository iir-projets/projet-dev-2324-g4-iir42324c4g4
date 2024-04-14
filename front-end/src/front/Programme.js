import React from 'react';
import { Link } from 'react-router-dom';
import './Programme.css'; 
function Programme() {
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
  </div>
  );
}

export default Programme;
