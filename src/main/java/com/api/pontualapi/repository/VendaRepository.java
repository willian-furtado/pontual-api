package com.api.pontualapi.repository;

import com.api.pontualapi.dto.UltimasVendasDTO;
import com.api.pontualapi.dto.VendaDTO;
import com.api.pontualapi.model.Venda;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface VendaRepository extends JpaRepository<Venda, String> {

    @Query("SELECT NEW com.api.pontualapi.dto.VendaDTO(" +
            "venda.id, venda.tipo, venda.descricao, venda.data, venda.valorTotal, venda.formaPagamento, " +
            "venda.qtdParcelas, venda.precoParcela, venda.observacoes) " +
            "FROM Venda venda " +
            "WHERE (lower(venda.tipo) LIKE concat('%', lower(:filter), '%') OR :filter IS NULL) OR " +
            "(lower(venda.descricao) LIKE concat('%', lower(:filter), '%') OR :filter IS NULL) OR " +
            "(lower(venda.observacoes) LIKE concat('%', lower(:filter), '%') OR :filter IS NULL) OR " +
            "(to_char(venda.data, 'DD/MM/YYYY') LIKE concat('%', lower(:filter), '%') OR :filter IS NULL) OR " +
            "(CAST(venda.valorTotal AS text) LIKE concat('%', :filter, '%') OR :filter IS NULL) OR " +
            "(lower(venda.formaPagamento) LIKE concat('%', lower(:filter), '%') OR :filter IS NULL)")
    Page<VendaDTO> buscarTodos(String filter, Pageable pageable);

    @Query("SELECT v FROM Venda v WHERE to_char(v.data, 'YYYY-MM-DD') = :data")
    List<Venda> findByData(String data);

    @Query("SELECT COALESCE(SUM(v.valorTotal), 0) FROM Venda v WHERE to_char(v.data, 'YYYY-MM-DD') = :data")
    BigDecimal calcularFaturamentoDoDia(String data);

    @Query("SELECT COALESCE(SUM(v.valorTotal), 0) FROM Venda v WHERE to_char(v.data, 'YYYY-MM-DD') BETWEEN :inicioSemana AND :fimSemana")
    BigDecimal calcularFaturamentoSemanal(@Param("inicioSemana") String inicioSemana, @Param("fimSemana") String fimSemana);

    @Query("SELECT COALESCE(SUM(v.valorTotal), 0) FROM Venda v WHERE to_char(v.data, 'YYYY-MM-DD') BETWEEN :inicioMes AND :fimMes")
    BigDecimal calcularFaturamentoMensal(@Param("inicioMes") String inicioMes, @Param("fimMes") String fimMes);

    @Query("SELECT NEW com.api.pontualapi.dto.UltimasVendasDTO(" +
            "venda.id, venda.descricao, venda.data, venda.valorTotal) " +
            "FROM Venda venda " +
            "WHERE venda.tipo = 'VENDA' " +
            "ORDER BY venda.data DESC")
    Page<UltimasVendasDTO> buscarUltimasVendas(Pageable pageable);

    @Query("SELECT FUNCTION('MONTH', v.data) AS mes, v.tipo, SUM(v.valorTotal) " +
            "FROM Venda v " +
            "GROUP BY FUNCTION('MONTH', v.data), v.tipo " +
            "ORDER BY mes")
    List<Object[]> obterVendasPorMes();

}
