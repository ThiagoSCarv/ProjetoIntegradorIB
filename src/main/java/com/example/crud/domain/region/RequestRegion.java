package com.example.crud.domain.region;

import jakarta.validation.constraints.NotBlank;

public record RequestRegion(@NotBlank String nome) {
}
