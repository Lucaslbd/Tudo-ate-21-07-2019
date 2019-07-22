
package br.com.loja.domain;


public class Funcionario{
    
    private int codigo;
    private String nome;
    private String funcao;
    private String telefone;
    private String cpf;
    private String senha;
    private double salario;
    private String situacao;
    private int BaseFgts;    
   

    public int getBaseFgts() {
        return BaseFgts;
    }

    public void setBaseFgts(int BaseFgts) {
        this.BaseFgts = BaseFgts;
    }     

    public int getFgts() {
        return BaseFgts;
    }

    public void setFgts(int fgts) {
        this.BaseFgts = fgts;
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

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    @Override
    public String toString() {
        return "Funcionario{" + "codigo=" + codigo + ", nome=" + nome + ", funcao=" + funcao + ", telefone=" + telefone + ", cpf=" + cpf + ", senha=" + senha + ", salario=" + salario + ", situacao=" + situacao + '}';
    }
}
