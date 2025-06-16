package com.api.pontualapi.service;

import com.api.pontualapi.converter.FechamentoCaixaConverter;
import com.api.pontualapi.dto.FechamentoCaixaDTO;
import com.api.pontualapi.dto.FechamentoCalculoDTO;
import com.api.pontualapi.dto.FechamentoCalculoTipoPagamento;
import com.api.pontualapi.dto.TotalDTO;
import com.api.pontualapi.model.FechamentoCaixa;
import com.api.pontualapi.model.OrdemServico;
import com.api.pontualapi.model.Venda;
import com.api.pontualapi.repository.FechamentoCaixaRepository;
import com.api.pontualapi.repository.OrdemServicoRepository;
import com.api.pontualapi.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class FinanceiroService {

    @Autowired
    private VendaRepository vendaRepository;

    @Autowired
    private FechamentoCaixaConverter converter;

    @Autowired
    private OrdemServicoRepository ordemServicoRepository;

    @Autowired
    private FechamentoCaixaRepository fechamentoCaixaRepository;

    public static final String VENDA = "VENDA";
    public static final String SERVICO = "SERVIÇO";
    public static final String PAGO = "PAGO";

    public FechamentoCalculoDTO calcular(String data) {
        List<Venda> vendas = vendaRepository.findByData(data);
        List<OrdemServico> ordensServicoPagas = buscarOrdensServicoPagas(data);

        Map<String, List<Venda>> vendasPorPagamento = agruparVendasPorFormaPagamento(vendas);
        List<FechamentoCalculoTipoPagamento> tipoPagamentos = calcularPorTipoPagamento(vendasPorPagamento, ordensServicoPagas);
        TotalDTO totalDTO = calcularTotais(tipoPagamentos);

        return criarFechamentoCalculoDTO(tipoPagamentos, totalDTO);
    }

    private List<OrdemServico> buscarOrdensServicoPagas(String data) {
        return ordemServicoRepository.findByStatusPagamentoAndData(PAGO, data);
    }

    private Map<String, List<Venda>> agruparVendasPorFormaPagamento(List<Venda> vendas) {
        return vendas.stream().collect(Collectors.groupingBy(Venda::getFormaPagamento));
    }

    private List<FechamentoCalculoTipoPagamento> calcularPorTipoPagamento(
            Map<String, List<Venda>> vendasPorPagamento,
            List<OrdemServico> ordensServicoPagas) {

        List<FechamentoCalculoTipoPagamento> tipoPagamentos = new ArrayList<>();
        List<String> metodosPagamento = List.of("Dinheiro", "Débito", "Crédito", "Pix");

        for (String metodoPagamento : metodosPagamento) {
            List<Venda> vendasMetodo = vendasPorPagamento.getOrDefault(metodoPagamento, new ArrayList<>());

            BigDecimal totalVenda = calcularTotalPorTipo(vendasMetodo, VENDA);
            BigDecimal totalServico = calcularTotalPorTipo(vendasMetodo, SERVICO);

            BigDecimal totalOrdemServico = ordensServicoPagas.stream()
                    .filter(o -> metodoPagamento.equalsIgnoreCase(o.getFormaPagamento()))
                    .map(OrdemServico::getPreco)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);

            FechamentoCalculoTipoPagamento tipoPagamento = new FechamentoCalculoTipoPagamento();
            tipoPagamento.setMetodoPagamento(metodoPagamento);
            tipoPagamento.setTotalVenda(totalVenda);
            tipoPagamento.setTotalServico(totalServico);
            tipoPagamento.setTotalOrdemServico(totalOrdemServico);

            tipoPagamentos.add(tipoPagamento);
        }

        return tipoPagamentos;
    }

    private BigDecimal calcularTotalPorTipo(List<Venda> vendas, String tipo) {
        return vendas.stream()
                .filter(v -> tipo.equalsIgnoreCase(v.getTipo()))
                .map(Venda::getValorTotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private TotalDTO calcularTotais(List<FechamentoCalculoTipoPagamento> tipoPagamentos) {
        BigDecimal totalVendaGeral = tipoPagamentos.stream()
                .map(FechamentoCalculoTipoPagamento::getTotalVenda)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal totalServicoGeral = tipoPagamentos.stream()
                .map(FechamentoCalculoTipoPagamento::getTotalServico)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal totalOrdemServicoGeral = tipoPagamentos.stream()
                .map(FechamentoCalculoTipoPagamento::getTotalOrdemServico)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal valorTotalFechamento = totalVendaGeral.add(totalServicoGeral).add(totalOrdemServicoGeral);

        TotalDTO totalDTO = new TotalDTO();
        totalDTO.setTotalVenda(totalVendaGeral);
        totalDTO.setTotalServico(totalServicoGeral);
        totalDTO.setTotalOrdemServico(totalOrdemServicoGeral);
        totalDTO.setValorTotalFechamento(valorTotalFechamento);

        return totalDTO;
    }

    private FechamentoCalculoDTO criarFechamentoCalculoDTO(List<FechamentoCalculoTipoPagamento> tipoPagamentos, TotalDTO totalDTO) {
        FechamentoCalculoDTO fechamento = new FechamentoCalculoDTO();
        fechamento.setTipoPagamentos(tipoPagamentos);
        fechamento.setTotal(totalDTO);

        return fechamento;
    }

    public void save(FechamentoCaixaDTO fechamentoCaixaDTO) {
        FechamentoCaixa fechamentoCaixa = fechamentoCaixaRepository.getByData(LocalDate.now().toString());
        if (!Objects.isNull(fechamentoCaixa)) {
            fechamentoCaixa.setValorTotal(fechamentoCaixaDTO.getValorTotalFechamento());
            fechamentoCaixa.setTotalServico(fechamentoCaixaDTO.getTotalServico());
            fechamentoCaixa.setTotalVenda(fechamentoCaixaDTO.getTotalVenda());
            fechamentoCaixa.setTotalOrdemServico(fechamentoCaixaDTO.getTotalOrdemServico());
        }
        fechamentoCaixaRepository.save(fechamentoCaixa);
    }

    public void update(FechamentoCaixaDTO fechamentoCaixaDTO) {
        FechamentoCaixa fechamentoCaixa = fechamentoCaixaRepository.findById(fechamentoCaixaDTO.getId()).orElseThrow(null);
        if (Objects.isNull(fechamentoCaixa)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Fechamento de caixa não encontrado.");
        }
        fechamentoCaixaRepository.save(converter.toEntity(fechamentoCaixaDTO));
    }

    public void delete(String id) {
        FechamentoCaixa fechamentoCaixa = fechamentoCaixaRepository.findById(id).orElseThrow(null);
        if (Objects.isNull(fechamentoCaixa)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Fechamento de caixa não encontrado.");
        }
        fechamentoCaixaRepository.deleteById(id);
    }

    public void deleteAll(List<String> ids) {
        fechamentoCaixaRepository.deleteAllById(ids);
    }

    public FechamentoCaixaDTO getByData(String data) {
        FechamentoCaixa fechamentoCaixa = fechamentoCaixaRepository.getByData(data);

        if (Objects.isNull(fechamentoCaixa)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Fechamento de caixa não encontrado.");
        }
        return converter.toDTO(fechamentoCaixa);
    }
}
