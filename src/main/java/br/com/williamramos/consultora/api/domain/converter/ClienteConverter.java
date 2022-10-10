package br.com.williamramos.consultora.api.domain.converter;

import br.com.williamramos.consultora.api.domain.dto.ClienteDTO;
import br.com.williamramos.consultora.api.domain.input.ClienteInput;
import br.com.williamramos.consultora.domain.model.Cliente;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.Collectors;
@Component
public class ClienteConverter implements Converter<Cliente, ClienteDTO> {
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ClienteDTO toDTO(Cliente entity) {
        return modelMapper.map(entity, ClienteDTO.class);
    }

    @Override
    public Cliente DTOToDomain(ClienteDTO dto) {
        return modelMapper.map(dto, Cliente.class);
    }

    @Override
    public Cliente inputToDomain(Object input) {
        return modelMapper.map(input, Cliente.class);
    }

    @Override
    public Collection<ClienteDTO> list(Collection<Cliente> list) {
        return list.stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Override
    public void copy(Object input, Object output) {
        modelMapper.map(input, output);
    }


}
