package com.api.pontualapi.service;

import com.api.pontualapi.converter.OrdemServicoConverter;
import com.api.pontualapi.dto.FilterDTO;
import com.api.pontualapi.dto.OrdemServicoDTO;
import com.api.pontualapi.model.OrdemServico;
import com.api.pontualapi.repository.OrdemServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;

@Service
public class OrdemServicoService {

    @Autowired
    private OrdemServicoRepository ordemServicoRepository;

    @Autowired
    private OrdemServicoConverter ordemServicoConverter;


    public Page<OrdemServicoDTO> findAllPage(Pageable pageable, FilterDTO filtro) {
        return ordemServicoRepository.buscarTodos(filtro.getFilter(), pageable);
    }

    public void save(OrdemServicoDTO ordemServicoDTO) {
        if (ordemServicoExiste(ordemServicoDTO.getCodigo())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Ordem de Serviço " + ordemServicoDTO.getCodigo() + " já existe.");
        }
        ordemServicoRepository.save(ordemServicoConverter.converterToEntity(ordemServicoDTO));
    }

    public void update(OrdemServicoDTO ordemServicoDTO) {
        OrdemServico ordemServico = ordemServicoRepository.findById(ordemServicoDTO.getId()).orElseThrow(null);
        if (Objects.isNull(ordemServico)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Ordem de Serviço não encontrada.");
        }
        ordemServicoRepository.save(ordemServicoConverter.converterToEntity(ordemServicoDTO));
    }

    private Boolean ordemServicoExiste(String codigo) {
        return ordemServicoRepository.existsOrdemServicoByCodigoIdentificador(codigo);
    }

    public void delete(String id) {
        OrdemServico ordemServico = ordemServicoRepository.findById(id).orElseThrow(null);
        if (!Objects.isNull(ordemServico)) {
            ordemServicoRepository.delete(ordemServico);
        }
    }

    public void deleteAll(List<String> ids) {
        ordemServicoRepository.deleteAllById(ids);
    }
}
