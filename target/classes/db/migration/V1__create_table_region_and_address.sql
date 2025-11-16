CREATE TABLE regiao (
    id_regiao SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE endereco (
id_endereco SERIAL PRIMARY KEY,
    id_regiao INT,
    rua VARCHAR(255),
    bairro VARCHAR(100),
    numero SMALLINT,
    cep VARCHAR(9),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    FOREIGN KEY (id_regiao) REFERENCES regiao(id_regiao)
)