package br.com.williamramos.consultora.api.exception;

public enum TypeProblem {
    RECURSO_NAO_ENCONTRADO("recurso-nao-encontrado", "Recurso não encontrado"),
    ENTIDADE_EM_USO("entidade-em-uso", "Entidade em uso"),
    DADOS_INVALIDOS("dados-invalidos", "Dados inválidos"),
    MENSAGEM_INCOMPREENSIVEL("mensagem-incompreensivel", "Mensagem Incompreensivel"),
    TAMANHO_ARQUIVO_EXCEDIDO("tamanho-arquivo-excedido", "Tamanho Maximo Excedido"),
    USUARIO_NAO_AUTENTICADO("usuario-nao-autenticado", "Usuario não Autenticado"),
    ERROR_SISTEMA("erro-sistema", "erro de sistema");

    private String url;
    private String descricao;

    TypeProblem(String path, String descricao) {
        this.url = "127.0.0.1/" + path;
        this.descricao = descricao;
    }

    public String getUrl() {
        return url;
    }

    public String getDescricao() {
        return descricao;
    }
}
