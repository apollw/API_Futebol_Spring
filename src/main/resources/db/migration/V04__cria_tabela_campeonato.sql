CREATE TABLE campeonato (
    id SERIAL PRIMARY KEY,
    ano INTEGER NOT NULL,
    nome VARCHAR(60) NOT NULL,
    CONSTRAINT nome_length CHECK (LENGTH(nome) <= 60)
);
