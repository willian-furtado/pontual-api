package com.api.pontualapi.converter;

import com.api.pontualapi.dto.ClienteDTO;
import com.api.pontualapi.model.Cliente;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
@AllArgsConstructor
@Service
public class ClienteConverter {

    public Cliente converterToEntity(ClienteDTO clienteDTO){
        Cliente cliente = new Cliente();
        cliente.setNome(clienteDTO.getNome());
        cliente.setSobrenome(clienteDTO.getSobrenome());
        cliente.setCelular(clienteDTO.getCelular());
        cliente.setFixo(clienteDTO.getFixo() != null ? clienteDTO.getFixo() : null);
        cliente.setCpf(clienteDTO.getCpf());
        cliente.setEmail(clienteDTO.getEmail());
        return cliente;
    }

    public ClienteDTO converterDTO(Cliente cliente){
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setId(cliente.getId());
        clienteDTO.setNome(cliente.getNome());
        clienteDTO.setSobrenome(cliente.getSobrenome());
        clienteDTO.setCpf(cliente.getCpf());
        clienteDTO.setCelular(cliente.getCelular());
        clienteDTO.setFixo(cliente.getFixo() != null ? cliente.getFixo() : null);
        clienteDTO.setEmail(cliente.getEmail());
        return clienteDTO;
    }
}
