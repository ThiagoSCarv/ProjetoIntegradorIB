package com.example.crud.domain.vaccine;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@Table(name="vacina")
@Entity(name="vacina")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Vaccine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vacina")
    private Long id;

    @Column(name = "nome")
    private String nome;

    private String tratamento;

    @Column(name = "qtd_doses")
    private Short qtdDoses = 1;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private Timestamp dataCriacao;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Timestamp dataAtualizacao;
}