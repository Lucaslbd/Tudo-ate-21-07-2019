package br.com.deposito.domain;

public class Produto {

    private int codigo;
    private String nome;
    private double valorPortaria;
    private double valorCasco;
    private double valorEntrega;
    private double ValorPrazo;
    private double custoProduto;
    private double custoCasco;
    private int estoqueCheio;
    private int estoqueVazio;
    private Fornecedor fornecedor;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValorPortaria() {
        return valorPortaria;
    }

    public void setValorPortaria(double valorPortaria) {
        this.valorPortaria = valorPortaria;
    }

    public double getValorCasco() {
        return valorCasco;
    }

    public void setValorCasco(double valorCasco) {
        this.valorCasco = valorCasco;
    }

    public double getValorEntrega() {
        return valorEntrega;
    }

    public void setValorEntrega(double valorEntrega) {
        this.valorEntrega = valorEntrega;
    }

    public double getValorPrazo() {
        return ValorPrazo;
    }

    public void setValorPrazo(double ValorPrazo) {
        this.ValorPrazo = ValorPrazo;
    }

    public double getCustoProduto() {
        return custoProduto;
    }

    public void setCustoProduto(double custoProduto) {
        this.custoProduto = custoProduto;
    }

    public double getCustoCasco() {
        return custoCasco;
    }

    public void setCustoCasco(double custoCasco) {
        this.custoCasco = custoCasco;
    }

    public int getEstoqueCheio() {
        return estoqueCheio;
    }

    public void setEstoqueCheio(int estoqueCheio) {
        this.estoqueCheio = estoqueCheio;
    }

    public int getEstoqueVazio() {
        return estoqueVazio;
    }

    public void setEstoqueVazio(int estoqueVazio) {
        this.estoqueVazio = estoqueVazio;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    @Override
    public String toString() {
        return "Produto{" + "codigo=" + codigo + ", nome=" + nome + ", valorPortaria=" + valorPortaria + ", valorCasco=" + valorCasco + ", valorEntrega=" + valorEntrega + ", ValorPrazo=" + ValorPrazo + ", custoProduto=" + custoProduto + ", custoCasco=" + custoCasco + ", estoqueCheio=" + estoqueCheio + ", estoqueVazio=" + estoqueVazio + ", fornecedor=" + fornecedor + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + this.codigo;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Produto other = (Produto) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        return true;
    }

}
