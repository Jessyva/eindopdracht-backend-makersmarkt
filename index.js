const express = require('express');
const { Pool } = require('pg');
const app = express();
const port = 5432;

// Configureer de verbinding met PostgreSQL
const pool = new Pool({
    user: 'postgres',        // Vervang door je PostgreSQL gebruikersnaam
    host: 'localhost',            // Of je databasehost
    database: 'MakersMarkt',    // Vervang door je database naam
    password: 'Bijl999',    // Vervang door je PostgreSQL wachtwoord
    port: 5432,                   // Standaard PostgreSQL poort
});

app.use(express.json());

// Endpoint om gegevens op te halen
app.get('/users', async (req, res) => {
    try {
        const result = await pool.query('SELECT * FROM users');
        res.json(result.rows);
    } catch (err) {
        console.error(err);
        res.status(500).send('Server Error');
    }
});

// Endpoint om gegevens toe te voegen
app.post('/users', async (req, res) => {
    const { name, email } = req.body;
    try {
        const result = await pool.query('INSERT INTO users(name, email) VALUES($1, $2) RETURNING *', [name, email]);
        res.status(201).json(result.rows[0]);
    } catch (err) {
        console.error(err);
        res.status(500).send('Server Error');
    }
});

app.listen(port, () => {
    console.log(`Server running at http://localhost:${port}`);
});
