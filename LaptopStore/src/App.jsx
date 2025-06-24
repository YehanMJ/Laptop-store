import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import './App.css';
import LaptopList from './Components/LaptopList';
import LaptopDetails from './Components/LaptopDetails';
import AddLaptopForm from './Components/AddLaptopForm';

function App() {
    return (
        <Router>
            <div className="App">
                <h1>Laptop Management System</h1>
                <Routes>
                    {/* <Route path="/" element={<LaptopList />} /> */}
                    {/* <Route path="/laptop/:id" element={<LaptopDetails />} /> */}
                    <Route path="/" element={<AddLaptopForm />} />
                </Routes>
            </div>
        </Router>
    );
}

export default App;