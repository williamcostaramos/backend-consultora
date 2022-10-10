package br.com.williamramos.consultora.domain.exception;

public class EntidadeEmUsoException extends RuntimeException {
    public EntidadeEmUsoException(String s) {
        super(s);
    }

    public EntidadeEmUsoException(String s, Throwable throwable) {
        super(s, throwable);
    }
}
