package projetoIntegrador;

import projetoIntegrador.controllers.PacienteController;
import projetoIntegrador.database.PostgreSQLConnection;
import projetoIntegrador.database.migrations.Migration;

import java.sql.Date;

public class Main {
    public static void main(String[] args) {

        PostgreSQLConnection.connect();
        Migration migration = new Migration();
        migration.DropTables();
        migration.CreateTables();
        CPF meuCPF = new CPF("70427416175");

        Phone meuTelefone = new Phone("62991972659");

        Date dataDeNascimento;
        dataDeNascimento = new Date(2000, 10, 10);

        Paciente paciente = new Paciente(1, meuCPF, "Thiago", meuTelefone, "Graduando", false, dataDeNascimento);

        PacienteController pacienteController = new PacienteController();
        pacienteController.create(paciente);
    }


}