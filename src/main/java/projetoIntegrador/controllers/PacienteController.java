package projetoIntegrador.controllers;

import projetoIntegrador.Paciente;
import projetoIntegrador.database.PostgreSQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;

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
            pst.setDate(7, paciente.getDataDeNasc());

            int rows = pst.executeUpdate();
            System.out.println(rows + "Cadastro feito com sucesso");

        } catch (Exception e) {
            e.printStackTrace();
        }
    };
    public void update(){

    };
    public void remove(){

    };
    public void index(){

    };
    public void show(){

    };
}
