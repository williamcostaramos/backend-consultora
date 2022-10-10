package br.com.williamramos.consultora.api.controller;

import br.com.williamramos.consultora.api.domain.converter.Converter;
import br.com.williamramos.consultora.api.domain.dto.CategoriaDTO;
import br.com.williamramos.consultora.api.domain.dto.ClienteDTO;
import br.com.williamramos.consultora.api.domain.input.CategoriaInput;
import br.com.williamramos.consultora.api.domain.input.ClienteInput;
import br.com.williamramos.consultora.domain.model.Categoria;
import br.com.williamramos.consultora.domain.model.Cliente;
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
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private Servico<Cliente> service;
    @Autowired
    Converter<Cliente, ClienteDTO> converter;

    @GetMapping
    public Page<ClienteDTO> listar(Pageable pageable) {
        Page<Cliente> categoriaPage = service.listar(pageable);
        Collection<ClienteDTO> dtos = converter.list(categoriaPage.getContent());
        return new PageImpl<>(Arrays.asList(dtos.toArray(new ClienteDTO[0])), pageable, categoriaPage.getTotalElements());

    }

    @GetMapping("/{id}")
    public ClienteDTO buscar(@PathVariable Long id) {
        return converter.toDTO(service.buscar(id));
    }

    @PostMapping
    public ClienteDTO salvar(@RequestBody @Valid ClienteInput input) {
        Cliente cliente = converter.inputToDomain(input);
        return converter.toDTO(service.salvar(cliente));

    }

}
