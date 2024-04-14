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
          <Link to="/Programme">Programmes</Link>
          <Link to="/tarifs">Tarifs</Link>
          <Link to="/contact">Contact</Link>
        </nav>
      </header>
      <div className="contact-form">
        <h2>Contact Us</h2>
        <form>
          <label htmlFor="name">Name:</label>
          <input type="text" id="name" name="name" required />
          <label htmlFor="email">Email:</label>
          <input type="email" id="email" name="email" required />
          <label htmlFor="message">Message:</label>
          <textarea id="message" name="message" required></textarea>
          <button type="submit">Submit</button>
        </form>
      </div>
    </div>
  );
}

export default Contact;
