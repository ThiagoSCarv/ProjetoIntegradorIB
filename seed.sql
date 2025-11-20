-- ============================================================
-- SCRIPT DE SEED (POPULAÇÃO DE DADOS) - PROJETO INTEGRADOR
-- Contexto: Vacinação em Goiânia - GO
-- ============================================================

-- 1. LIMPEZA DAS TABELAS
-- Usa TRUNCATE com CASCADE para limpar tudo respeitando as Foreign Keys
-- RESTART IDENTITY reinicia os contadores (id 1, 2, 3...)
TRUNCATE TABLE paciente_vacina, paciente, endereco, vacina, regiao RESTART IDENTITY CASCADE;

-- ============================================================
-- 2. INSERINDO REGIÕES DE GOIÂNIA
-- ============================================================
INSERT INTO regiao (nome) VALUES
('Região Central'),   -- ID 1
('Região Sul'),       -- ID 2
('Região Norte'),     -- ID 3
('Região Leste'),     -- ID 4
('Região Oeste'),     -- ID 5
('Região Noroeste'),  -- ID 6
('Região Sudoeste');  -- ID 7

-- ============================================================
-- 3. INSERINDO VACINAS (10 TIPOS)
-- ============================================================
INSERT INTO vacina (nome, tratamento, qtd_doses) VALUES
('CoronaVac', 'COVID-19', 2),
('Pfizer/BioNTech', 'COVID-19', 2),
('AstraZeneca', 'COVID-19', 2),
('Janssen', 'COVID-19', 1),
('Influenza Trivalente', 'Gripe', 1),
('Tríplice Viral', 'Sarampo, Caxumba e Rubéola', 2),
('Hepatite B', 'Hepatite B', 3),
('BCG', 'Tuberculose', 1),
('Febre Amarela', 'Febre Amarela', 1),
('HPV Quadrivalente', 'HPV', 2);

-- ============================================================
-- 4. INSERINDO ENDEREÇOS (20 ENDEREÇOS EM GOIÂNIA)
-- IDs gerados serão de 1 a 20
-- ============================================================
INSERT INTO endereco (id_regiao, rua, bairro, numero, cep) VALUES
(1, 'Avenida Goiás', 'Centro', 1020, '74005-010'),
(2, 'Rua T-63', 'Setor Bueno', 450, '74230-100'),
(2, 'Alameda Ricardo Paranhos', 'Setor Marista', 120, '74180-050'),
(5, 'Avenida 24 de Outubro', 'Campinas', 890, '74505-010'),
(3, 'Avenida Perimetral Norte', 'Setor Urias Magalhães', 200, '74565-200'),
(4, 'Avenida Anhanguera', 'Novo Mundo', 3300, '74710-010'),
(2, 'Rua 90', 'Setor Sul', 50, '74093-020'),
(7, 'Avenida T-9', 'Jardim América', 1500, '74255-220'),
(1, 'Rua 3', 'Centro', 56, '74020-020'),
(2, 'Avenida Deputado Jamel Cecílio', 'Jardim Goiás', 2800, '74810-100'),
(6, 'Rua do Povo', 'Jardim Curitiba', 45, '74480-150'),
(5, 'Rua da Divisa', 'Setor Jaó', 12, '74673-010'),
(2, 'Rua 115', 'Setor Sul', 300, '74085-320'),
(3, 'Avenida Goiás Norte', 'Setor Crimeia Oeste', 99, '74563-150'),
(4, 'Rua 261', 'Setor Leste Universitário', 880, '74610-250'),
(7, 'Avenida C-4', 'Jardim América', 210, '74265-040'),
(2, 'Rua T-37', 'Setor Bueno', 1550, '74230-022'),
(6, 'Avenida Mangalô', 'Setor Morada do Sol', 77, '74475-115'),
(5, 'Avenida Castelo Branco', 'Setor Coimbra', 400, '74530-010'),
(2, 'Rua 137', 'Setor Marista', 44, '74170-120');

