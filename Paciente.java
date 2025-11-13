package projetoIntegrador;

public class Paciente {
    private int id;
    private String cpf;
    private String nome;
    private String sobrenome;
    private String telefone;
    private String escolaridade;
    private boolean doente;
    private String dataDeNasc;

    // Esse comentário explica: que existe (ou vai existir) uma ligação com outra tabela chamada paciente_endereco
    // que guarda o endereço do paciente. paciente_endereco para vínculo (histórico)

    //  Construtor vazio (para criar um paciente sem preencher nada ainda)
    public Paciente(){}

    //  Construtor com parâmetros (para criar um paciente já com os dados preenchidos)
    public Paciente(String cpf, String nome, String sobrenome, String telefone, String escolaridade, boolean doente, String dataDeNasc){
        this.cpf = cpf;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.telefone = telefone;
        this.escolaridade = escolaridade;
        this.doente = doente;
        this.dataDeNasc = dataDeNasc;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getSobrenome() {
        return sobrenome;
    }
    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getEscolaridade() {
        return escolaridade;
    }
    public void setEscolaridade(String escolaridade) {
        this.escolaridade = escolaridade;
    }

    // Verifica se o paciente está doente
    public boolean isDoente() {
        return doente;
    }
    public void setDoente(boolean doente) {
        this.doente = doente;
    }
    public String getDataDeNasc() {
        return dataDeNasc;
    }
    public void setDataDeNasc(String d) {
        this.dataDeNasc = d;
    }
}
