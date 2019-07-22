package br.com.agenciaviagens.domain;

public class Fornecedor {

    private int codigo;
    private String nome;
    private String telefone;
    private String email;
    private int tempoPagamento;
    private double porcentagemPagamento;

    public int getTempoPagamento() {
        return tempoPagamento;
    }

    public void setTempoPagamento(int tempoPagamento) {
        this.tempoPagamento = tempoPagamento;
    }

    public double getPorcentagemPagamento() {
        return porcentagemPagamento;
    }

    public void setPorcentagemPagamento(double porcentagemPagamento) {
        this.porcentagemPagamento = porcentagemPagamento;
    }
    

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return getNome();
    }
}