-- ============================================================
-- 5. INSERINDO PACIENTES (20 PESSOAS)
-- Relacionados 1-para-1 com os endereços acima
-- ============================================================
INSERT INTO paciente (id_endereco, nome, status, cpf, telefone, escolaridade, data_de_nasc) VALUES
(1, 'João da Silva', 'SAUDAVEL', '12345678901', '(62) 99988-1111', 'MEDIO', '1985-05-10'),
(2, 'Maria Oliveira', 'DOENTE', '23456789012', '(62) 98877-2222', 'SUPERIOR', '1990-08-22'),
(3, 'Carlos Pereira', 'SAUDAVEL', '34567890123', '(62) 99111-3333', 'POS_GRADUACAO', '1978-12-01'),
(4, 'Ana Santos', 'SAUDAVEL', '45678901234', '(62) 99222-4444', 'FUNDAMENTAL', '1965-03-15'),
(5, 'Pedro Costa', 'SAUDAVEL', '56789012345', '(62) 99333-5555', 'MEDIO', '2000-01-20'),
(6, 'Lucia Lima', 'DOENTE', '67890123456', '(62) 99444-6666', 'NENHUMA', '1940-11-30'),
(7, 'Roberto Souza', 'SAUDAVEL', '78901234567', '(62) 99555-7777', 'SUPERIOR', '1988-07-07'),
(8, 'Fernanda Alves', 'SAUDAVEL', '89012345678', '(62) 99666-8888', 'POS_GRADUACAO', '1995-09-12'),
(9, 'Lucas Brito', 'SAUDAVEL', '90123456789', '(62) 99777-9999', 'SUPERIOR', '1992-04-25'),
(10, 'Mariana Dias', 'SAUDAVEL', '01234567890', '(62) 98111-0000', 'MEDIO', '2002-02-14'),
(11, 'Rafael Gomes', 'DOENTE', '11122233344', '(62) 98222-1111', 'FUNDAMENTAL', '1980-06-18'),
(12, 'Juliana Martins', 'SAUDAVEL', '22233344455', '(62) 98333-2222', 'SUPERIOR', '1983-10-05'),
(13, 'Paulo Rocha', 'SAUDAVEL', '33344455566', '(62) 98444-3333', 'MEDIO', '1999-12-25'),
(14, 'Camila Ribeiro', 'SAUDAVEL', '44455566677', '(62) 98555-4444', 'POS_GRADUACAO', '1975-08-30'),
(15, 'Antônio Silva', 'DOENTE', '55566677788', '(62) 98666-5555', 'NENHUMA', '1950-01-01'),
(16, 'Beatriz Nunes', 'SAUDAVEL', '66677788899', '(62) 98777-6666', 'FUNDAMENTAL', '2010-05-20'),
(17, 'Gustavo Henrique', 'SAUDAVEL', '77788899900', '(62) 99888-7777', 'MEDIO', '1996-03-10'),
(18, 'Larissa Moura', 'SAUDAVEL', '88899900011', '(62) 99999-8888', 'SUPERIOR', '1991-11-11'),
(19, 'Diego Ferreira', 'SAUDAVEL', '99900011122', '(62) 99123-4567', 'POS_GRADUACAO', '1987-07-22'),
(20, 'Sofia Cardoso', 'DOENTE', '00011122233', '(62) 99876-5432', 'MEDIO', '2005-09-09');

-- ============================================================
-- 6. INSERINDO APLICAÇÕES DE VACINAS (PACIENTE_VACINA)
-- ============================================================

-- João (ID 1) tomou 2 doses de Pfizer
INSERT INTO paciente_vacina (id_paciente, id_vacina, dose, data_aplicacao) VALUES
(1, 2, 1, '2023-01-10'),
(1, 2, 2, '2023-02-10');

-- Maria (ID 2 - Doente) tomou apenas Influenza
INSERT INTO paciente_vacina (id_paciente, id_vacina, dose, data_aplicacao) VALUES
(2, 5, 1, '2024-04-15');

-- Ana (ID 4 - Idosa) tomou Reforço COVID e Gripe
INSERT INTO paciente_vacina (id_paciente, id_vacina, dose, data_aplicacao) VALUES
(4, 3, 1, '2022-05-20'),
(4, 3, 2, '2022-08-20'),
(4, 5, 1, '2024-03-10');

-- Beatriz (ID 16 - Criança) tomou HPV
INSERT INTO paciente_vacina (id_paciente, id_vacina, dose, data_aplicacao) VALUES
(16, 10, 1, '2023-06-01');

-- Lucas Brito (ID 9) tomou Hepatite B (Ciclo completo)
INSERT INTO paciente_vacina (id_paciente, id_vacina, dose, data_aplicacao) VALUES
(9, 7, 1, '2020-01-15'),
(9, 7, 2, '2020-02-15'),
(9, 7, 3, '2020-08-15');

-- Antônio (ID 15) tomou vacina Janssen (Dose Única)
INSERT INTO paciente_vacina (id_paciente, id_vacina, dose, data_aplicacao) VALUES
(15, 4, 1, '2022-07-01');

-- Sofia (ID 20) tomou Febre Amarela
INSERT INTO paciente_vacina (id_paciente, id_vacina, dose, data_aplicacao) VALUES
(20, 9, 1, '2021-11-20');

-- Inserções variadas para popular o banco
INSERT INTO paciente_vacina (id_paciente, id_vacina, dose, data_aplicacao) VALUES
(3, 1, 1, '2021-09-10'), -- Carlos / CoronaVac
(3, 1, 2, '2021-10-10'),
(5, 8, 1, '2000-01-25'), -- Pedro / BCG (antiga)
(7, 2, 1, '2023-05-05'), -- Roberto / Pfizer
(10, 10, 1, '2015-06-15'), -- Mariana / HPV
(10, 10, 2, '2015-12-15'),
(13, 5, 1, '2024-05-01'), -- Paulo / Gripe
(18, 7, 1, '2010-03-10'), -- Larissa / Hepatite
(19, 4, 1, '2022-09-12'); -- Diego / Janssen
