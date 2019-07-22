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
@Table(name = "clientes")
@NamedQueries({
    @NamedQuery(name = "Clientes.listar", query = "select clientes FROM Cliente clientes order by clientes.nome")
    ,
    @NamedQuery(name = "Clientes.listarNome", query = "select clientes FROM Cliente clientes WHERE lower(clientes.nome) LIKE :nome order by clientes.nome")
    ,
    @NamedQuery(name = "Clientes.listarRg", query = "select clientes FROM Cliente clientes WHERE lower(clientes.rg) LIKE :rg order by clientes.nome")
    ,
    @NamedQuery(name = "Clientes.listarCpf", query = "select clientes FROM Cliente clientes WHERE lower(clientes.cpf) LIKE :cpf order by clientes.nome")
    ,
    @NamedQuery(name = "Clientes.listarCidade", query = "select clientes FROM Cliente clientes WHERE lower(clientes.cidade) LIKE :cidade order by clientes.nome")
    ,
    @NamedQuery(name = "Clientes.listarBairro", query = "select clientes FROM Cliente clientes WHERE lower(clientes.bairro) LIKE :bairro order by clientes.nome")
    ,
    @NamedQuery(name = "Clientes.listarRua", query = "select clientes FROM Cliente clientes WHERE lower(clientes.rua) LIKE :rua order by clientes.nome")
    ,
    @NamedQuery(name = "Clientes.listarTelefone", query = "select clientes FROM Cliente clientes WHERE lower(clientes.telefone) LIKE :telefone order by clientes.nome")
})
public class Cliente implements Serializable {

    @Id     
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_cliente")
    private int codigo;
    @Column(name = "nome_cliente", length = 60, nullable = true)
    private String nome;
    @Column(name = "rg_cliente", length = 50, nullable = true)
    private String rg;
    @Column(name = "cpf_cliente", length = 14, nullable = true)
    private String cpf;
    @Column(name = "telefone_cliente", length = 16, nullable = true)
    private String telefone;
    @Column(name = "email_cliente", length = 100, nullable = true)
    private String email;
    @Column(name = "cidade_cliente", length = 50, nullable = true)
    private String cidade;
    @Column(name = "bairro_cliente", length = 50, nullable = true)
    private String bairro;
    @Column(name = "rua_cliente", length = 60, nullable = true)
    private String rua;
    @Column(name = "numero_cliente", length = 6, nullable = true)
    private String numero;
    @Temporal(value = TemporalType.DATE)
    @Column(name = "nascimento_cliente", nullable = true)
    private Date nascimento;

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
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

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return getNome() + " (" + getRua()+", N° " + getNumero() + ")";
    }
}
