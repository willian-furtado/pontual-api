package com.api.pontualapi.resource;

import com.api.pontualapi.dto.FechamentoCalculoDTO;
import com.api.pontualapi.service.FinanceiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/fechamento-caixa")
@CrossOrigin("http://localhost:4200")
public class FinanceiroResource {

    @Autowired
    private FinanceiroService financeiroService;

    @GetMapping("/{data}")
    public ResponseEntity<FechamentoCalculoDTO> calcular(@Valid @PathVariable("data") String data) {
        return new ResponseEntity<>(financeiroService.calcular(data), HttpStatus.OK);
    }
}
