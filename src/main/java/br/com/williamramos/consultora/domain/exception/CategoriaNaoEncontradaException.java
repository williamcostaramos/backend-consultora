package br.com.williamramos.consultora.domain.exception;

public class CategoriaNaoEncontradaException extends EntidadeNaoEncontradaException {
    private final static String MSG="Categoria não Encontrada";
    private final static String MSG_ID="Categoria de codigo id: %d não encontrada";

    public CategoriaNaoEncontradaException() {
        super(MSG);
    }

    public CategoriaNaoEncontradaException(String s) {
        super(String.format(MSG));
    }

    public CategoriaNaoEncontradaException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public CategoriaNaoEncontradaException(Long id) {
        super(String.format(MSG_ID, id));
    }
}
