package br.com.deposito.domain;

import java.util.Date;


public class GastoVeiculo {
    
    private int codigo;
    private String tipo;
    private String descricao;
    private double valor;
    private Date data;
    private Veiculos veiculo;

    public Veiculos getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculos veiculo) {
        this.veiculo = veiculo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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

    @Override
    public String toString() {
        return "GastoVeiculo{" + "codigo=" + codigo + ", tipo=" + tipo + ", descricao=" + descricao + ", valor=" + valor + ", data=" + data + ", veiculo=" + veiculo + '}';
    }
}
