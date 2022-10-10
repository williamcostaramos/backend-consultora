package br.com.williamramos.consultora.api.domain.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public interface Converter<T, K> {
    K toDTO(T entity);

    T DTOToDomain(K dto);

    T inputToDomain(Object input);

    Collection<K> list(Collection<T> list);

    void copy(Object input, Object output);
}
