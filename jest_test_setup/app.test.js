// app.test.js
const request = require('supertest');
const app = require('./app');

describe('API Tests for /api/business', () => {

  // GET /api/business/3
  it('GET /api/business/3 should return specific business data', async () => {
    const response = await request(app).get('/api/business/3');
    expect(response.status).toBe(200);
    expect(response.body).toEqual({
      businessId: 3,
      name: "customer",
      password: "$2y$10$3QInhwv0tPcQ.RnX2OtW4OijOF7UQpLAtt11QCZusjwtrXLpYoE/K",
      creationDate: "2024-09-18T05:15:30.000+00:00",
      deathDate: "2025-10-18T04:59:59.000+00:00",
      key_code: 54321,
      categories: []
    });
  });

  // POST /api/business
  it('POST /api/business should create a new business', async () => {
    const newBusiness = {
      name: "newBusiness",
      password: "newPass",
      creationDate: "2024-10-30T05:15:30.000+00:00",
      deathDate: "2025-10-30T04:59:59.000+00:00",
      key_code: 12345,
      categories: []
    };
    const response = await request(app).post('/api/business').send(newBusiness);
    expect(response.status).toBe(201);
    expect(response.body).toMatchObject(newBusiness);
  });

  // PUT /api/business/3
  it('PUT /api/business/3 should update an existing business', async () => {
    const updatedData = {
      name: "updatedCustomer",
      password: "updatedPass"
    };
    const response = await request(app).put('/api/business/3').send(updatedData);
    expect(response.status).toBe(200);
    expect(response.body).toMatchObject(updatedData);
  });
});
