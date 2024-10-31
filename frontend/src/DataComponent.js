import React, { useEffect, useState } from 'react';
import axios from 'axios';

function DataComponent() {
  const [data, setData] = useState(null);
  const [error, setError] = useState(null);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    const fetchDataWithToken = async () => {
      try {
        // Reemplaza esta línea con el token que obtuviste al autenticarte
        const token = 'eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJhZG1pbiIsImlzcyI6InR1Y2F0YWxvZ29kaWdpdGFsIiwiaWF0IjoxNzMwMzQ2MDU5LCJleHAiOjE3MzE2NDIwNTl9.JUHiqbuJSDJLn5OEOLgS1Rh0gq_n0OTDcXHbNw6CEEA';

        const dataResponse = await axios.get('http://localhost:8080/api/business', {
          headers: {
            'Authorization': `Bearer ${token}`, // Enviar el token como Bearer
          },
          withCredentials: true,
        });

        setData(dataResponse.data);
        setLoading(false);
      } catch (err) {
        console.error('Error fetching data:', err);
        setError('Error fetching data');
        setLoading(false);
      }
    };

    fetchDataWithToken();
  }, []);

  if (loading) return <div>Loading...</div>;
  if (error) return <div>{error}</div>;

  return (
    <div>
      <h1>Data from Java API</h1>
      <pre>{JSON.stringify(data, null, 2)}</pre>
    </div>
  );
}

export default DataComponent;
