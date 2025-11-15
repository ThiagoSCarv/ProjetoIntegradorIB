package projetoIntegrador.controllers;

import projetoIntegrador.Endereco;
import projetoIntegrador.Paciente;
import projetoIntegrador.PostgreSQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class EnderecoController {
    private Connection connection;
    public EnderecoController() { connection = PostgreSQLConnection.getConnection();}

    public void create(Endereco endereco) {
        String sqlInstruction = "INSERT INTO endereco (rua, bairro, numero, cep) VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement pst = connection.prepareStatement(sqlInstruction);
            pst.setString(1, endereco.getRua());
            pst.setString(2, endereco.getBairro());
            pst.setInt(3, endereco.getNumero());
            pst.setString(4, endereco.getCep());

            int rows = pst.executeUpdate();
            System.out.printf("Cadastro realizado com sucesso em %d ", rows, rows <= 1 ? "linha" : "linhas");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void update(int id,Endereco endereco){
        String sqlInstruction = "UPDATE endereco SET rua = ?, " +
                "bairro = ?, " +
                "numero = ?, " +
                "cep = ? " +
                "WHERE id = ?;";

        try  {

            PreparedStatement pst = connection.prepareStatement(sqlInstruction);
            pst.setString(1, endereco.getRua());
            pst.setString(2, endereco.getBairro());
            pst.setInt(3, endereco.getNumero());
            pst.setString(4, endereco.getCep());
            pst.setInt(5, id);

            int rows = pst.executeUpdate();
            System.out.println(rows + " Cadastros atualizados");

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    };
    public void remove(int id){
        String sqlInstruction = "DELETE FROM endereco WHERE id = ?";

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
        String sqlInstruction = "SELECT id, rua, bairro, numero, cep FROM endereco;";
        try {

            Statement pst = connection.createStatement();
            ResultSet result = pst.executeQuery(sqlInstruction);

            while (result.next()) {
                System.out.println(result.getString("id") + " | " +
                        result.getString("rua") + " | " +
                        result.getString("bairro") + " | " +
                        result.getInt("numero") + " | " +
                        result.getString("cep"));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    };
}
