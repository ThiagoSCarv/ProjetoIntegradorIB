package projetoIntegrador.database.migrations;

public class CreateTablePaciente implements ModelTable{
    @Override
    public String createTable() {
        String sqlInstruction = "CREATE TABLE paciente (" +
                                    "id SERIAL PRIMARY KEY," +
                                    "id_endereco INT NOT NULL," +
                                    "nome VARCHAR(100) NOT NULL," +
                                    "cpf VARCHAR(15) NOT NULL," +
                                    "telefone VARCHAR(15) NOT NULL," +
                                    "escolaridade VARCHAR(15) NOT NULL," +
                                    "doente BOOLEAN NOT NULL," +
                                    "data_de_nasc VARCHAR(15) NOT NULL," +
                                    "created_at TIMESTAMP WITH TIME ZONE DEFAULT NOW()," +
                                    "updated_at  TIMESTAMP WITH TIME ZONE DEFAULT NOW()" +
                                    ")";
        return sqlInstruction;
    }

    @Override
    public String dropTable() {
        String sqlInstruction = "DROP TABLE paciente";
        return sqlInstruction;
    }
}
