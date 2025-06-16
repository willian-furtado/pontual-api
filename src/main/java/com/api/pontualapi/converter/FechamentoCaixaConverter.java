package com.api.pontualapi.converter;

import com.api.pontualapi.dto.FechamentoCaixaDTO;
import com.api.pontualapi.model.FechamentoCaixa;
import com.api.pontualapi.utils.DateConverter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@Service
public class FechamentoCaixaConverter {

    public FechamentoCaixa toEntity(FechamentoCaixaDTO fechamentoCaixaDTO){
        FechamentoCaixa fechamentoCaixa = new FechamentoCaixa();

        fechamentoCaixa.setData(LocalDate.parse(fechamentoCaixaDTO.getData()));
        fechamentoCaixa.setTotalVenda(fechamentoCaixaDTO.getTotalVenda());
        fechamentoCaixa.setTotalServico(fechamentoCaixaDTO.getTotalServico());
        fechamentoCaixa.setTotalOrdemServico(fechamentoCaixaDTO.getTotalOrdemServico());
        fechamentoCaixa.setValorTotal(fechamentoCaixaDTO.getValorTotalFechamento());
        return fechamentoCaixa;
    }

    public FechamentoCaixaDTO toDTO(FechamentoCaixa fechamentoCaixa) {
        FechamentoCaixaDTO fechamentoCaixaDTO = new FechamentoCaixaDTO();

        fechamentoCaixaDTO.setId(fechamentoCaixa.getId());
        fechamentoCaixaDTO.setData(DateConverter.localDateToStringTime(fechamentoCaixa.getData()));
        fechamentoCaixaDTO.setTotalVenda(fechamentoCaixa.getTotalVenda());
        fechamentoCaixaDTO.setTotalServico(fechamentoCaixa.getTotalServico());
        fechamentoCaixaDTO.setTotalOrdemServico(fechamentoCaixa.getTotalOrdemServico());
        fechamentoCaixaDTO.setValorTotalFechamento(fechamentoCaixa.getValorTotal());
        return fechamentoCaixaDTO;
    }
}
