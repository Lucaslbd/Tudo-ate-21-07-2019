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
        return "Fornecedor{" + "codigo=" + codigo + ", nome=" + nome + ", telefone=" + telefone + ", email=" + email + ", tempoPagamento=" + tempoPagamento + ", porcentagemPagamento=" + porcentagemPagamento + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.codigo;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Fornecedor other = (Fornecedor) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        return true;
    }
}
