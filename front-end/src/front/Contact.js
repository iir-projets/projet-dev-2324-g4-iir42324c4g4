// Contact.js
import React from 'react';
import { Link } from 'react-router-dom';
import './Contact.css'; 
function Contact() {
  return (
    <div className="home">
    <header className="header">
      <h1>CinéRésa</h1>
      <nav className="navbar">
        <Link to="/">Acceuil</Link>
        <Link to="/horaires">Horaires</Link>
        <Link to="/programmes">Programmes</Link>
        <Link to="/tarifs">Tarifs</Link>
        <Link to="/contact">Contact</Link>
      </nav>
    </header>
  </div>
  );
}

export default Contact;
