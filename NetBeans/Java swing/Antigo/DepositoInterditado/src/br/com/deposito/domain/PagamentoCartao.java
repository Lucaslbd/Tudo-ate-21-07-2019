package br.com.deposito.domain;


public class PagamentoCartao {
    
    private int codigo;
    private String descricao;    
    private String situacao;
    Venda venda;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }  

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }  

    @Override
    public String toString() {
        return "PagamentoCartao{" + "codigo=" + codigo + ", descricao=" + descricao + ", situacao=" + situacao + ", venda=" + venda + '}';
    }
    
}
