package com.example.crud.domain.patientVaccine;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record RequestPatientVaccine(
        @NotNull Long idPaciente,
        @NotNull Long idVacina,
        @NotNull Short dose,
        @NotNull LocalDate dataAplicacao
) {
}
