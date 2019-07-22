
package br.com.deposito.domain;


public class Item {
    
    private int codigo;
    private int quantdade;
    private double valor;
    private Produto produto;
    private Venda venda;
    private String casco;
    private double custo; 

    public double getCusto() {
        return custo;
    }

    public void setCusto(double custo) {
        this.custo = custo;
    }

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

    public int getQuantdade() {
        return quantdade;
    }

    public void setQuantdade(int quantdade) {
        this.quantdade = quantdade;
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
        return "Item{" + "codigo=" + codigo + ", quantdade=" + quantdade + ", valor=" + valor + ", produto=" + produto + ", venda=" + venda + '}';
    }
}
