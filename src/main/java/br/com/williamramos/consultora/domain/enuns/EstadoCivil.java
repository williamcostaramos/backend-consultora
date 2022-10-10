package br.com.williamramos.consultora.domain.enuns;

public enum EstadoCivil {
    SOLTEIRO("Solteiro"),
    CASADO("Casado"),
    UNIAO_ESTAVEL("União Estavel"),
    DIVORCIADO("Divorciado"),
    VIUVO("Viúvo");

    private String descricao;

    EstadoCivil(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
