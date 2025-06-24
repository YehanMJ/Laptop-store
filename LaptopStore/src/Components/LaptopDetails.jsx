import React, { useEffect, useState } from 'react';

const LaptopDetails = ({ match }) => {
    const [laptop, setLaptop] = useState(null);
    const laptopId = match.params.id;

    useEffect(() => {
        const fetchLaptopDetails = async () => {
            try {
                const response = await fetch(`http://localhost:8080/laptop/${laptopId}`);
                if (!response.ok) {
                    throw new Error(`HTTP error! status: ${response.status}`);
                }
                const data = await response.json();
                setLaptop(data);
            } catch (error) {
                console.error("Error fetching laptop details:", error);
            }
        };

        fetchLaptopDetails();
    }, [laptopId]);

    if (!laptop) {
        return <div>Loading...</div>;
    }

    return (
        <div>
            <h2>{laptop.name}</h2>
            <p><strong>Brand:</strong> {laptop.brand}</p>
            <p><strong>Price:</strong> ${laptop.price}</p>
            <p><strong>Description:</strong> {laptop.description}</p>
            <img src={laptop.imageUrl} alt={laptop.name} />
        </div>
    );
};

export default LaptopDetails;