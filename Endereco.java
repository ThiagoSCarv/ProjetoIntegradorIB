package projetoIntegrador;

public class Endereco {
    private int id;
    private int idRegiao;      // código da região (pode representar cidade, zona, etc)
    private String rua;
    private String bairro;
    private Integer numero;
    private String cep;

    // Construtor vazio (cria um endereço sem preencher os campos ainda)
    public Endereco() {}

    // Construtor com parâmetros (cria um endereço já com todos os dados)
    public Endereco(int idRegiao, String rua, String bairro, Integer numero, String cep) {
        this.idRegiao = idRegiao;
        this.rua = rua;
        this.bairro = bairro;
        this.numero = numero;
        this.cep = cep;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getIdRegiao() {
        return idRegiao;
    }
    public void setIdRegiao(int idRegiao) {
        this.idRegiao = idRegiao;
    }
    public String getRua() {
        return rua;
    }
    public void setRua(String rua) {
        this.rua = rua;
    }
    public String getBairro() {
        return bairro;
    }
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    public Integer getNumero() {
        return numero;
    }
    public void setNumero(Integer numero) {
        this.numero = numero;
    }
    public String getCep() {
        return cep;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }
}
