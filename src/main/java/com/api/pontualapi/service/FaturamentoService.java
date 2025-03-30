package com.api.pontualapi.service;

import com.api.pontualapi.dto.FaturamentoDTO;
import com.api.pontualapi.repository.OrdemServicoRepository;
import com.api.pontualapi.repository.VendaRepository;
import com.api.pontualapi.utils.DateConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;
@Service
public class FaturamentoService {

    @Autowired
    private VendaRepository vendaRepository;

    @Autowired
    private OrdemServicoRepository ordemServicoRepository;

    public FaturamentoDTO obterFaturamentoDoDia() {
        String dataHoje = DateConverter.localDateToStringTime(LocalDate.now());

        BigDecimal faturamentoVendas = vendaRepository.calcularFaturamentoDoDia(dataHoje);
        BigDecimal faturamentoServicos = ordemServicoRepository.calcularFaturamentoDoDia(dataHoje);

        BigDecimal faturamentoTotal = faturamentoVendas.add(faturamentoServicos);

        return new FaturamentoDTO(faturamentoTotal, "Atualizado em: " + DateConverter.localDateTimeToStringTime(LocalDateTime.now()));
    }

    public FaturamentoDTO obterFaturamentoSemanal() {
        LocalDate inicioSemana = LocalDate.now().with(DayOfWeek.MONDAY);
        LocalDate fimSemana = inicioSemana.plusDays(6);

        String inicioSemanaString = DateConverter.localDateToStringTime(inicioSemana);
        String fimSemanaString = DateConverter.localDateToStringTime(fimSemana);

        BigDecimal faturamentoVendas = vendaRepository.calcularFaturamentoSemanal(inicioSemanaString, fimSemanaString);
        BigDecimal faturamentoServicos = ordemServicoRepository.calcularFaturamentoSemanal(inicioSemanaString, fimSemanaString);

        BigDecimal faturamentoTotal = faturamentoVendas.add(faturamentoServicos);

        return new FaturamentoDTO(faturamentoTotal, "Período: " + DateConverter.localDateToString(inicioSemana) + " a " + DateConverter.localDateToString(fimSemana));
    }

    public FaturamentoDTO obterFaturamentoMensal() {
        LocalDate inicioMes = LocalDate.now().withDayOfMonth(1);
        LocalDate fimMes = LocalDate.now().with(TemporalAdjusters.lastDayOfMonth());

        String inicioMesString = DateConverter.localDateToStringTime(inicioMes);
        String fimMesString = DateConverter.localDateToStringTime(fimMes);

        BigDecimal faturamentoVendas = vendaRepository.calcularFaturamentoMensal(inicioMesString, fimMesString);
        BigDecimal faturamentoServicos = ordemServicoRepository.calcularFaturamentoMensal(inicioMesString, fimMesString);

        BigDecimal faturamentoTotal = faturamentoVendas.add(faturamentoServicos);

        return new FaturamentoDTO(faturamentoTotal, "Período: " + DateConverter.localDateToString(inicioMes) + " a " + DateConverter.localDateToString(fimMes));
    }
}
