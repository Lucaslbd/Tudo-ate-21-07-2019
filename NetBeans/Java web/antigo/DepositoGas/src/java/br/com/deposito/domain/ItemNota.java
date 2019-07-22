package br.com.deposito.domain;

public class ItemNota {

    private int codigo;
    private Produto produto;
    private int quantidade;
    private double valor;
    private Nota nota;
    private String casco;
    private int utilizados;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
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

    public Nota getNota() {
        return nota;
    }

    public void setNota(Nota nota) {
        this.nota = nota;
    }

    public String getCasco() {
        return casco;
    }

    public void setCasco(String casco) {
        this.casco = casco;
    }

    public int getUtilizados() {
        return utilizados;
    }

    public void setUtilizados(int utilizados) {
        this.utilizados = utilizados;
    }

    @Override
    public String toString() {
        return "ItemNota{" + "codigo=" + codigo + ", produto=" + produto + ", quantidade=" + quantidade + ", valor=" + valor + ", nota=" + nota + ", casco=" + casco + ", utilizados=" + utilizados + '}';
    }
}
