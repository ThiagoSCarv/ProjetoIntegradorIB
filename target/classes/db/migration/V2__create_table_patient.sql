CREATE TABLE paciente (
    id_paciente SERIAL PRIMARY KEY,
    id_endereco INT UNIQUE,
    nome VARCHAR(255) NOT NULL,
    status VARCHAR(50) DEFAULT 'SAUDAVEL',
    cpf VARCHAR(11) NOT NULL UNIQUE,
    telefone VARCHAR(15),
    escolaridade VARCHAR(50),
    data_de_nasc DATE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    FOREIGN KEY (id_endereco) REFERENCES endereco(id_endereco)
);