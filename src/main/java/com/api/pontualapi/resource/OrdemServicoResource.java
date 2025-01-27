package com.api.pontualapi.resource;

import com.api.pontualapi.dto.FilterDTO;
import com.api.pontualapi.dto.OrdemServicoDTO;
import com.api.pontualapi.service.OrdemServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/ordemServico")
@CrossOrigin("http://localhost:4200")
public class OrdemServicoResource {

    @Autowired
    private OrdemServicoService ordemServicoService;

    @PostMapping("/listarTodos")
    public ResponseEntity<Page<OrdemServicoDTO>> listarTodos(@RequestBody FilterDTO filtro, Pageable pageable) {
        Page<OrdemServicoDTO> todosClientes = ordemServicoService.findAllPage(pageable, filtro);
        return new ResponseEntity<>(todosClientes, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Void> save(@Valid @RequestBody OrdemServicoDTO ordemServicoDTO) {
        ordemServicoService.save(ordemServicoDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<Void> update(@Valid @RequestBody OrdemServicoDTO ordemServicoDTO) {
        ordemServicoService.update(ordemServicoDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") String id) {
        ordemServicoService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/deleteAllById")
    public ResponseEntity<?> deleteAll(@Valid @RequestBody List<String> id) {
        ordemServicoService.deleteAll(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
