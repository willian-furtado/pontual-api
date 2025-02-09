package com.api.pontualapi.repository;

import com.api.pontualapi.model.FechamentoCaixa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FechamentoCaixaRepository extends JpaRepository<FechamentoCaixa, String> {

    @Query("SELECT fechamentoCaixa FROM FechamentoCaixa fechamentoCaixa WHERE to_char(fechamentoCaixa.data, 'YYYY-MM-DD') = :data")
    FechamentoCaixa getByData(String data);

}
