// Utility for API calls to backend
const API_BASE = "http://localhost:8080/api/v1";

export const registerUser = async (user) => {
  const res = await fetch(`${API_BASE}/user/register`, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(user),
  });
  return res.json();
};

export const loginUser = async (user) => {
  const res = await fetch(`${API_BASE}/user/login`, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(user),
  });
  return res.json();
};

export const getLaptops = async () => {
  const res = await fetch(`${API_BASE}/laptop`);
  return res.json();
};

export const getLaptopById = async (id) => {
  const res = await fetch(`${API_BASE}/laptop/${id}`);
  return res.json();
};

export const addLaptop = async (laptop, token) => {
  const res = await fetch(`${API_BASE}/laptop`, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
      Authorization: token,
    },
    body: JSON.stringify(laptop),
  });
  return res.json();
};

export const updateLaptop = async (id, laptop, token) => {
  const res = await fetch(`${API_BASE}/laptop/${id}`, {
    method: "PUT",
    headers: {
      "Content-Type": "application/json",
      Authorization: token,
    },
    body: JSON.stringify(laptop),
  });
  return res.json();
};

export const deleteLaptop = async (id, token) => {
  const res = await fetch(`${API_BASE}/laptop/${id}`, {
    method: "DELETE",
    headers: { Authorization: token },
  });
  return res.json();
};

export const getLaptopsWithChargers = async () => {
  const res = await fetch(`${API_BASE}/laptop/chargers`);
  return res.json();
};

export const addLaptopWithChargers = async (data, token) => {
  const res = await fetch(`${API_BASE}/laptop/save_with_chargers`, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
      Authorization: token,
    },
    body: JSON.stringify(data),
  });
  return res.json();
};

export const uploadFile = async (file) => {
  const formData = new FormData();
  formData.append("file", file);
  const res = await fetch(`${API_BASE}/file`, {
    method: "POST",
    body: formData,
  });
  return res;
};

export const downloadFile = async (filename) => {
  const res = await fetch(`${API_BASE}/file/files/${filename}`);
  return res;
};
