package projetoIntegrador;

import java.util.InputMismatchException;

public class CPF {
    private String cpf;

    public CPF(String cpf) {
        this.setCpf(cpf);
    }

    public StringBuilder getCpf() {
        return this.maskCPF(this.cpf);
    }

    public Boolean setCpf(String cpf) {
        if (!this.isValid(cpf)) {
           return false;
        }
        this.cpf = cpf;
        return true;
    }

    public Boolean isValid(String cpf) {
        cpf = cpf.replaceAll("[^0-9]", "");

        if (cpf.length() != 11) {
            return false;
        }

        if (cpf.matches("(\\d)\\1{10}")) {
            return false;
        }

        try {
            int soma = 0;
            int peso = 10;
            for (int i = 0; i < 9; i++) {
                soma += Character.getNumericValue(cpf.charAt(i)) * peso--;
            }

            int primeiroDigitoVerificador = 11 - (soma % 11);
            if (primeiroDigitoVerificador == 10 || primeiroDigitoVerificador == 11) {
                primeiroDigitoVerificador = 0;
            }

            if (primeiroDigitoVerificador != Character.getNumericValue(cpf.charAt(9))) {
                return false;
            }

            soma = 0;
            peso = 11;
            for (int i = 0; i < 10; i++) {
                soma += Character.getNumericValue(cpf.charAt(i)) * peso--;
            }

            int segundoDigitoVerificador = 11 - (soma % 11);
            if (segundoDigitoVerificador == 10 || segundoDigitoVerificador == 11) {
                segundoDigitoVerificador = 0;
            }

            return segundoDigitoVerificador == Character.getNumericValue(cpf.charAt(10));

        } catch (InputMismatchException erro) {
            return false;
        }

    }

    public StringBuilder maskCPF(String CPF) {
        if (!this.isValid(CPF)) {
            return new StringBuilder("CPF não válido");
        }
        String cpfFirstGroup = CPF.substring(0, 3);
        String cpfSecondGroup = CPF.substring(3, 6);
        String cpfThirdGroup = CPF.substring(6, 9);
        String cpfLastGroup = CPF.substring(9, 11);

       StringBuilder mask = new StringBuilder();
       mask.append(cpfFirstGroup);
       mask.append(".");
       mask.append(cpfSecondGroup);
       mask.append(".");
       mask.append(cpfThirdGroup);
       mask.append("-");
       mask.append(cpfLastGroup);
       return mask;
    }
}
