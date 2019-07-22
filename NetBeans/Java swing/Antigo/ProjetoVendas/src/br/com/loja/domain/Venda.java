package br.com.loja.domain;

import java.util.Date;

public class Venda {
    
   private int codigo;
   private Funcionario funcionario;
   private double valor;
   private Date data;
   private double lucro;

    public double getLucro() {
        return lucro;
    }

    public void setLucro(double lucro) {
        this.lucro = lucro;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
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

    @Override
    public String toString() {
        return "Venda{" + "codigo=" + codigo + ", funcionario=" + funcionario + ", valor=" + valor + ", data=" + data + '}';
    }
}
