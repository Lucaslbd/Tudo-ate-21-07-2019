package br.com.vendas.domain;

import java.math.BigDecimal;


public class Item {
    
    private int codigo;
    private int quantidade;
    private double valor;
    private Produto produto;
    private Venda venda;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    @Override
    public String toString() {
        return "Item{" + "codigo=" + codigo + ", quantidade=" + quantidade + ", valor=" + valor + ", produto=" + produto + ", venda=" + venda + '}';
    }
}
