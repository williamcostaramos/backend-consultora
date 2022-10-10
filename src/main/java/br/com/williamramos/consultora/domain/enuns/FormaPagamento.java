package br.com.williamramos.consultora.domain.enuns;

public enum FormaPagamento {
    CARTAO_CREDITO("Cartão Credito"),
    CARTAO_DEBITO("Cartão Debito"),
    PIX("Pix"),
    BOLETO("Boleto"),
    DINHEIRO("Dinheiro");

    private String descricao;

    FormaPagamento(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
