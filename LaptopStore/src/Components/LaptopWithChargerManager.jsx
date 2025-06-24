import React, { useEffect, useState } from "react";
import { getLaptopsWithChargers, addLaptopWithChargers } from "../app/api";

export default function LaptopWithChargerManager() {
  const [list, setList] = useState([]);
  const [form, setForm] = useState({ brand: "", model: "", price: "", chargers: "" });
  const token = localStorage.getItem("token");

  useEffect(() => {
    fetchList();
  }, []);

  const fetchList = async () => {
    setList(await getLaptopsWithChargers());
  };

  const handleChange = (e) => {
    setForm({ ...form, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    // chargers: comma-separated string to array
    const data = { ...form, chargers: form.chargers.split(",").map((c) => c.trim()) };
    await addLaptopWithChargers(data, token);
    setForm({ brand: "", model: "", price: "", chargers: "" });
    fetchList();
  };

  return (
    <div>
      <h2>Laptops with Chargers</h2>
      <form onSubmit={handleSubmit}>
        <input name="brand" value={form.brand} onChange={handleChange} placeholder="Brand" required />
        <input name="model" value={form.model} onChange={handleChange} placeholder="Model" required />
        <input name="price" value={form.price} onChange={handleChange} placeholder="Price" required />
        <input name="chargers" value={form.chargers} onChange={handleChange} placeholder="Chargers (comma separated)" required />
        <button type="submit">Add Laptop with Chargers</button>
      </form>
      <ul>
        {list.map((item) => (
          <li key={item.id}>
            {item.brand} {item.model} - ${item.price} | Chargers: {item.chargers && item.chargers.join(", ")}
          </li>
        ))}
      </ul>
    </div>
  );
}
