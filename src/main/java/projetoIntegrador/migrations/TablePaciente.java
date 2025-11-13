package projetoIntegrador.migrations;

public class TablePaciente {
    public static String createTablePaciente() {
        String create = "CREATE TABLE paciente (" +
                "id SERIAL PRIMARY KEY, " +
                "id_endereco INT NOT NULL, " +
                "nome VARCHAR(100) NOT NULL, " +
                "cpf VARCHAR(15) NOT NULL, " +
                "telefone VARCHAR(15) NOT NULL, " +
                "escolaridade VARCHAR(15) NOT NULL, " +
                "doente BOOLEAN NOT NULL, " +
                "data_de_nasc DATE NOT NULL, " +
                "created_at TIMESTAMP WITH TIME ZONE DEFAULT NOW(), " +
                "updated_at  TIMESTAMP WITH TIME ZONE DEFAULT NOW()" +
                ")";
        return create;
    }

    public static String dropTablePaciente() {
        String drop = "DROP TABLE paciente";
        return drop;
    }
}
