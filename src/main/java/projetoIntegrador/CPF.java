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
        // Remove caracteres não numéricos
        cpf = cpf.replaceAll("[^0-9]", "");

        // Verifica se o CPF tem 11 dígitos
        if (cpf.length() != 11) {
            return false;
        }

        // Verifica se todos os dígitos são iguais (CPFs inválidos por regra)
        if (cpf.matches("(\\d)\\1{10}")) {
            return false;
        }

        // 1º Cálculo do Dígito Verificador
        try {
            int soma = 0;
            int peso = 10;
            // Itera sobre os 9 primeiros dígitos
            for (int i = 0; i < 9; i++) {
                // Converte o char para int e multiplica pelo peso
                soma += Character.getNumericValue(cpf.charAt(i)) * peso--;
            }

            int primeiroDigitoVerificador = 11 - (soma % 11);
            if (primeiroDigitoVerificador == 10 || primeiroDigitoVerificador == 11) {
                primeiroDigitoVerificador = 0;
            }

            // Compara o 1º dígito verificador calculado com o 10º dígito do CPF
            if (primeiroDigitoVerificador != Character.getNumericValue(cpf.charAt(9))) {
                return false;
            }

            // 2º Cálculo do Dígito Verificador
            soma = 0;
            peso = 11;
            // Itera sobre os 10 primeiros dígitos (agora o 10º é o 1º DV)
            for (int i = 0; i < 10; i++) {
                soma += Character.getNumericValue(cpf.charAt(i)) * peso--;
            }

            int segundoDigitoVerificador = 11 - (soma % 11);
            if (segundoDigitoVerificador == 10 || segundoDigitoVerificador == 11) {
                segundoDigitoVerificador = 0;
            }

            // Compara o 2º dígito verificador calculado com o 11º dígito do CPF
            return segundoDigitoVerificador == Character.getNumericValue(cpf.charAt(10));

        } catch (InputMismatchException erro) {
            // Captura erro caso a conversão de caracteres falhe
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
