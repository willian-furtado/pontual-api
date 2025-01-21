package com.api.pontualapi.converter;

import com.api.pontualapi.dto.OrdemServicoDTO;
import com.api.pontualapi.model.Cliente;
import com.api.pontualapi.model.OrdemServico;
import com.api.pontualapi.repository.ClienteRepository;
import com.api.pontualapi.utils.DateConverter;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class OrdemServicoConverter {

    @Autowired
    private ClienteConverter clienteConverter;

    @Autowired
    private ClienteRepository clienteRepository;

    public OrdemServico converterToEntity(OrdemServicoDTO servicoDTO) {
        OrdemServico servico = new OrdemServico();

        Cliente cliente = clienteRepository.getReferenceById(servicoDTO.getCliente().getId());

        servico.setId(servicoDTO.getId());
        servico.setCodigoIdentificador(servicoDTO.getCodigo());
        servico.setServico(servicoDTO.getServico());
        servico.setCliente(cliente);

        servico.setDataOrcamento(DateConverter.stringToLocalDate(servicoDTO.getDataOrcamento()));
        servico.setDataEntrega(DateConverter.stringToLocalDate(servicoDTO.getDataEntrega()));

        servico.setStatus(servicoDTO.getStatus());
        servico.setFormaPagamento(servicoDTO.getFormaPagamento());
        servico.setStatusPagamento(servicoDTO.getStatusPagamento());
        servico.setPreco(servicoDTO.getValorServico());
        servico.setQdtParcelas(servicoDTO.getQtdParcelas());
        servico.setPrecoParcela(servicoDTO.getValorParcela());
        servico.setObservacoes(servicoDTO.getObservacao());

        return servico;
    }

    public OrdemServicoDTO converterDTO(OrdemServico ordemServico) {
        OrdemServicoDTO servicoDTO = new OrdemServicoDTO();
        servicoDTO.setId(ordemServico.getId());
        servicoDTO.setCodigo(ordemServico.getCodigoIdentificador());
        servicoDTO.setServico(ordemServico.getServico());
        servicoDTO.setCliente(clienteConverter.converterDTO(ordemServico.getCliente()));

        servicoDTO.setDataOrcamento(DateConverter.localDateToString(ordemServico.getDataOrcamento()));
        servicoDTO.setDataEntrega(DateConverter.localDateToString(ordemServico.getDataEntrega()));

        servicoDTO.setStatus(ordemServico.getStatus());
        servicoDTO.setValorServico(ordemServico.getPreco());
        servicoDTO.setStatusPagamento(ordemServico.getStatusPagamento());
        servicoDTO.setFormaPagamento(ordemServico.getFormaPagamento());
        servicoDTO.setQtdParcelas(ordemServico.getQdtParcelas());
        servicoDTO.setValorParcela(ordemServico.getPrecoParcela());
        servicoDTO.setObservacao(ordemServico.getObservacoes());

        return servicoDTO;
    }
}
