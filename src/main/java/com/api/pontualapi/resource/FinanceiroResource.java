package com.api.pontualapi.resource;

import com.api.pontualapi.dto.*;
import com.api.pontualapi.service.FinanceiroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping("/{data}")
    public ResponseEntity<Void> save(@PathVariable("data") String data, @Valid @RequestBody FechamentoCaixaDTO fechamentoCaixaDTO) {
        financeiroService.save(fechamentoCaixaDTO, data);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<Void> update(@Valid FechamentoCaixaDTO fechamentoCaixaDTO) {
        financeiroService.update(fechamentoCaixaDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") String id) {
        financeiroService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{data}/exists")
    public ResponseEntity<FechamentoCaixaDTO> getByData(@PathVariable("data") String data) {
        FechamentoCaixaDTO fechamentoCaixaDTO = financeiroService.getByData(data);
        return new ResponseEntity<>(fechamentoCaixaDTO, HttpStatus.OK);
    }

    @PostMapping("/delete-all")
    public ResponseEntity<?> deleteAll(@Valid @RequestBody List<String> id) {
        financeiroService.deleteAll(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/listar-todos")
    public ResponseEntity<Page<FechamentoCaixasDTO>> listarTodos(@RequestBody FilterDTO filtro, Pageable pageable) {
        Page<FechamentoCaixasDTO> fechamentoCaixa = financeiroService.findAllPage(pageable, filtro);
        return new ResponseEntity<>(fechamentoCaixa, HttpStatus.OK);
    }
}
