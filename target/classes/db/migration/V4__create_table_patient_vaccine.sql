CREATE TABLE paciente_vacina (
    id_paciente_vacina SERIAL PRIMARY KEY,

    id_paciente INT NOT NULL,
    id_vacina INT NOT NULL,

    dose SMALLINT NOT NULL DEFAULT 1,
    data_aplicacao DATE NOT NULL,

    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    FOREIGN KEY (id_paciente) REFERENCES paciente(id_paciente),
    FOREIGN KEY (id_vacina) REFERENCES vacina(id_vacina)
);