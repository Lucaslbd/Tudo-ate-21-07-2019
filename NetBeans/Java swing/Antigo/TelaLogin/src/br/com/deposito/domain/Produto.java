package br.com.deposito.domain;

import java.io.Serializable;
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
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "produtos")
@NamedQueries({
    @NamedQuery(name = "produtos.listar", query = "select produtos FROM Produto produtos order by produtos.nome")
    ,
     @NamedQuery(name = "produtos.listarSoRetornavel", query = "select produtos FROM Produto produtos WHERE produtos.retornavel = :retornavel order by produtos.nome")
    ,
     @NamedQuery(name = "produtos.listarEstoque", query = "select produtos FROM Produto produtos WHERE produtos.estoque.codigo = :estoque order by produtos.nome")
    ,
    @NamedQuery(name = "produtos.listarNome", query = "select produtos FROM Produto produtos WHERE lower(produtos.nome) LIKE :nome order by produtos.nome")
    ,
    @NamedQuery(name = "produtos.listarRetornavel", query = "select produtos FROM Produto produtos WHERE lower(produtos.retornavel) LIKE :retornavel order by produtos.retornavel")
    ,
    @NamedQuery(name = "produtos.listarFornecedor", query = "select produtos FROM Produto produtos WHERE lower(produtos.fornecedor.nome) LIKE :nome order by produtos.nome")
})
public class Produto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_produto")
    private int codigo;
    @Column(name = "nome_produto", length = 60, nullable = true)
    private String nome;
    @ManyToOne(fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "fornecedor_produto", referencedColumnName = "codigo_fornecedor", nullable = false)
    private Fornecedor fornecedor;
    @Column(name = "retornavel", length = 3, nullable = true)
    private String retornavel;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "estoque", referencedColumnName = "codigo_estoque", nullable = false)
    private Estoque estoque;
    @Column(name = "custo", nullable = true)
    private double custo;    
    @Column(name = "cheio_produto", nullable = true)
    private int cheio;

    public int getCheio() {
        return cheio;
    }

    public void setCheio(int cheio) {
        this.cheio = cheio;
    }

    public double getCusto() {
        return custo;
    }

    public void setCusto(double custo) {
        this.custo = custo;
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

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getRetornavel() {
        return retornavel;
    }

    public void setRetornavel(String retornavel) {
        this.retornavel = retornavel;
    }

    public Estoque getEstoque() {
        return estoque;
    }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }

    @Override
    public String toString() {
        return getNome() + " (" + getFornecedor().getNome() + ")";
    }
}
