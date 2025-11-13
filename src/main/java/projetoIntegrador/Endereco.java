package projetoIntegrador;

public class Endereco {
    private int idRegiao;
    private String rua;
    private String bairro;
    private Integer numero;
    private String cep;

    public Endereco() {}

    public Endereco(int idRegiao, String rua, String bairro, Integer numero, String cep) {
        this.idRegiao = idRegiao;
        this.rua = rua;
        this.bairro = bairro;
        this.numero = numero;
        this.cep = cep;
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

