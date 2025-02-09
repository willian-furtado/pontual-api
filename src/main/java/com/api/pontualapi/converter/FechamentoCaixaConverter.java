package com.api.pontualapi.converter;

import com.api.pontualapi.dto.FechamentoCaixaDTO;
import com.api.pontualapi.model.FechamentoCaixa;
import com.api.pontualapi.utils.DateConverter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
@AllArgsConstructor
@Service
public class FechamentoCaixaConverter {

    public FechamentoCaixa toEntity(FechamentoCaixaDTO fechamentoCaixaDTO){
        FechamentoCaixa fechamentoCaixa = new FechamentoCaixa();

        fechamentoCaixa.setData(DateConverter.stringToLocalDateTime(fechamentoCaixaDTO.getData()));
        fechamentoCaixa.setValorTotal(fechamentoCaixaDTO.getTotal());
        return fechamentoCaixa;
    }

    public FechamentoCaixaDTO toDTO(FechamentoCaixa fechamentoCaixa) {
        FechamentoCaixaDTO fechamentoCaixaDTO = new FechamentoCaixaDTO();

        fechamentoCaixaDTO.setId(fechamentoCaixa.getId());
        fechamentoCaixaDTO.setData(DateConverter.localDateTimeToStringTime(fechamentoCaixa.getData()));
        fechamentoCaixa.setValorTotal(fechamentoCaixa.getValorTotal());
        return fechamentoCaixaDTO;
    }
}
