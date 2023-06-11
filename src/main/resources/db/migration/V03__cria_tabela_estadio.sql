CREATE TABLE estadio (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(60) NOT NULL,
    endereco VARCHAR(60) NOT NULL,
    CONSTRAINT nome_length CHECK (LENGTH(nome) <= 60),
    CONSTRAINT endereco_length CHECK (LENGTH(endereco) <= 60)
);
