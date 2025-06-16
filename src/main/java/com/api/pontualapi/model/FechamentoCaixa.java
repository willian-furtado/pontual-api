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
@Table(name = "fechamento_caixa")
public class FechamentoCaixa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private String id;

    @NotNull
    @Column(nullable = false)
    private LocalDate data;

    @NotNull
    @Column(nullable = false, scale = 2, precision = 19)
    private BigDecimal totalVenda;

    @NotNull
    @Column(nullable = false, scale = 2, precision = 19)
    private BigDecimal totalServico;

    @NotNull
    @Column(nullable = false, scale = 2, precision = 19)
    private BigDecimal totalOrdemServico;

    @NotNull
    @Column(nullable = false, scale = 2, precision = 19)
    private BigDecimal valorTotal;

}
