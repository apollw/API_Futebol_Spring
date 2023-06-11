CREATE TABLE time (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(60) NOT NULL,
    CONSTRAINT nome_length CHECK (LENGTH(nome) <= 60)
);
