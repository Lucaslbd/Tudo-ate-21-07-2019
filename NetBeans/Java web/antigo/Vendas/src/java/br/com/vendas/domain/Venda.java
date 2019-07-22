package br.com.vendas.domain;


import java.util.Date;


public class Venda {
    
    private int codigo;
    private double valor;
    private Date data;
    private Funcionario funcionario;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    @Override
    public String toString() {
        return "Venda{" + "codigo=" + codigo + ", valor=" + valor + ", data=" + data + ", funcionario=" + funcionario + '}';
    }
}
