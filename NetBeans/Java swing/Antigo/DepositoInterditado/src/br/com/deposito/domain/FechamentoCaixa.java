package br.com.deposito.domain;


public class FechamentoCaixa {
    
    private double troco;
    private double dinheiro;
    private double cartao;
    private double cheque;
    private double crediario;
    private int qtdCartao;
    private Deposito deposito;
    private int Cancelamento;
    private double valor;

    public int getCancelamento() {
        return Cancelamento;
    }

    public void setCancelamento(int Cancelamento) {
        this.Cancelamento = Cancelamento;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Deposito getDeposito() {
        return deposito;
    }

    public void setDeposito(Deposito deposito) {
        this.deposito = deposito;
    }

    public double getTroco() {
        return troco;
    }

    public void setTroco(double troco) {
        this.troco = troco;
    }

    public double getDinheiro() {
        return dinheiro;
    }

    public void setDinheiro(double dinheiro) {
        this.dinheiro = dinheiro;
    }

    public double getCartao() {
        return cartao;
    }

    public void setCartao(double cartao) {
        this.cartao = cartao;
    }

    public double getCheque() {
        return cheque;
    }

    public void setCheque(double cheque) {
        this.cheque = cheque;
    }

    public double getCrediario() {
        return crediario;
    }

    public void setCrediario(double crediario) {
        this.crediario = crediario;
    }

    public int getQtdCartao() {
        return qtdCartao;
    }

    public void setQtdCartao(int qtdCartao) {
        this.qtdCartao = qtdCartao;
    }
}
