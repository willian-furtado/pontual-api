package com.api.pontualapi.converter;

import com.api.pontualapi.dto.VendaDTO;
import com.api.pontualapi.model.Venda;
import com.api.pontualapi.utils.DateConverter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class VendaConverter {

    public Venda convertToEntity(VendaDTO vendaDTO) {
        Venda venda = new Venda();

        venda.setId(vendaDTO.getId());
        venda.setTipo(vendaDTO.getTipo());
        venda.setDescricao(vendaDTO.getDescricao());
        venda.setData(DateConverter.stringToLocalDateTime(vendaDTO.getData()));
        venda.setValorTotal(vendaDTO.getValorTotal());
        venda.setFormaPagamento(vendaDTO.getFormaPagamento());
        venda.setQtdParcelas(vendaDTO.getQtdParcelas());
        venda.setPrecoParcela(vendaDTO.getPrecoParcela());
        venda.setObservacoes(vendaDTO.getObservacoes());
        return venda;
    }

    public VendaDTO convertToDTO(Venda venda) {
        VendaDTO vendaDTO = new VendaDTO();

        vendaDTO.setId(venda.getId());
        vendaDTO.setTipo(venda.getTipo());
        vendaDTO.setDescricao(venda.getDescricao());
        vendaDTO.setData(DateConverter.localDateToStringTime(venda.getData()));
        vendaDTO.setValorTotal(venda.getValorTotal());
        vendaDTO.setFormaPagamento(venda.getFormaPagamento());
        vendaDTO.setQtdParcelas(venda.getQtdParcelas());
        vendaDTO.setPrecoParcela(venda.getPrecoParcela());
        vendaDTO.setObservacoes(venda.getObservacoes());

        return vendaDTO;
    }

}
