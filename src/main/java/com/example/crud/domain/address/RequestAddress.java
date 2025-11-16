package com.example.crud.domain.address;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RequestAddress(
        @NotBlank String rua,
        @NotBlank String bairro,
        @NotNull Short numero,
        @NotBlank String cep,
        @NotNull Long idRegiao
) {
}
