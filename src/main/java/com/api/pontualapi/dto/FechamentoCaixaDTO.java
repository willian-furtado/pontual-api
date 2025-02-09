package com.api.pontualapi.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class FechamentoCaixaDTO {

    private String id;

    @NotBlank
    private String data;

    @NotBlank
    private BigDecimal total;
}
