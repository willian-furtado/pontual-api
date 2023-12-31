package com.api.pontualapi.dto;

import com.api.pontualapi.enums.FormaPagamentoEnum;
import com.api.pontualapi.enums.TipoOperacaoEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.Date;
@Getter @Setter
@NoArgsConstructor
public class VendaServicoDTO {

    private Integer id;

    @NotBlank
    private Date data;

    @NotBlank
    private TipoOperacaoEnum tipoOperacao;

    @NotBlank
    private Long valorTotal;

    private Long valorCusto;

    @NotBlank
    private FormaPagamentoEnum formaPagamentoEnum;

    private Integer qtdParcelas;

    private Long valorParcela;

    public VendaServicoDTO(Integer id, Date data, TipoOperacaoEnum tipoOperacao, Long valorTotal, Long valorCusto, FormaPagamentoEnum formaPagamentoEnum, Integer qtdParcelas, Long valorParcela) {
        this.id = id;
        this.data = data;
        this.tipoOperacao = tipoOperacao;
        this.valorTotal = valorTotal;
        this.valorCusto = valorCusto;
        this.formaPagamentoEnum = formaPagamentoEnum;
        this.qtdParcelas = qtdParcelas;
        this.valorParcela = valorParcela;
    }
}
