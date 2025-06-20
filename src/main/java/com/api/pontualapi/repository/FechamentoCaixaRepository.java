package com.api.pontualapi.repository;

import com.api.pontualapi.dto.FechamentoCaixasDTO;
import com.api.pontualapi.model.FechamentoCaixa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FechamentoCaixaRepository extends JpaRepository<FechamentoCaixa, String> {

    @Query("SELECT fechamentoCaixa FROM FechamentoCaixa fechamentoCaixa WHERE to_char(fechamentoCaixa.data, 'YYYY-MM-DD') = :data")
    FechamentoCaixa getByData(String data);

    @Query("SELECT NEW com.api.pontualapi.dto.FechamentoCaixasDTO(" +
            "fechamentoCaixa.id, fechamentoCaixa.data, fechamentoCaixa.totalVenda, fechamentoCaixa.totalServico, fechamentoCaixa.totalOrdemServico, fechamentoCaixa.valorTotal) " +
            "FROM FechamentoCaixa fechamentoCaixa " +
            "WHERE (to_char(fechamentoCaixa.data, 'DD/MM/YYYY') LIKE concat('%', lower(:filter), '%') OR :filter IS NULL)")
    Page<FechamentoCaixasDTO> buscarTodos(String filter, Pageable pageable);
}
