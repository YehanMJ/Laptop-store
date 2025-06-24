import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import './App.css';
import LaptopList from './Components/LaptopList';
import LaptopDetails from './Components/LaptopDetails';
import AddLaptopForm from './Components/AddLaptopForm';
import { Register, Login } from './Components/AuthForms';
import LaptopManager from './Components/LaptopManager';
import LaptopWithChargerManager from './Components/LaptopWithChargerManager';
import FileUpload from './Components/FileUpload';

function App() {
    return (
        <Router>
            <div className="App">
                <h1>Laptop Management System</h1>
                <Routes>
                    <Route path="/" element={<LaptopManager />} />
                    <Route path="/register" element={<Register />} />
                    <Route path="/login" element={<Login />} />
                    <Route path="/laptops-with-chargers" element={<LaptopWithChargerManager />} />
                    <Route path="/file-upload" element={<FileUpload />} />
                </Routes>
            </div>
        </Router>
    );
}

export default App;