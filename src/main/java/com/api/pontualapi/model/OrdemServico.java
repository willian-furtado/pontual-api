package com.api.pontualapi.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "ordem_servico")
public class OrdemServico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private String id;

    @Column(length = 15, nullable = false)
    private String codigoIdentificador;

    @ManyToOne()
    @JoinColumn(name = "cliente_id", referencedColumnName = "id")
    private Cliente cliente;

    @NotNull
    @Column(nullable = false, length = 255)
    private String servico;

    @Column(nullable = false)
    private LocalDate dataOrcamento;

    @Column(nullable = false)
    private LocalDate dataEntrega;

    @Column()
    private LocalDate dataFaturamento;

    @Column(nullable = false, scale = 2, precision = 19)
    private BigDecimal preco;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private String statusPagamento;

    @Column(nullable = false)
    private String formaPagamento;

    @Column()
    private Long qdtParcelas;

    @Column(scale = 2, precision = 19)
    private BigDecimal precoParcela;

    @Column(length = 255)
    private String observacoes;
}
