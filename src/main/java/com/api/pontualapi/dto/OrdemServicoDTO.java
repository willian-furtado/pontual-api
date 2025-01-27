package com.api.pontualapi.dto;

import com.api.pontualapi.converter.ClienteConverter;
import com.api.pontualapi.model.Cliente;
import com.api.pontualapi.utils.DateConverter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter @Setter
@NoArgsConstructor
public class OrdemServicoDTO {

    private String id;

    @NotBlank
    private String codigo;

    @NotBlank
    private ClienteDTO cliente;

    @NotBlank
    private String servico;

    @NotBlank
    private String dataOrcamento;

    @NotBlank
    private String dataEntrega;

    @NotBlank
    private BigDecimal valorServico;

    @NotBlank
    private String status;

    @NotBlank
    private String statusPagamento;

    @NotBlank
    private String formaPagamento;

    private Long qtdParcelas;

    private BigDecimal valorParcela;

    private String observacao;

    public OrdemServicoDTO(String id, String codigoIdentificador, Cliente cliente, String servico, LocalDate dataOrcamento, LocalDate dataEntrega, BigDecimal valor, String statusServico, String statusPagamento, String formaPagamento, Long qtdParcelas, BigDecimal valorParcela, String observacao) {
        this.id = id;
        this.codigo = codigoIdentificador;
        this.cliente = new ClienteConverter().converterDTO(cliente);
        this.servico = servico;
        this.dataOrcamento = DateConverter.localDateToString(dataOrcamento);
        this.dataEntrega = DateConverter.localDateToString(dataEntrega);
        this.valorServico = valor;
        this.status = statusServico;
        this.statusPagamento = statusPagamento;
        this.formaPagamento = formaPagamento;
        this.qtdParcelas = qtdParcelas;
        this.valorParcela = valorParcela;
        this.observacao = observacao;
    }
}
