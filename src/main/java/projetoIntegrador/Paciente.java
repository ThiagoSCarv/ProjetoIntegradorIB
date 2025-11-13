package projetoIntegrador;

import java.time.format.DateTimeFormatter;

public class Paciente {
    private CPF cpf;
    private String nome;
    private Phone telefone;
    private String escolaridade;
    private boolean doente;
    private DateTimeFormatter dataDeNasc;

    public Paciente(){}

    public Paciente(CPF cpf, String nome, Phone telefone, String escolaridade, boolean doente, DateTimeFormatter dataDeNasc){
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.escolaridade = escolaridade;
        this.doente = doente;
        this.dataDeNasc = dataDeNasc;
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
    public DateTimeFormatter getDataDeNasc() {
        return this.dataDeNasc;
    }
    public void setDataDeNasc(DateTimeFormatter d) {
        this.dataDeNasc = d;
    }
}
