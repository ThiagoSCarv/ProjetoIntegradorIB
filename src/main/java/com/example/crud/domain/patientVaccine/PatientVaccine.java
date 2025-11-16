package com.example.crud.domain.patientVaccine;

import com.example.crud.domain.patient.Patient;
import com.example.crud.domain.region.Region;
import com.example.crud.domain.vaccine.Vaccine;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.time.LocalDate;

@Table(name="paciente_vacina")
@Entity(name="paciente_vacina")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class PatientVaccine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_paciente_vacina")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_paciente")
    private Patient paciente;

    @ManyToOne
    @JoinColumn(name = "id_vacina")
    private Vaccine vacina;

    @Column(name = "dose")
    private Short dose;

    @Column(name = "data_aplicacao")
    private LocalDate dataAplicacao;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private Timestamp dataCriacao;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Timestamp dataAtualizacao;
}
