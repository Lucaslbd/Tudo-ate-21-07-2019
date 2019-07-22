package modeloBeans;


public class BeansNotasMercadoria {
    private int codigoNota;
    private String produto;
    private String data;
    private double valor;
    private int quantidade;
    private String vencimento;
    private String situacao;
    private String descricaoNota;
    private String pesquisar;
    private String casco;

    public String getCasco() {
        return casco;
    }

    public void setCasco(String casco) {
        this.casco = casco;
    }

    public String getDescricaoNota() {
        return descricaoNota;
    }

    public void setDescricaoNota(String descricaoNota) {
        this.descricaoNota = descricaoNota;
    }
    

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
   

    public int getCodigoNota() {
        return codigoNota;
    }

    public void setCodigoNota(int codigoNota) {
        this.codigoNota = codigoNota;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getVencimento() {
        return vencimento;
    }

    public void setVencimento(String vencimento) {
        this.vencimento = vencimento;
    }

    

    public String getPesquisar() {
        return pesquisar;
    }

    public void setPesquisar(String pesquisar) {
        this.pesquisar = pesquisar;
    }
    
}
