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

@Entity
@Table(name = "tbl_itens")
@NamedQueries({
        @NamedQuery (name= "Item.listar", query ="select item FROM Item item"),
        @NamedQuery (name= "Item.buscarPorCodigo", query ="select item FROM Item item WHERE item.codigo =:codigo"),
        @NamedQuery (name= "Item.buscarVenda", query ="select item FROM Item item WHERE item.vendas =:vendas")
})
public class Item {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ite_codigo")
    private int codigo;
    
    @Column(name = "ite_quantidade", nullable = false)
    private Integer quantidade;
    
    @Column(name = "ite_valor_parcial", precision = 7, scale=2, nullable = false)
    private BigDecimal valor;    
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name ="tbl_vendas_ven_codigo", referencedColumnName = "ven_codigo",nullable = false)
    private Vendas vendas;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name ="tbl_produtos_pro_codigo", referencedColumnName = "pro_codigo",nullable = false)
    private Produtos produtos;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Vendas getVendas() {
        return vendas;
    }

    public void setVendas(Vendas vendas) {
        this.vendas = vendas;
    }

    public Produtos getProdutos() {
        return produtos;
    }

    public void setProdutos(Produtos produtos) {
        this.produtos = produtos;
    }

    @Override
    public String toString() {
        return "Item{" + "codigo= " + codigo + ", quantidade= " + quantidade + ", valor= " + valor + ", vendas= " + vendas + ", produtos=" + produtos + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.codigo;
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
        final Item other = (Item) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        return true;
    }
}
