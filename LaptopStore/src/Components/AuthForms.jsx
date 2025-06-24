import React, { useState } from "react";
import { registerUser, loginUser } from "../app/api";

export function Register({ onRegister }) {
  const [form, setForm] = useState({ username: "", password: "" });
  const [msg, setMsg] = useState("");

  const handleChange = (e) => {
    setForm({ ...form, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    const res = await registerUser(form);
    if (res && res.id) {
      setMsg("Registration successful!");
      onRegister && onRegister();
    } else {
      setMsg("Registration failed");
    }
  };

  return (
    <form onSubmit={handleSubmit}>
      <h2>Register</h2>
      <input name="username" value={form.username} onChange={handleChange} placeholder="Username" required />
      <input name="password" type="password" value={form.password} onChange={handleChange} placeholder="Password" required />
      <button type="submit">Register</button>
      <div>{msg}</div>
    </form>
  );
}

export function Login({ onLogin }) {
  const [form, setForm] = useState({ username: "", password: "" });
  const [msg, setMsg] = useState("");

  const handleChange = (e) => {
    setForm({ ...form, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    const res = await loginUser(form);
    if (res && res.token) {
      setMsg("Login successful!");
      localStorage.setItem("token", res.token);
      onLogin && onLogin(res.token);
    } else {
      setMsg("Login failed");
    }
  };

  return (
    <form onSubmit={handleSubmit}>
      <h2>Login</h2>
      <input name="username" value={form.username} onChange={handleChange} placeholder="Username" required />
      <input name="password" type="password" value={form.password} onChange={handleChange} placeholder="Password" required />
      <button type="submit">Login</button>
      <div>{msg}</div>
    </form>
  );
}
