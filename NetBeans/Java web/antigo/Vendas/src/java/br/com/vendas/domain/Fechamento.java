package br.com.vendas.domain;


public class Fechamento {
    
    private int codigo_fechamento;
    private Venda venda;
    private String pagamento;
    private String situacao;
    private double valor_fechamento;

    public int getCodigo_fechamento() {
        return codigo_fechamento;
    }

    public void setCodigo_fechamento(int codigo_fechamento) {
        this.codigo_fechamento = codigo_fechamento;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public String getPagamento() {
        return pagamento;
    }

    public void setPagamento(String pagamento) {
        this.pagamento = pagamento;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public double getValor_fechamento() {
        return valor_fechamento;
    }

    public void setValor_fechamento(double valor_fechamento) {
        this.valor_fechamento = valor_fechamento;
    }

    @Override
    public String toString() {
        return "Fechamento{" + "codigo_fechamento= " + codigo_fechamento + ", venda= " + venda + ", pagamento= " + pagamento + ", situacao= " + situacao + ", valor_fechamento= " + valor_fechamento + '}';
    }
}
