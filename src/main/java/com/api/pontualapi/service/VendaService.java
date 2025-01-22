package com.api.pontualapi.service;

import com.api.pontualapi.converter.VendaConverter;
import com.api.pontualapi.dto.FilterDTO;
import com.api.pontualapi.dto.VendaDTO;
import com.api.pontualapi.model.Cliente;
import com.api.pontualapi.model.Venda;
import com.api.pontualapi.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;

    @Autowired
    private VendaConverter converter;

    public Page<VendaDTO> findAllPage(Pageable pageable, FilterDTO filtro) {
        return vendaRepository.buscarTodos(filtro.getFilter(), pageable);
    }

    public VendaDTO save(VendaDTO vendaDTO) {
        return converter.convertToDTO(vendaRepository.save(converter.convertToEntity(vendaDTO)));
    }

    public VendaDTO update(VendaDTO vendaDTO) {
        Venda venda = vendaRepository.findById(vendaDTO.getId()).orElseThrow(null);
        if (Objects.isNull(venda)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Venda não encontrada.");
        }
        return converter.convertToDTO(vendaRepository.save(converter.convertToEntity(vendaDTO)));
    }

    public void delete(String id) {
        Venda venda = vendaRepository.findById(id).orElse(null);

        if (!Objects.isNull(venda)) {
            vendaRepository.delete(venda);
        }
    }

    public void deleteAll(List<String> ids) {
        vendaRepository.deleteAllById(ids);
    }
}
