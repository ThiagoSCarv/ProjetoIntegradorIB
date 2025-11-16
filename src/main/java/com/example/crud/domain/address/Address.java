package com.example.crud.domain.address;

import com.example.crud.domain.region.Region;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@Table(name="endereco")
@Entity(name="endereco")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_endereco")
    private Long id;

    private String rua;
    private String bairro;
    private Short numero;
    private String cep;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private Timestamp dataCriacao;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Timestamp dataAtualizacao;

    @ManyToOne
    @JoinColumn(name="id_regiao")
    private Region regiao;

    public Address(RequestAddress requestAddress) {
        this.rua = requestAddress.rua();
        this.bairro = requestAddress.bairro();
        this.numero = requestAddress.numero();
        this.cep = requestAddress.cep();
    }
}