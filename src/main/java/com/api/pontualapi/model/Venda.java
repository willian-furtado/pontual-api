package com.api.pontualapi.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "venda")
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private String id;

    @NotNull
    @Size(max = 15)
    @Column(length = 15, nullable = false)
    private String tipo;

    @NotNull
    @Size(max = 150)
    @Column(length = 150, nullable = false)
    private String descricao;

    @Column(nullable = false)
    private LocalDateTime data;

    @Column(nullable = false, scale = 2, precision = 19)
    private BigDecimal valorTotal;

    @Column(nullable = false)
    private String formaPagamento;

    @Column()
    private Long qdtParcelas;

    @Column(scale = 2, precision = 19)
    private BigDecimal precoParcela;

    @Column(length = 255)
    private String observacoes;

}
