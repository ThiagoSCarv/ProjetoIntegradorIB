package com.example.crud.domain.patient;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

public record RequestPatient(
        @NotBlank String nome,
        @NotBlank String cpf,
        @NotNull String telefone,
        @NotNull Status status,
        @NotNull Escolaridade escolaridade,
        @NotNull LocalDate dataNascimento,
        @NotNull Long idEndereco
) {
}
