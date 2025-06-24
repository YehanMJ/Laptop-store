import React, { useState } from 'react';
import { TextField, Button, Typography, Box } from '@mui/material';

const AddLaptopForm = () => {
    const [laptop, setLaptop] = useState({
        brand: '',
        model: '',
        ram: '',
        serial: ''
    });

    const handleChange = (e) => {
        const { name, value } = e.target;
        setLaptop({ ...laptop, [name]: value || '' }); // Ensure value is always a string
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            const response = await fetch('http://localhost:8080/api/v1/laptop', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                    'Authorization': `eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIxIiwic3ViIjoid2VlMTIzNEBnbWFpbC5jb20iLCJpYXQiOjE3NDk3OTg0NTYsImV4cCI6MTc0OTgwMjA1Nn0.8vmfWA0aGikfgu8rzLNQ7-DBJPYsatf2ZYpYdVL_Uu8}`,
                },
                body: JSON.stringify(laptop),
            });

            if (!response.ok) {
                throw new Error(`HTTP error! status: ${response.status}`);
            }

            alert('Laptop added successfully!');
            setLaptop({ brand: '', model: '', ram: '', serial: '' });
        } catch (error) {
            console.error('Error adding laptop:', error);
            alert('Failed to add laptop. Please try again.');
        }
    };

    return (
        <Box
            component="form"
            onSubmit={handleSubmit}
            sx={{
                maxWidth: 400,
                margin: 'auto',
                padding: 2,
                display: 'flex',
                flexDirection: 'column',
                gap: 2,
                boxShadow: 3,
                borderRadius: 2,
                backgroundColor: '#f9f9f9',
            }}
        >
            <Typography variant="h5" component="h2" textAlign="center">
                Add New Laptop
            </Typography>
            <TextField
                label="Brand"
                name="brand"
                value={laptop.brand || ''} // Ensure value is never undefined
                onChange={handleChange}
                required
                fullWidth
            />
            <TextField
                label="Model"
                name="model"
                value={laptop.model || ''} // Ensure value is never undefined
                onChange={handleChange}
                required
                fullWidth
            />
            <TextField
                label="RAM"
                name="ram"
                type="number"
                value={laptop.ram || ''} // Ensure value is never undefined
                onChange={handleChange}
                required
                fullWidth
            />
            <TextField
                label="Serial"
                name="serial"
                value={laptop.serial || ''} // Ensure value is never undefined
                onChange={handleChange}
                required
                multiline
                rows={4}
                fullWidth
            />
            <Button type="submit" variant="contained" color="primary" fullWidth>
                Add Laptop
            </Button>
        </Box>
    );
};

export default AddLaptopForm;