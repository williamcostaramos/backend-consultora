package br.com.williamramos.consultora.domain.exception;

public class EntidadeNaoEncontradaException extends RuntimeException {
    public EntidadeNaoEncontradaException(String s) {
        super(s);
    }

    public EntidadeNaoEncontradaException(String s, Throwable throwable) {
        super(s, throwable);
    }
}
