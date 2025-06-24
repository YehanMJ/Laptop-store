import React, { useState } from "react";
import { uploadFile, downloadFile } from "../app/api";
import { Box } from "@mui/material";

export default function FileUpload() {
  const [file, setFile] = useState(null);
  const [message, setMessage] = useState("");
  const [filename, setFilename] = useState("");

  const handleChange = (e) => {
    setFile(e.target.files[0]);
  };

  const handleUpload = async (e) => {
    e.preventDefault();
    if (!file) return;
    const res = await uploadFile(file);
    if (res.ok) {
      setMessage("File uploaded successfully!");
    } else {
      setMessage("Upload failed");
    }
  };

  const handleDownload = async (e) => {
    e.preventDefault();
    if (!filename) return;
    const res = await downloadFile(filename);
    if (res.ok) {
      const blob = await res.blob();
      const url = window.URL.createObjectURL(blob);
      const a = document.createElement("a");
      a.href = url;
      a.download = filename;
      a.click();
      window.URL.revokeObjectURL(url);
    } else {
      setMessage("Download failed");
    }
  };

  return (
    <Box>
      <h2>File Upload/Download</h2>
      <form onSubmit={handleUpload}>
        <input type="file" onChange={handleChange} />
        <button type="submit">Upload</button>
      </form>
      <form onSubmit={handleDownload}>
        <input
          value={filename}
          onChange={(e) => setFilename(e.target.value)}
          placeholder="Filename to download"
        />
        <button type="submit">Download</button>
      </form>
      <Box>{message}</Box>
    </Box>
  );
}
