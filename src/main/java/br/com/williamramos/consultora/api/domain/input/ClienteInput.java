package br.com.williamramos.consultora.api.domain.input;

import br.com.williamramos.consultora.core.validation.ValidarCPF;
import br.com.williamramos.consultora.domain.enuns.EstadoCivil;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class ClienteInput {
    @NotBlank
    private String nome;
    @ValidarCPF()
    private String cpf;
    @NotNull
    private LocalDate dataNascimento;
    @NotNull
    private EstadoCivil estadoCivil;
    private Boolean hasFilhos;
    private Integer qtdFilhos;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public Boolean getHasFilhos() {
        return hasFilhos;
    }

    public void setHasFilhos(Boolean hasFilhos) {
        this.hasFilhos = hasFilhos;
    }

    public Integer getQtdFilhos() {
        return qtdFilhos;
    }

    public void setQtdFilhos(Integer qtdFilhos) {
        this.qtdFilhos = qtdFilhos;
    }
}
