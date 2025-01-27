package com.api.pontualapi.dto;

import com.api.pontualapi.utils.DateConverter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class VendaDTO {

    private String id;

    @NotBlank
    private String tipo;

    @NotBlank
    private String descricao;

    @NotBlank
    private String data;

    @NotBlank
    private BigDecimal valorTotal;

    @NotBlank
    private String formaPagamento;

    private Long qtdParcelas;

    private BigDecimal precoParcela;

    private String observacoes;

    public VendaDTO(String id, String tipo, String descricao, LocalDateTime data, BigDecimal valorTotal, String formaPagamento, Long qtdParcelas, BigDecimal precoParcela, String observacoes) {
        this.id = id;
        this.tipo = tipo;
        this.descricao = descricao;
        this.data = DateConverter.localDateTimeToStringTime(data);
        this.valorTotal = valorTotal;
        this.formaPagamento = formaPagamento;
        this.qtdParcelas = qtdParcelas;
        this.precoParcela = precoParcela;
        this.observacoes = observacoes;
    }
}
