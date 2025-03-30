package com.api.pontualapi.dto;

import com.api.pontualapi.utils.DateConverter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class UltimasVendasDTO {

    private String id;

    @NotBlank
    private String descricao;

    @NotBlank
    private String data;

    @NotBlank
    private BigDecimal valorTotal;


    public UltimasVendasDTO(String id, String descricao, LocalDateTime data, BigDecimal valorTotal) {
        this.id = id;
        this.descricao = descricao;
        this.data = DateConverter.localDateTimeToStringTime(data);
        this.valorTotal = valorTotal;
    }
}
