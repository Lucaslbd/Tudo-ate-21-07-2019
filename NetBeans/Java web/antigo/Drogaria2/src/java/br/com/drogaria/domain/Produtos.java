package br.com.drogaria.domain;

import java.math.BigDecimal;
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
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tbl_Produtos")
@NamedQueries({
        @NamedQuery (name= "Produtos.listar", query ="select produtos FROM Produtos produtos"),
        @NamedQuery (name= "Produtos.buscarPorCodigo", query ="select produtos FROM Produtos produtos WHERE produtos.codigo =:codigo")
})
public class Produtos {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pro_codigo")
    private int codigo;    
    @Column(name = "pro_descricao", length = 50, nullable = false)
    private String descricao;
    
    @Column(name = "pro_preco", precision = 7, scale=2, nullable = false)
    private BigDecimal preco;
    
    @Column(name = "pro_quantidade", nullable = false)
    private Integer quantidade;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name ="tbl_fabricantes_fab_codigo", referencedColumnName = "fab_codigo",nullable = false)
    private Fabricante fabricante;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Fabricante getFabricante() {
        return fabricante;
    }

    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
    }

    @Override
    public String toString() {
        return "Produtos{" + "codigo= " + codigo + ", descricao= " + descricao + ", preco= " + preco + ", quantidade= " + quantidade + ", fabricante= " + fabricante + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.codigo;
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
        final Produtos other = (Produtos) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        return true;
    }
}
