package com.api.pontualapi.service;

import com.api.pontualapi.converter.VendaConverter;
import com.api.pontualapi.dto.FilterDTO;
import com.api.pontualapi.dto.VendaDTO;
import com.api.pontualapi.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;

    private VendaConverter converter;

    public Page<VendaDTO> findAllPage(Pageable pageable, FilterDTO filtro) {
        return vendaRepository.buscarTodos(filtro.getFilter(), pageable);
    }
}
