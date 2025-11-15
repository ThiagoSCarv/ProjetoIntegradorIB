package projetoIntegrador.database.migrations;


import projetoIntegrador.PostgreSQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class Migration {

    public Connection connection;
    CreateTablePaciente tablePaciente = new CreateTablePaciente();
    CreateTableEndereco tableEndereco = new CreateTableEndereco();

    public Migration(){
        connection = PostgreSQLConnection.getConnection();
    }

    public void CreateTables() {
        List<String> createTables = new ArrayList<>();

        createTables.add(tableEndereco.createTable());
        createTables.add(tablePaciente.createTable());

        try {
            for (String sqlInstruction : createTables) {
                PreparedStatement pst = connection.prepareStatement(sqlInstruction);
                pst.execute();
            }
            System.out.println("Tabelas criadas com sucesso");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void DropTables() {
        List<String> dropTables = new ArrayList<>();
        dropTables.add(tableEndereco.dropTable());
        dropTables.add(tablePaciente.dropTable());

        try {
            for (String sqlInstruction : dropTables) {
                PreparedStatement pst = connection.prepareStatement(sqlInstruction);
                pst.execute();
            }
            System.out.println("Tabelas desfeitas");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
