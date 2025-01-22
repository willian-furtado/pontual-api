package com.api.pontualapi.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class FechamentoCalculoDTO {
    private List<FechamentoCalculoTipoPagamento> tipoPagamentos;
    private TotalDTO total;
}
