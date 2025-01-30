package com.api.pontualapi.resource;

import com.api.pontualapi.dto.FaturamentoDTO;
import com.api.pontualapi.service.FaturamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/faturamento")
@CrossOrigin("http://localhost:4200")
public class FaturamentoResource {

    @Autowired
    private FaturamentoService faturamentoService;

    @GetMapping("/hoje")
    public ResponseEntity<FaturamentoDTO> getFaturamentoDoDia() {
        FaturamentoDTO faturamento = faturamentoService.obterFaturamentoDoDia();
        return ResponseEntity.ok(faturamento);
    }

    @GetMapping("/semanal")
    public ResponseEntity<FaturamentoDTO> getFaturamentoSemanal() {
        FaturamentoDTO faturamento = faturamentoService.obterFaturamentoSemanal();
        return ResponseEntity.ok(faturamento);
    }

    @GetMapping("/mensal")
    public ResponseEntity<FaturamentoDTO> getFaturamentoMensal() {
        FaturamentoDTO faturamento = faturamentoService.obterFaturamentoMensal();
        return ResponseEntity.ok(faturamento);
    }
}