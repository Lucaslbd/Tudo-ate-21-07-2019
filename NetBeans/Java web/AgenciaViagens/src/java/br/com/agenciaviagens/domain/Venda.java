package br.com.agenciaviagens.domain;

import java.util.Date;

public class Venda {

    private int codigo;
    private Cliente cliente = new Cliente();
    private Fornecedor fornecedor = new Fornecedor(); 
    private Funcionario funcionario = new Funcionario();
    private Date dataVenda;
    private Date dataReceber;   
    private double valorReceber;
    private String descricao;
    private String status;
    private double comissaoFunc;
    private Date dataCheckin;
    private String horaCheckin;
    private double valorPacote;
    private double taxas;
    private String referencia;

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public double getValorPacote() {
        return valorPacote;
    }

    public void setValorPacote(double valorPacote) {
        this.valorPacote = valorPacote;
    }

    public double getTaxas() {
        return taxas;
    }

    public void setTaxas(double taxas) {
        this.taxas = taxas;
    }

    /**
     *
     * @return
     */
    public Date getDataCheckin() {
        return dataCheckin;
    }

    public void setDataCheckin(Date dataCheckin) {
        this.dataCheckin = dataCheckin;
    }

    public String getHoraCheckin() {
        return horaCheckin;
    }

    public void setHoraCheckin(String horaCheckin) {
        this.horaCheckin = horaCheckin;
    }
    

    public double getComissaoFunc() {
        return comissaoFunc;
    }

    public void setComissaoFunc(double comissaoFunc) {
        this.comissaoFunc = comissaoFunc;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public Date getDataReceber() {
        return dataReceber;
    }

    public void setDataReceber(Date dataReceber) {
        this.dataReceber = dataReceber;
    }    

    public double getValorReceber() {
        return valorReceber;
    }

    public void setValorReceber(double valorReceber) {
        this.valorReceber = valorReceber;
    }   
}
