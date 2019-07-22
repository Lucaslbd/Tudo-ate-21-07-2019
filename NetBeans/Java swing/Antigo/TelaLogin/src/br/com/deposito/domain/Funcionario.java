package br.com.deposito.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "funcionarios")
@NamedQueries({
    @NamedQuery(name = "Funcionarios.listar", query = "select funcionarios FROM Funcionario funcionarios order by funcionarios.nome")
    ,
    @NamedQuery(name = "Funcionarios.listarNome", query = "select funcionarios FROM Funcionario funcionarios WHERE lower(funcionarios.nome) LIKE :nome order by funcionarios.nome")
    ,
    @NamedQuery(name = "Funcionarios.listarRg", query = "select funcionarios FROM Funcionario funcionarios WHERE lower(funcionarios.rg) LIKE :rg order by funcionarios.nome")
    ,
    @NamedQuery(name = "Funcionarios.listarCpf", query = "select funcionarios FROM Funcionario funcionarios WHERE lower(funcionarios.cpf) LIKE :cpf order by funcionarios.nome")
    ,
    @NamedQuery(name = "Funcionarios.listarTelefone", query = "select funcionarios FROM Funcionario funcionarios WHERE lower(funcionarios.telefone) LIKE :telefone order by funcionarios.nome")
})
public class Funcionario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_funcionario")
    private int codigo;
    @Column(name = "nome_funcionario", length = 60, nullable = true)
    private String nome;
    @Column(name = "cpf_funcionario", length = 60, nullable = true)
    private String cpf;
    @Column(name = "rg_funcionario", length = 50, nullable = true)
    private String rg;
    @Column(name = "funcao_funcionario", length = 50, nullable = true)
    private String funcao;
    @Column(name = "salario_funcionario", nullable = true)
    private double salario;
    @Column(name = "comissao_funcionario", nullable = true)
    private double comissao;
    @Column(name = "status_funcionario", length = 20, nullable = true)
    private String status;
    @Column(name = "telefone_funcionario", length = 16, nullable = true)
    private String telefone;
    @Temporal(value = TemporalType.DATE)
    @Column(name = "nascimento_funcionario", nullable = true)
    private Date nascimento;

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public double getComissao() {
        return comissao;
    }

    public void setComissao(double comissao) {
        this.comissao = comissao;
    }
}
