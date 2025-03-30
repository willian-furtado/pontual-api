package com.api.pontualapi.service;

import com.api.pontualapi.converter.VendaConverter;
import com.api.pontualapi.dto.*;
import com.api.pontualapi.repository.OrdemServicoRepository;
import com.api.pontualapi.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.*;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;

    @Autowired
    private OrdemServicoRepository ordemServicoRepository;

    @Autowired
    private VendaConverter converter;

    public Page<VendaDTO> findAllPage(Pageable pageable, FilterDTO filtro) {
        return vendaRepository.buscarTodos(filtro.getFilter(), pageable);
    }

    public void save(VendaDTO vendaDTO) {
        vendaRepository.save(converter.convertToEntity(vendaDTO));
    }

    public void update(VendaDTO vendaDTO) {
        vendaRepository.findById(vendaDTO.getId()).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Venda não encontrada."));
        vendaRepository.save(converter.convertToEntity(vendaDTO));
    }

    public void delete(String id) {
        vendaRepository.findById(id).ifPresent(vendaRepository::delete);
    }

    public void deleteAll(List<String> ids) {
        vendaRepository.deleteAllById(ids);
    }

    public Page<UltimasVendasDTO> buscarUltimasVendas(Pageable pageable) {
        return vendaRepository.buscarUltimasVendas(pageable);
    }

    public GraficoVendasDTO obterDadosGrafico() {
        List<Object[]> vendasResultados = vendaRepository.obterVendasPorMes();
        List<Object[]> ordensServicoResultados = ordemServicoRepository.obterOrdensServicoPorMes();

        Map<Integer, BigDecimal> vendasPorMes = processarVendas(vendasResultados);
        Map<Integer, BigDecimal> ordensServicoPorMes = processarOrdensServico(ordensServicoResultados);
        Map<Integer, BigDecimal> servicosPorMes = extrairServicos(vendasResultados);
        Map<Integer, BigDecimal> totalGeralPorMes = calcularTotalGeral(vendasPorMes, servicosPorMes, ordensServicoPorMes);

        return construirGrafico(vendasPorMes, servicosPorMes, ordensServicoPorMes, totalGeralPorMes);
    }

    private Map<Integer, BigDecimal> processarVendas(List<Object[]> resultados) {
        Map<Integer, BigDecimal> vendasPorMes = new HashMap<>();
        for (Object[] row : resultados) {
            Integer mes = ((Number) row[0]).intValue();
            String tipo = (String) row[1];
            BigDecimal valor = (BigDecimal) row[2];

            if ("venda".equalsIgnoreCase(tipo)) {
                vendasPorMes.put(mes, vendasPorMes.getOrDefault(mes, BigDecimal.ZERO).add(valor));
            }
        }
        return vendasPorMes;
    }

    private Map<Integer, BigDecimal> extrairServicos(List<Object[]> resultados) {
        Map<Integer, BigDecimal> servicosPorMes = new HashMap<>();
        for (Object[] row : resultados) {
            Integer mes = ((Number) row[0]).intValue();
            String tipo = (String) row[1];
            BigDecimal valor = (BigDecimal) row[2];

            if ("serviço".equalsIgnoreCase(tipo)) {
                servicosPorMes.put(mes, servicosPorMes.getOrDefault(mes, BigDecimal.ZERO).add(valor));
            }
        }
        return servicosPorMes;
    }

    private Map<Integer, BigDecimal> processarOrdensServico(List<Object[]> resultados) {
        Map<Integer, BigDecimal> ordensServicoPorMes = new HashMap<>();
        for (Object[] row : resultados) {
            Integer mes = ((Number) row[0]).intValue();
            BigDecimal valor = (BigDecimal) row[1];
            ordensServicoPorMes.put(mes, ordensServicoPorMes.getOrDefault(mes, BigDecimal.ZERO).add(valor));
        }
        return ordensServicoPorMes;
    }

    private Map<Integer, BigDecimal> calcularTotalGeral(Map<Integer, BigDecimal> vendas, Map<Integer, BigDecimal> servicos, Map<Integer, BigDecimal> ordensServico) {
        Map<Integer, BigDecimal> totalPorMes = new HashMap<>();
        Set<Integer> meses = new HashSet<>();
        meses.addAll(vendas.keySet());
        meses.addAll(servicos.keySet());
        meses.addAll(ordensServico.keySet());

        for (Integer mes : meses) {
            totalPorMes.put(mes, vendas.getOrDefault(mes, BigDecimal.ZERO)
                    .add(servicos.getOrDefault(mes, BigDecimal.ZERO))
                    .add(ordensServico.getOrDefault(mes, BigDecimal.ZERO)));
        }
        return totalPorMes;
    }

    private GraficoVendasDTO construirGrafico(Map<Integer, BigDecimal> vendas, Map<Integer, BigDecimal> servicos, Map<Integer, BigDecimal> ordensServico, Map<Integer, BigDecimal> totalGeral) {
        List<String> labels = new ArrayList<>();
        List<BigDecimal> vendasValores = new ArrayList<>();
        List<BigDecimal> servicosValores = new ArrayList<>();
        List<BigDecimal> ordensServicoValores = new ArrayList<>();
        List<BigDecimal> totalValores = new ArrayList<>();

        List<Integer> mesesOrdenados = new ArrayList<>(vendas.keySet());
        mesesOrdenados.addAll(servicos.keySet());
        mesesOrdenados.addAll(ordensServico.keySet());
        mesesOrdenados = new ArrayList<>(new HashSet<>(mesesOrdenados));
        Collections.sort(mesesOrdenados);

        String[] mesesNomes = {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};

        for (Integer mes : mesesOrdenados) {
            labels.add(mesesNomes[mes - 1]);
            vendasValores.add(vendas.getOrDefault(mes, BigDecimal.ZERO));
            servicosValores.add(servicos.getOrDefault(mes, BigDecimal.ZERO));
            ordensServicoValores.add(ordensServico.getOrDefault(mes, BigDecimal.ZERO));
            totalValores.add(totalGeral.getOrDefault(mes, BigDecimal.ZERO));
        }

        return new GraficoVendasDTO(labels, vendasValores, servicosValores, ordensServicoValores, totalValores);
    }
}