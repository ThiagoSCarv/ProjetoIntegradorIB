package projetoIntegrador;

public class Main {
    public static void main(String[] args) {

        CPF meuCPF = new CPF("70427416175");
        System.out.println(meuCPF.getCpf());

        Phone meuTelefone = new Phone("62991972659");
        System.out.println(meuTelefone.getPhone());
    }
}