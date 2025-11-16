package com.example.crud.domain.patient;

import com.example.crud.domain.address.Address;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

enum Status {
    SAUDAVEL, DOENTE
}

enum Escolaridade {
    NENHUMA, FUNDAMENTAL, MEDIO, SUPERIOR, POS_GRADUACAO
}


@Table(name="paciente")
@Entity(name="paciente")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_paciente")
    private Long id;

    private String nome;
    private String cpf;
    private String telefone;

    @Enumerated(EnumType.STRING)
    private Status status = Status.SAUDAVEL;

    @Enumerated(EnumType.STRING)
    private Escolaridade escolaridade;

    @Column(name = "data_de_nasc")
    private LocalDate dataNascimento;

    @OneToOne
    @JoinColumn(name="id_endereco")
    private Address endereco;
}