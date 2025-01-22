package com.api.pontualapi.repository;

import com.api.pontualapi.dto.OrdemServicoDTO;
import com.api.pontualapi.model.OrdemServico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdemServicoRepository extends JpaRepository<OrdemServico, String> {
    Boolean existsOrdemServicoByCodigoIdentificador(String codigoIdentificador);

    @Query("SELECT NEW com.api.pontualapi.dto.OrdemServicoDTO(" +
            "ordemServico.id, ordemServico.codigoIdentificador, ordemServico.cliente, ordemServico.servico, ordemServico.dataOrcamento, ordemServico.dataEntrega, " +
            "ordemServico.preco, ordemServico.status, ordemServico.statusPagamento, ordemServico.formaPagamento, ordemServico.qdtParcelas, ordemServico.precoParcela, ordemServico.observacoes) " +
            "FROM OrdemServico ordemServico " +
            "WHERE (lower(ordemServico.codigoIdentificador) LIKE concat('%', lower(:filter), '%') OR :filter IS NULL) OR " +
            "(lower(ordemServico.servico) LIKE concat('%', lower(:filter), '%') OR :filter IS NULL) OR " +
            "(lower(ordemServico.status) LIKE concat('%', lower(:filter), '%') OR :filter IS NULL) OR " +
            "(to_char(ordemServico.dataOrcamento, 'DD/MM/YYYY') LIKE concat('%', lower(:filter), '%') OR :filter IS NULL) OR " +
            "(to_char(ordemServico.dataEntrega, 'DD/MM/YYYY') LIKE concat('%', lower(:filter), '%') OR :filter IS NULL) OR " +
            "(lower(ordemServico.cliente.nome) LIKE concat('%', lower(:filter), '%') OR :filter IS NULL)")
    Page<OrdemServicoDTO> buscarTodos(String filter, Pageable pageable);

    @Query("SELECT os FROM OrdemServico os " +
            "WHERE os.statusPagamento = :statusPagamento " +
            "AND to_char(os.dataEntrega, 'YYYY-MM-DD') = :dataEntrega")
    List<OrdemServico> findByStatusPagamentoAndDataEntrega(
            @Param("statusPagamento") String statusPagamento,
            @Param("dataEntrega") String dataEntrega);
}
