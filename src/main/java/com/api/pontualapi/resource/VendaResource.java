package com.api.pontualapi.resource;

import com.api.pontualapi.dto.FilterDTO;
import com.api.pontualapi.dto.OrdemServicoDTO;
import com.api.pontualapi.dto.VendaDTO;
import com.api.pontualapi.service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
