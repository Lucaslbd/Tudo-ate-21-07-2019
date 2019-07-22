package br.com.deposito.domain;

import java.util.Date;

public class Gasto implements Comparable<Gasto> {

    private Date data;
    private String responsavel;
    private String descricao;
    private double valor;

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
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
        return "Gasto{" + "data=" + data + ", responsavel=" + responsavel + ", descricao=" + descricao + ", valor=" + valor + '}';
    }

    @Override
    public int compareTo(Gasto o) {
        if (this.data.getTime() < o.getData().getTime()) {
            return -1;
        } else if (this.data.getTime() > o.getData().getTime()) {
            return 1;
        }
        return 0;
    }
}
