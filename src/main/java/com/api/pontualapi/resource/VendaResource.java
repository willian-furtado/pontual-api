package com.api.pontualapi.resource;

import com.api.pontualapi.dto.FilterDTO;
import com.api.pontualapi.dto.VendaDTO;
import com.api.pontualapi.service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/vendas")
@CrossOrigin("http://localhost:4200")
public class VendaResource {

    @Autowired
    private VendaService vendaService;

    @PostMapping("/listarTodos")
    public ResponseEntity<Page<VendaDTO>> listarTodos(@RequestBody FilterDTO filtro, Pageable pageable) {
        Page<VendaDTO> vendas = vendaService.findAllPage(pageable, filtro);
        return new ResponseEntity<>(vendas, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<VendaDTO> save(@Valid @RequestBody VendaDTO vendaDTO) {
        VendaDTO venda = vendaService.save(vendaDTO);
        return new ResponseEntity<>(venda, HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<VendaDTO> update(@Valid @RequestBody VendaDTO vendaDTO) {
        VendaDTO venda = vendaService.update(vendaDTO);
        return new ResponseEntity<>(venda, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") String id) {
        vendaService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/deleteAllById")
    public ResponseEntity<?> deleteAll(@Valid @RequestBody List<String> id) {
        vendaService.deleteAll(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
