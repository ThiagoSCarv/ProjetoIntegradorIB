package projetoIntegrador.database.migrations;


public class CreateTableEndereco implements ModelTable {
    @Override
    public String createTable() {
        String sqlInstruction = "CREATE TABLE endereco (" +
                                    "id SERIAL PRIMARY KEY," +
                                    "rua VARCHAR(100) NOT NULL," +
                                    "bairro VARCHAR(50) NOT NULL," +
                                    "numero INT NOT NULL," +
                                    "cep VARCHAR(9) UNIQUE NOT NULL," +
                                    "created_at TIMESTAMP WITH TIME ZONE DEFAULT NOW()," +
                                    "updated_at TIMESTAMP WITH TIME ZONE DEFAULT NOW()" +
                                    "); ";
        return sqlInstruction;
    }

    @Override
    public String dropTable() {
        String sqlInstruction = "DROP TABLE endereco CASCADE; ";
        return sqlInstruction;
    }
}
