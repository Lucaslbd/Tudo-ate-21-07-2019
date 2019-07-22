package br.com.deposito.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
@NamedQueries({
    @NamedQuery(name = "Usuario.listar", query = "select usuarios FROM Usuario usuarios order by usuarios.nome")
    ,
    @NamedQuery(name = "Usuario.listarNome", query = "select usuarios FROM Usuario usuarios WHERE lower(usuarios.nome) LIKE :nome order by usuarios.nome")
    ,
    @NamedQuery(name = "Usuario.autenticar", query = "select usuarios FROM Usuario usuarios WHERE usuarios.email =:email and usuarios.senha =:senha")
})
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_usuario")
    private int codigo;
    @Column(name = "nome_usuario", length = 60, nullable = true)
    private String nome;
    @Column(name = "email_usuario", length = 100, nullable = true)
    private String email;
    @Column(name = "senha_usuario", length = 20, nullable = true)
    private String senha;
    @Column(name = "tipo_usuario", length = 20, nullable = true)
    private String tipo;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
