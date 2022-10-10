package br.com.williamramos.consultora.domain.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Endereco {
    @Column(name = "endereco_logradouro")
    private String logradouro;
    @Column(name = "endereco_cep")
    private String cep;
    @Column(name = "endereco_bairro")
    private String bairro;
    @Column(name = "endereco_cidade")
    private String cidade;
    @Column(name = "endereco_complemento")
    private String complemento;

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String enderecoLogradouro) {
        this.logradouro = enderecoLogradouro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String enderecoCep) {
        this.cep = enderecoCep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String enderecoBairro) {
        this.bairro = enderecoBairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String enderecoCidade) {
        this.cidade = enderecoCidade;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String enderecoComplemento) {
        this.complemento = enderecoComplemento;
    }
}
