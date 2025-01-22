package com.api.pontualapi.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class FechamentoCalculoTipoPagamento {
    private String metodoPagamento;
    private BigDecimal totalVenda;
    private BigDecimal totalServico;
    private BigDecimal totalOrdemServico;
}
