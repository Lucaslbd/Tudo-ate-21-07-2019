package br.com.vendas.domain;


public class Fabricante {
    
    private int codigo;
    private String nome;
    private String cnpj;
    private String telefone;
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    

    @Override
    public String toString() {
        return "Fabricante{" + "codigo= " + codigo + ", nome= " + nome + ", cnpj= " + cnpj + ", telefone= " + telefone + ", responsavel= " + email + '}';
    }

    

   
}
