package br.com.williamramos.consultora.domain.service;

import br.com.williamramos.consultora.domain.exception.ClienteNaoEncontradoException;
import br.com.williamramos.consultora.domain.model.Cliente;
import br.com.williamramos.consultora.domain.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ClienteService implements Servico<Cliente> {
    @Autowired
    private ClienteRepository repository;

    @Override
    public Cliente buscar(Long id) {
        return repository.findById(id).orElseThrow(() -> new ClienteNaoEncontradoException(id));
    }

    @Override
    public Page<Cliente> listar(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Cliente salvar(Cliente entity) {
        return repository.save(entity);
    }

    @Override
    public void remover(Long id) {
        if (id != null) {
            repository.deleteById(id);
        }
    }
}
