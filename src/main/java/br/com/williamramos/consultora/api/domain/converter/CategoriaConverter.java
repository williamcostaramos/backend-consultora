package br.com.williamramos.consultora.api.domain.converter;

import br.com.williamramos.consultora.api.domain.dto.CategoriaDTO;
import br.com.williamramos.consultora.domain.model.Categoria;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.Collectors;
@Component
public class CategoriaConverter implements Converter<Categoria, CategoriaDTO> {
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CategoriaDTO toDTO(Categoria entity) {
        return modelMapper.map(entity, CategoriaDTO.class);
    }

    @Override
    public Categoria DTOToDomain(CategoriaDTO dto) {
        return modelMapper.map(dto, Categoria.class);
    }

    @Override
    public Categoria inputToDomain(Object input) {
        return modelMapper.map(input, Categoria.class);
    }

    @Override
    public Collection<CategoriaDTO> list(Collection<Categoria> list) {
        return list.stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Override
    public void copy(Object input, Object output) {
        modelMapper.map(input, output);
    }


}
