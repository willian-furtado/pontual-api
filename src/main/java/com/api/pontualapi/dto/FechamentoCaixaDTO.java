package com.api.pontualapi.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FechamentoCaixaDTO {

    private String id;

    private String data;

    @NotNull
    private BigDecimal totalVenda;

    @NotNull
    private BigDecimal totalServico;

    @NotNull
    private BigDecimal totalOrdemServico;

    @NotNull
    private BigDecimal valorTotalFechamento;

}
