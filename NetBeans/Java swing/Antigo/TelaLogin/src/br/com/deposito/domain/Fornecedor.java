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
@Table(name = "fornecedor")
@NamedQueries({
    @NamedQuery(name = "fornecedor.listar", query = "select fornecedores FROM Fornecedor fornecedores order by fornecedores.nome")
    ,
    @NamedQuery(name = "fornecedor.listaNome", query = "select fornecedores FROM Fornecedor fornecedores WHERE lower(fornecedores.nome) LIKE :nome order by fornecedores.nome")
    ,
    @NamedQuery(name = "fornecedor.listarCnpj", query = "select fornecedores FROM Fornecedor fornecedores WHERE lower(fornecedores.cnpj) LIKE :cnpj order by fornecedores.nome")
    ,
    @NamedQuery(name = "fornecedor.listarCidade", query = "select fornecedores FROM Fornecedor fornecedores WHERE lower(fornecedores.cidade) LIKE :cidade order by fornecedores.nome")
})
public class Fornecedor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_fornecedor")
    private int codigo;
    @Column(name = "nome_fornecedor", length = 60, nullable = false)
    private String nome;
    @Column(name = "cnpj_fornecedor", length = 18, nullable = false)
    private String cnpj;
    @Column(name = "contato_fornecedor", length = 60, nullable = false)
    private String contato;
    @Column(name = "cidade_fornecedor", length = 50, nullable = false)
    private String cidade;

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

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @Override
    public String toString() {
        return getNome();
    }
}
