package modeloBeans;


public class BeansFrenteCaixa {
    private int codVenda;
    private String descricaoVenda;
    private String metodoVenda;
    private Double valorVenda;
    private String quantidadeVenda;
    private String dataVenda;
    private String casco;
    private String hora;
    private String usuario;
    private String turno;
    private Double custo;
    private Double valor_cobrado;
    private String Pagamento;
    private Double ValorTotal;
    private String tipoPagamento;

    public String getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(String tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }
    private String pesquisar;

    public String getPesquisar() {
        return pesquisar;
    }

    public void setPesquisar(String pesquisar) {
        this.pesquisar = pesquisar;
    }

    public Double getValorTotal() {
        return ValorTotal;
    }

    public void setValorTotal(Double ValorTotal) {
        this.ValorTotal = ValorTotal;
    }

    public String getPagamento() {
        return Pagamento;
    }

    public void setPagamento(String Pagamento) {
        this.Pagamento = Pagamento;
    }

    public Double getValor_cobrado() {
        return valor_cobrado;
    }

    public void setValor_cobrado(Double valor_cobrado) {
        this.valor_cobrado = valor_cobrado;
    }

    public Double getCusto() {
        return custo;
    }

    public void setCusto(Double custo) {
        this.custo = custo;
    }
    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getCodVenda() {
        return codVenda;
    }

    public void setCodVenda(int codVenda) {
        this.codVenda = codVenda;
    }

    public String getDescricaoVenda() {
        return descricaoVenda;
    }

    public void setDescricaoVenda(String descricaoVenda) {
        this.descricaoVenda = descricaoVenda;
    }

    public String getMetodoVenda() {
        return metodoVenda;
    }

    public void setMetodoVenda(String metodoVenda) {
        this.metodoVenda = metodoVenda;
    }

    public Double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(Double valorVenda) {
        this.valorVenda = valorVenda;
    }

    public String getQuantidadeVenda() {
        return quantidadeVenda;
    }

    public void setQuantidadeVenda(String quantidadeVenda) {
        this.quantidadeVenda = quantidadeVenda;
    }

    public String getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(String dataVenda) {
        this.dataVenda = dataVenda;
    }

    public String getCasco() {
        return casco;
    }

    public void setCasco(String casco) {
        this.casco = casco;
    }
}
