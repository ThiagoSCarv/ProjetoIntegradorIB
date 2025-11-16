package com.example.crud.domain.vaccine;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RequestVaccine(
        @NotBlank String nome,
        @NotBlank String tratamento,
        @NotNull Short qtdDoses
) {
}
