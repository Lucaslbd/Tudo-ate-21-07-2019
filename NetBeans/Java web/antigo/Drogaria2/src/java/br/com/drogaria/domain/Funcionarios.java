package br.com.drogaria.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_funcionarios")
@NamedQueries({
        @NamedQuery (name= "Funcionarios.listar", query ="select funcionarios FROM Funcionarios funcionarios"),
        @NamedQuery (name= "Funcionarios.buscarPorCodigo", query ="select funcionarios FROM Funcionarios funcionarios WHERE funcionarios.codigo =:codigo"),
        @NamedQuery (name= "Funcionarios.autenticar", query ="select funcionarios FROM Funcionarios funcionarios WHERE funcionarios.cpf =:cpf and funcionarios.senha =:senha")
})
public class Funcionarios {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "fun_codigo")
    private int codigo;
    
    @Column(name = "fun_nome", length = 50, nullable = false)
    private String nome;
    
    @Column(name = "fun_cpf", length = 14, nullable = false, unique = true)     
    private String cpf;
    
    @Column(name = "fun_senha", length = 32, nullable = false)
    private String senha;
    
    @Column(name = "fun_funcao", length = 50, nullable = false)
    private String funcao;

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

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    @Override
    public String toString() {
        return "Funcionarios{" + "codigo= " + codigo + ", nome= " + nome + ", cpf= " + cpf + ", senha= " + senha + ", funcao= " + funcao + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + this.codigo;
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
        final Funcionarios other = (Funcionarios) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        return true;
    }
}
