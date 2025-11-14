package projetoIntegrador;

import projetoIntegrador.controllers.PacienteController;
import projetoIntegrador.database.PostgreSQLConnection;
import projetoIntegrador.database.migrations.Migration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {

        PostgreSQLConnection.connect();
        Migration migration = new Migration();
        migration.DropTables();
        migration.CreateTables();
        CPF meuCPF = new CPF("70427416175");

        Phone meuTelefone = new Phone("62991972659");

        LocalDate dataDeNascimento = LocalDate.of(2000, 10, 10);

        Paciente paciente = new Paciente(1, meuCPF, "Thiago", meuTelefone, "Graduando", false, dataDeNascimento.toString());
        PacienteController pacienteController = new PacienteController();
        pacienteController.create(paciente);
        pacienteController.index();
        CPF meuCPF2 = new CPF("57507522083");
        Phone meuTelefone2 = new Phone("62993432854");
        LocalDate dataDeNascimento2 = LocalDate.of(1993, 10, 10);
        Paciente pacienteUpdate = new Paciente(2, meuCPF2, "Fernanda", meuTelefone2, "Graduada", false, dataDeNascimento2.toString());
        pacienteController.update(1, pacienteUpdate);
        pacienteController.index();
        pacienteController.show(1);
        pacienteController.remove(1);
    }


}