package projetoIntegrador;

import projetoIntegrador.controllers.EnderecoController;
import projetoIntegrador.controllers.PacienteController;
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

        Endereco meuEndereco = new Endereco(1, "Rua dos Bobos", "Jardim Alvorada", 1, "75104-879");

        Paciente paciente = new Paciente(1, meuCPF, "Thiago", meuTelefone, "Graduando", false, dataDeNascimento.toString());
        PacienteController pacienteController = new PacienteController();
        EnderecoController enderecoController = new EnderecoController();
        Endereco meuEndereco2 = new Endereco(2, "Rua N", "Setor Aeroporto", 60, "75104-989");
        enderecoController.create(meuEndereco);
        enderecoController.update(1, meuEndereco2);
        enderecoController.index();
        pacienteController.create(paciente);
        pacienteController.index();
        CPF meuCPF2 = new CPF("57507522083");
        Phone meuTelefone2 = new Phone("62993432854");
        LocalDate dataDeNascimento2 = LocalDate.of(1993, 10, 10);
        Paciente pacienteUpdate = new Paciente(1, meuCPF2, "Fernanda", meuTelefone2, "Graduada", false, dataDeNascimento2.toString());
        pacienteController.update(1, pacienteUpdate);
        pacienteController.index();
        pacienteController.show(1);
    }


}