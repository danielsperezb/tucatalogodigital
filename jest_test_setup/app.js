// app.js
const express = require('express');
const app = express();
app.use(express.json());

// Datos de ejemplo
let businesses = [
  {
    businessId: 1,
    name: "admin",
    password: "$2y$10$wYLc7E3Ib9C76y2v2.Ns2.miF9HcYIaoY0uG/CWod507ceFcU/68a",
    creationDate: "2024-09-18T05:15:30.000+00:00",
    deathDate: "2025-10-18T04:59:59.000+00:00",
    key_code: 54321,
    categories: []
  },
  {
    businessId: 3,
    name: "customer",
    password: "$2y$10$3QInhwv0tPcQ.RnX2OtW4OijOF7UQpLAtt11QCZusjwtrXLpYoE/K",
    creationDate: "2024-09-18T05:15:30.000+00:00",
    deathDate: "2025-10-18T04:59:59.000+00:00",
    key_code: 54321,
    categories: []
  }
];

// GET /api/business/3 - Obtener un negocio específico
app.get('/api/business/:id', (req, res) => {
  const business = businesses.find(b => b.businessId === parseInt(req.params.id));
  if (business) {
    res.status(200).json(business);
  } else {
    res.status(404).send("Business not found");
  }
});

// POST /api/business - Crear un nuevo negocio
app.post('/api/business', (req, res) => {
  const newBusiness = { ...req.body, businessId: businesses.length + 1 };
  businesses.push(newBusiness);
  res.status(201).json(newBusiness);
});

// PUT /api/business - Actualizar un negocio existente
app.put('/api/business/:id', (req, res) => {
  const business = businesses.find(b => b.businessId === parseInt(req.params.id));
  if (business) {
    Object.assign(business, req.body);
    res.status(200).json(business);
  } else {
    res.status(404).send("Business not found");
  }
});

module.exports = app;
