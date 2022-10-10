package br.com.williamramos.consultora.domain.service;

import br.com.williamramos.consultora.domain.exception.CategoriaNaoEncontradaException;
import br.com.williamramos.consultora.domain.model.Categoria;
import br.com.williamramos.consultora.domain.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoriaService implements Servico<Categoria> {
    @Autowired
    private CategoriaRepository repository;


    public Categoria buscar(Long id) {
        return repository.findById(id).orElseThrow(() -> new CategoriaNaoEncontradaException(id));
    }

    public Page<Categoria> listar(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Transactional
    public Categoria salvar(Categoria categoria) {
        return repository.save(categoria);
    }

    @Transactional
    public void remover(Long id) {
        if (id != null) {
            repository.deleteById(id);
        }
    }
}
