package br.com.williamramos.consultora.domain.model;

import br.com.williamramos.consultora.domain.enuns.FormaPagamento;
import br.com.williamramos.consultora.domain.enuns.StatusPagamento;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "venda")
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "data_compra")
    private LocalDateTime dataCompra;
    @Column(name = "subtotal")
    private BigDecimal subtotal;
    @Column(name = "taxa_frete")
    private BigDecimal taxaFrete;
    @Column(name = "data_pagamento")
    private LocalDate dataPagamento;
    @Column(name = "forma_pagamento")
    @Enumerated(EnumType.ORDINAL)
    private FormaPagamento formaPagamento;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "status_pagamento")
    private StatusPagamento statusPagamento;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    @OneToMany(mappedBy = "venda", cascade = CascadeType.ALL)
    private List<ItemVenda> itens;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDateTime getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(LocalDateTime dataCompra) {
        this.dataCompra = dataCompra;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public BigDecimal calcularTotalVenda() {
        this.itens.forEach(ItemVenda::calcularValorTotal);
        this.subtotal = itens.stream().map(ItemVenda::getValorTotal).reduce(BigDecimal.ZERO, BigDecimal::add);
        return subtotal.add(this.taxaFrete);
    }

    public BigDecimal getTaxaFrete() {
        return taxaFrete;
    }

    public void setTaxaFrete(BigDecimal taxaFrete) {
        this.taxaFrete = taxaFrete;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public StatusPagamento getStatusPagamento() {
        return statusPagamento;
    }

    public void setStatusPagamento(StatusPagamento statusPagamento) {
        this.statusPagamento = statusPagamento;
    }

    public List<ItemVenda> getItens() {
        return itens;
    }

    public void setItens(List<ItemVenda> itens) {
        this.itens = itens;
    }

    public void adicionarItem(ItemVenda itemVenda) {
        this.itens.add(itemVenda);
    }

    public void removeItem(ItemVenda itemVenda) {
        this.itens.remove(itemVenda);
    }

}
