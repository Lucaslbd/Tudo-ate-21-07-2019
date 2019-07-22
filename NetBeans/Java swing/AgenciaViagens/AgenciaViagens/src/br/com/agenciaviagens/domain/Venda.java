package br.com.agenciaviagens.domain;

import java.util.Date;

public class Venda {

    private int codigo;
    private Cliente cliente;
    private Fornecedor fornecedor;  
    private Date dataVenda;
    private Date dataReceber;
    private double valorVenda;
    private double valorReceber;
    private String descricao;
    private String status; 
    private double comissaoFunc;
    private Funcionario funcionario;

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

    public double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(double valorVenda) {
        this.valorVenda = valorVenda;
    }

    public double getValorReceber() {
        return valorReceber;
    }

    public void setValorReceber(double valorReceber) {
        this.valorReceber = valorReceber;
    }

    @Override
    public String toString() {
        return "Venda{" + "codigo=" + codigo + ", cliente=" + cliente + ", fornecedor=" + fornecedor + ", dataVenda=" + dataVenda + ", dataReceber=" + dataReceber + ", valorVenda=" + valorVenda + ", valorReceber=" + valorReceber + ", descricao=" + descricao + ", status=" + status + '}';
    }
}
