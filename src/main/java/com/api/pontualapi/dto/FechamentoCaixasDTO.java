package com.api.pontualapi.dto;

import com.api.pontualapi.utils.CurrencyConverter;
import com.api.pontualapi.utils.DateConverter;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FechamentoCaixasDTO {

    private String id;

    private String data;

    @NotNull
    private String totalVenda;

    @NotNull
    private String totalServico;

    @NotNull
    private String totalOrdemServico;

    @NotNull
    private String valorTotalFechamento;

    public FechamentoCaixasDTO(String id, LocalDate data, BigDecimal totalServico, BigDecimal totalVenda, BigDecimal totalOrdemServico, BigDecimal valorTotalFechamento) {
        this.id = id;
        this.data = DateConverter.localDateToString(data);
        this.totalServico = CurrencyConverter.formatCurrency(totalServico);
        this.totalVenda = CurrencyConverter.formatCurrency(totalVenda);
        this.totalOrdemServico = CurrencyConverter.formatCurrency(totalOrdemServico);
        this.valorTotalFechamento = CurrencyConverter.formatCurrency(valorTotalFechamento);
    }
}