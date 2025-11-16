package com.example.crud.domain.patient;

import com.example.crud.domain.address.Address;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
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

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private Timestamp dataCriacao;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Timestamp dataAtualizacao;


    @OneToOne
    @JoinColumn(name="id_endereco")
    private Address endereco;

    public Patient(RequestPatient requestPatient) {
        this.nome = requestPatient.nome();
        this.cpf = requestPatient.cpf();
        this.telefone = requestPatient.telefone();
        this.status = requestPatient.status();
        this.escolaridade = requestPatient.escolaridade();
        this.dataNascimento = requestPatient.dataNascimento();
    }
}