package br.com.williamramos.consultora.domain.exception;

public class ClienteNaoEncontradoException extends EntidadeNaoEncontradaException {
    private final static String MSG="Cliente não Encontrado";
    private final static String MSG_ID="Cliente de codigo id: %d não encontrado";

    public ClienteNaoEncontradoException() {
        super(MSG);
    }

    public ClienteNaoEncontradoException(String s) {
        super(String.format(MSG));
    }

    public ClienteNaoEncontradoException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public ClienteNaoEncontradoException(Long id) {
        super(String.format(MSG_ID, id));
    }
}
