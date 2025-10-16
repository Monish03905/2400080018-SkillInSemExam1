import React from "react";
import { BrowserRouter, Routes, Route, Link } from "react-router-dom";

function App() {
  return (
    <BrowserRouter>
      <nav style={{ background: "#eee", padding: 10 }}>
        <Link to="/" style={{ margin: 10 }}>Home</Link>
        <Link to="/courses" style={{ margin: 10 }}>Courses</Link>
        <Link to="/contact" style={{ margin: 10 }}>Contact</Link>
      </nav>

      <Routes>
        <Route path="/" element={<h2>Welcome to Home Page</h2>} />
        <Route path="/courses" element={<h2>Our Courses Page</h2>} />
        <Route path="/contact" element={<h2>Contact Us Page</h2>} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;