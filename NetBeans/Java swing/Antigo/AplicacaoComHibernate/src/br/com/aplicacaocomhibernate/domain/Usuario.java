package br.com.aplicacaocomhibernate.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "usuarios")
@NamedQueries({
    @NamedQuery(name = "Usuario.listar", query = "select usuario FROM Usuario usuario order by usuario.nome")
})
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "codigo_usuario")
    private int codigo;
    @Column(name = "nome", length = 100, nullable = false)
    private String nome;
    @Temporal(value = TemporalType.DATE)
    @Column(name = "nascimento", nullable = false)
    private Date nascimento;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "endereco", referencedColumnName = "codigo_endereco", nullable = false)
    private Endereco endereco;

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

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
}
