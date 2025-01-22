package com.api.pontualapi.repository;

import com.api.pontualapi.dto.VendaDTO;
import com.api.pontualapi.model.Venda;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

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

}
