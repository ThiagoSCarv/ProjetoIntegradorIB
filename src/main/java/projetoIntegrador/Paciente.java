package projetoIntegrador;
import java.time.LocalDate;
import java.util.Date;

public class Paciente {
    private int id_endereco;
    private CPF cpf;
    private String nome;
    private Phone telefone;
    private String escolaridade;
    private boolean doente;
    private String dataDeNasc;

    public Paciente(){}

    public Paciente(int id_endereco, CPF cpf, String nome, Phone telefone, String escolaridade, boolean doente, String dataDeNasc){
        this.id_endereco = id_endereco;
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.escolaridade = escolaridade;
        this.doente = doente;
        this.dataDeNasc = dataDeNasc;
    }

    public int getId_endereco() {
        return id_endereco;
    }

    public void setId_endereco(int id_endereco) {
        this.id_endereco = id_endereco;
    }

    public StringBuilder getCpf() {
        return this.cpf.getCpf();
    }
    public void setCpf(CPF cpf) {
        this.cpf = cpf;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getTelefone() {
        return this.telefone.getPhone();
    }
    public void setTelefone(Phone telefone) {
        this.telefone = telefone;
    }
    public String getEscolaridade() {
        return escolaridade;
    }
    public void setEscolaridade(String escolaridade) {
        this.escolaridade = escolaridade;
    }

    public boolean isDoente() {
        return doente;
    }
    public void setDoente(boolean doente) {
        this.doente = doente;
    }
    public String getDataDeNasc() {
        return this.dataDeNasc;
    }
    public void setDataDeNasc(String d) {
        this.dataDeNasc = d;
    }
}
