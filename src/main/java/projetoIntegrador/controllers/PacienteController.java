package projetoIntegrador.controllers;

import projetoIntegrador.CPF;
import projetoIntegrador.Paciente;
import projetoIntegrador.Phone;
import projetoIntegrador.database.PostgreSQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class PacienteController {
    private Connection connection;

    public PacienteController() {
        connection = PostgreSQLConnection.getConnection();
    }

    public void create(Paciente paciente){
        String sqlInstruction = "INSERT INTO paciente (id_endereco, nome, cpf, telefone, escolaridade, doente, data_de_nasc) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement pst = connection.prepareStatement(sqlInstruction);
            pst.setInt(1, paciente.getId_endereco());
            pst.setString(2, paciente.getNome());
            pst.setString(3, String.valueOf(paciente.getCpf()));
            pst.setString(4, paciente.getTelefone());
            pst.setString(5, paciente.getEscolaridade());
            pst.setBoolean(6, paciente.isDoente());
            pst.setString(7, paciente.getDataDeNasc());

            int rows = pst.executeUpdate();
            System.out.println(rows + "Cadastro feito com sucesso");

        } catch (Exception e) {
            e.printStackTrace();
        }
    };
    public void update(int id, Paciente paciente){
        String sqlInstruction = "UPDATE paciente SET id_endereco = ?, " +
                "nome = ?, " +
                "cpf = ?, " +
                "telefone = ?, " +
                "escolaridade = ?, " +
                "doente = ?, " +
                "data_de_nasc = ? " +
                "WHERE id = ?;";

        try  {

            PreparedStatement pst = connection.prepareStatement(sqlInstruction);
            pst.setInt(1, paciente.getId_endereco());
            pst.setString(2, paciente.getNome());
            pst.setString(3, String.valueOf(paciente.getCpf()));
            pst.setString(4, paciente.getTelefone());
            pst.setString(5, paciente.getEscolaridade());
            pst.setBoolean(6, paciente.isDoente());
            pst.setString(7, paciente.getDataDeNasc());
            pst.setInt(8, id);

            int rows = pst.executeUpdate();
            System.out.println(rows + " Cadastros atualizados");

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    };
    public void remove(int id){
        String sqlInstruction = "DELETE FROM paciente WHERE id = ?";

        try {
            PreparedStatement pst = connection.prepareStatement(sqlInstruction);
            pst.setInt(1, id);
            pst.executeUpdate();
            System.out.println("Cadastro deletado");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    };
    public void index(){
        String sqlInstruction = "SELECT * FROM paciente";
       try {

           Statement pst = connection.createStatement();
           ResultSet result = pst.executeQuery(sqlInstruction);

           while (result.next()) {
               System.out.println(result.getInt("id") + "|" +
                       result.getInt("id_endereco") + "|" +
                       result.getString("nome") + "|" +
                       result.getString("cpf") + "|" +
                       result.getString("telefone") + "|" +
                       result.getString("escolaridade") + "|" +
                       result.getBoolean("doente") + "|" +
                       result.getDate("data_de_nasc"));
           }

       } catch (Exception ex) {
          ex.printStackTrace();
       }

    };
    public void show(int id){
        String sqlInstruction = "SELECT * FROM paciente WHERE id = ?";

        try {
            PreparedStatement pst = connection.prepareStatement(sqlInstruction);
            pst.setInt(1, id);
            ResultSet result = pst.executeQuery();
            if (result.next()) {
                System.out.println(result.getInt("id") + "|" +
                        result.getInt("id_endereco") + "|" +
                        result.getString("nome") + "|" +
                        result.getString("cpf") + "|" +
                        result.getString("telefone") + "|" +
                        result.getString("escolaridade") + "|" +
                        result.getBoolean("doente") + "|" +
                        result.getDate("data_de_nasc"));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    };
}
