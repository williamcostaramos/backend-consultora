package br.com.williamramos.consultora.domain.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface Servico<T> {
    T buscar(Long id);

    Page<T> listar(Pageable pageable);

    T salvar(T entity);

    void remover(Long id);

}
