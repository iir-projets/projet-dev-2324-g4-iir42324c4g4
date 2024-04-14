// App.js
import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Home from './front/Home'; // Assurez-vous que le chemin est correct ici
import Contact from './front/Contact'; // Assurez-vous que le chemin est correct ici
import Programme from './front/Programme';

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/contact" element={<Contact />} />
        <Route path="/Programme" element={<Programme />} />
      </Routes>
    </Router>
  );
}

export default App;
