package com.example.crud.domain.region;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@Table(name="regiao")
@Entity(name="regiao")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_regiao")
    private Long id;

    private String nome;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private Timestamp dataCriacao;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Timestamp dataAtualizacao;

    public Region(RequestRegion requestRegion) {
        this.nome = requestRegion.nome();
    }
}