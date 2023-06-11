CREATE TABLE jogador (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(60) NOT NULL,
    data_de_nascimento DATE NOT NULL,
    altura FLOAT NOT NULL,
    time_id INTEGER,
    FOREIGN KEY (time_id) REFERENCES time (id)
);
