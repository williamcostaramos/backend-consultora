package br.com.williamramos.consultora.domain.enuns;

public enum StatusPagamento {
    PAGO("Pago"),
    PAGO_PARCIAL("Pago Parcial"),
    EM_ATRASO("Em Atraso");

    private String descricao;

    StatusPagamento(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
