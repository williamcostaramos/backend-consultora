package br.com.williamramos.consultora.api.controller;

import br.com.williamramos.consultora.api.domain.converter.Converter;
import br.com.williamramos.consultora.api.domain.dto.CategoriaDTO;
import br.com.williamramos.consultora.api.domain.input.CategoriaInput;
import br.com.williamramos.consultora.domain.model.Categoria;
import br.com.williamramos.consultora.domain.service.Servico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.Collection;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
    @Autowired
    private Servico<Categoria> service;

    @Autowired
    private Converter<Categoria, CategoriaDTO> converter;

    @GetMapping
    public Page<CategoriaDTO> listar(Pageable pageable) {
        Page<Categoria> categoriaPage = service.listar(pageable);
        Collection<CategoriaDTO> dtos = converter.list(categoriaPage.getContent());
        return new PageImpl<>(Arrays.asList(dtos.toArray(new CategoriaDTO[0])), pageable, categoriaPage.getTotalElements());

    }

    @GetMapping("/{id}")
    public CategoriaDTO buscar(@PathVariable Long id) {
        return converter.toDTO(service.buscar(id));
    }

    @PostMapping
    public CategoriaDTO salvar(@RequestBody @Valid CategoriaInput input) {
        Categoria categoria = converter.inputToDomain(input);
        return converter.toDTO(service.salvar(categoria));

    }

}
