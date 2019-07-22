
package br.com.loja.domain;


public class FormaPagamento {
    
    private String FormaPagamento;
    private double valorPagamento;
    private Venda venda;

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public Venda getVenda() {
        return venda;
    }

    public String getFormaPagamento() {
        return FormaPagamento;
    }

    public void setFormaPagamento(String FormaPagamento) {
        this.FormaPagamento = FormaPagamento;
    }

    public double getValorPagamento() {
        return valorPagamento;
    }

    public void setValorPagamento(double valorPagamento) {
        this.valorPagamento = valorPagamento;
    }

    @Override
    public String toString() {
        return "FormaPagamento{" + "FormaPagamento=" + FormaPagamento + ", valorPagamento=" + valorPagamento + ", venda=" + venda + '}';
    }
    
}
