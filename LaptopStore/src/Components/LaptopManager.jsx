import React, { useEffect, useState } from "react";
import AddLaptopForm from "./AddLaptopForm";
import {
  getLaptops,
  addLaptop,
  updateLaptop,
  deleteLaptop,
  getLaptopById,
} from "../app/api";
import {
  Table,
  TableBody,
  TableCell,
  TableContainer,
  TableHead,
  TableRow,
  Paper,
  Button as MuiButton,
} from "@mui/material";

export default function LaptopManager() {
  const [laptops, setLaptops] = useState([]);
  const [editing, setEditing] = useState(null);
  const [editForm, setEditForm] = useState({ brand: "", model: "", price: "" });
  const token = localStorage.getItem("token");

  useEffect(() => {
    fetchLaptops();
  }, []);

  const fetchLaptops = async () => {
    setLaptops(await getLaptops());
  };

  const handleEditChange = (e) => {
    setEditForm({ ...editForm, [e.target.name]: e.target.value });
  };

  const handleEdit = async (id) => {
    const data = await getLaptopById(id);
    setEditForm(data);
    setEditing(id);
  };

  const handleEditSubmit = async (e) => {
    e.preventDefault();
    await updateLaptop(editing, editForm, token);
    setEditing(null);
    setEditForm({ brand: "", model: "", price: "" });
    fetchLaptops();
  };

  const handleDelete = async (id) => {
    await deleteLaptop(id, token);
    fetchLaptops();
  };

  return (
    <div style={{ display: 'flex', alignItems: 'flex-start', gap: '32px', width: '100%' }}>
      <div style={{ flex: '0 0 400px', minWidth: 350, alignSelf: 'flex-start', marginTop: 32 }}>
        <h2>Laptop Manager</h2>
        <AddLaptopForm onAdd={fetchLaptops} />
      </div>
      <div style={{ flex: 1, width: '100%', display: 'flex', flexDirection: 'column', alignItems: 'flex-start', marginTop: 0 }}>
        <div style={{ width: '100%' }}>
          <TableContainer component={Paper} sx={{ mt: 0, width: '100%' }}>
            <Table sx={{ minWidth: 500, width: '100%' }}>
              <TableHead>
                <TableRow>
                  <TableCell>Brand</TableCell>
                  <TableCell>Model</TableCell>
                  <TableCell>Price</TableCell>
                  <TableCell>Actions</TableCell>
                </TableRow>
              </TableHead>
              <TableBody>
                {laptops.map((lap) => (
                  <TableRow key={lap.id}>
                    {editing === lap.id ? (
                      <>
                        <TableCell>
                          <input
                            name="brand"
                            value={editForm.brand}
                            onChange={handleEditChange}
                          />
                        </TableCell>
                        <TableCell>
                          <input
                            name="model"
                            value={editForm.model}
                            onChange={handleEditChange}
                          />
                        </TableCell>
                        <TableCell>
                          <input
                            name="price"
                            value={editForm.price}
                            onChange={handleEditChange}
                          />
                        </TableCell>
                        <TableCell>
                          <MuiButton
                            variant="contained"
                            color="primary"
                            size="small"
                            onClick={handleEditSubmit}
                            sx={{ mr: 1 }}
                          >
                            Save
                          </MuiButton>
                          <MuiButton
                            variant="outlined"
                            color="secondary"
                            size="small"
                            onClick={() => setEditing(null)}
                          >
                            Cancel
                          </MuiButton>
                        </TableCell>
                      </>
                    ) : (
                      <>
                        <TableCell>{lap.brand}</TableCell>
                        <TableCell>{lap.model}</TableCell>
                        <TableCell>{lap.price}</TableCell>
                        <TableCell>
                          <MuiButton
                            variant="contained"
                            color="primary"
                            size="small"
                            onClick={() => handleEdit(lap.id)}
                            sx={{ mr: 1 }}
                          >
                            Edit
                          </MuiButton>
                          <MuiButton
                            variant="outlined"
                            color="error"
                            size="small"
                            onClick={() => handleDelete(lap.id)}
                          >
                            Delete
                          </MuiButton>
                        </TableCell>
                      </>
                    )}
                  </TableRow>
                ))}
              </TableBody>
            </Table>
          </TableContainer>
        </div>
      </div>
    </div>
  );
}
