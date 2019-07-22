
package br.com.deposito.domain;

import java.util.Date;


public class Baixa {
    
    private int codigo;
    private Date data;
    private String descricao;
    private double valor;
    private int quantidade = 1;
    private Produto preoduto;
    private String casco;

    public String getCasco() {
        return casco;
    }

    public void setCasco(String casco) {
        this.casco = casco;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Produto getPreoduto() {
        return preoduto;
    }

    public void setPreoduto(Produto preoduto) {
        this.preoduto = preoduto;
    }
}
