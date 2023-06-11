CREATE TABLE partida (
    id SERIAL PRIMARY KEY,
    data TIMESTAMP NOT NULL,
    time_mandante_id INTEGER REFERENCES time(id),
    time_visitante_id INTEGER REFERENCES time(id),
    campeonato_id INTEGER REFERENCES campeonato(id)
);
