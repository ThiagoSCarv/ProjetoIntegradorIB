CREATE TYPE status_enum AS ENUM ('SAUDAVEL', 'DOENTE');
CREATE TYPE escolaridade_enum AS ENUM ('NENHUMA', 'FUNDAMENTAL', 'MEDIO', 'SUPERIOR', 'POS_GRADUACAO');

CREATE TABLE paciente (
    id_paciente SERIAL PRIMARY KEY,
    id_endereco INT UNIQUE,
    nome VARCHAR(255) NOT NULL,
    status status_enum DEFAULT 'SAUDAVEL',
    cpf VARCHAR(11) NOT NULL UNIQUE,
    telefone VARCHAR(15),
    escolaridade escolaridade_enum,
    data_de_nasc DATE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    FOREIGN KEY (id_endereco) REFERENCES endereco(id_endereco)
);