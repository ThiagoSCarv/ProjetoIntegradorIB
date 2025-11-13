package projetoIntegrador.migrations;

import projetoIntegrador.PostgreSQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Migration {

    public Connection connection;

    public Migration(){
        connection = PostgreSQLConnection.getConnection();
    }

    public void CreateTables() {

        try {
            PreparedStatement pst = connection.prepareStatement("CREATE TABLE paciente (" +
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
                    ")");

            pst.execute();
            System.out.println("Tabelas criadas com sucesso");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void DropTables() {

    }
}
