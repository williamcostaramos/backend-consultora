package br.com.williamramos.consultora.domain.model;

import br.com.williamramos.consultora.domain.enuns.EstadoCivil;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codigo;

    @Column(name = "nome")
    private String nome;
    @Column(name = "cpf")
    private String cpf;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "estado_civil")
    private EstadoCivil estadoCivil;
    private LocalDate dataNascimento;
    @Embedded
    private Endereco endereco;
    @Column(name = "has_filhos")
    private Boolean hasFilhos;
    @Column(name = "qtd_filhos")
    private Integer qtdFilhos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

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

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Boolean getHasFilhos() {
        return hasFilhos;
    }

    public void setHasFilhos(Boolean possuiFilhos) {
        this.hasFilhos = possuiFilhos;
    }

    public Integer getQtdFilhos() {
        return qtdFilhos;
    }

    public void setQtdFilhos(Integer quantidadeFilhos) {
        this.qtdFilhos = quantidadeFilhos;
    }

    @PrePersist
    public void gerarCodigo(){
        this.codigo = UUID.randomUUID().toString();
    }
}
