import React, { useEffect, useState } from 'react';
import { Box } from '@mui/material';

const LaptopList = () => {
    const [laptops, setLaptops] = useState([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);

    useEffect(() => {
        const fetchLaptops = async () => {
            try {
                const response = await fetch('http://localhost:8080/laptop');
                if (!response.ok) {
                    throw new Error(`HTTP error! status: ${response.status}`);
                }
                const data = await response.json();
                setLaptops(data);
            } catch (err) {
                setError(err.message);
            } finally {
                setLoading(false);
            }
        };

        fetchLaptops();
    }, []);

    if (loading) {
        return <div>Loading...</div>;
    }

    if (error) {
        return <div>Error: {error}</div>;
    }

    return (
        <Box>
            <h1>Laptop List</h1>
            <ul>
                {laptops.map(laptop => (
                    <li key={laptop.id}>
                        {laptop.brand} {laptop.model} - ${laptop.price}
                    </li>
                ))}
            </ul>
        </Box>
    );
};

export default LaptopList;