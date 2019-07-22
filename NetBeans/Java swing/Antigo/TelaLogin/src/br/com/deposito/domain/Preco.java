package br.com.deposito.domain;

import br.com.deposito.util.Utilitario;
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
@Table(name = "precos")
@NamedQueries({
    @NamedQuery(name = "precos.listar", query = "select precos FROM Preco precos WHERE precos.produto.codigo =:codigo")
})
public class Preco implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_preco")
    private int codigo;
    @Column(name = "descricao_preco", length = 60, nullable = true)
    private String descricao;    
    @ManyToOne(fetch=FetchType.EAGER)    
    @OnDelete(action = OnDeleteAction.CASCADE)    
    @JoinColumn(name = "produto_preco", referencedColumnName = "codigo_produto", nullable = false)
    private Produto produto;
    @Column(name = "valor_preco", nullable = true)
    private double valor;

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

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        Utilitario util = new Utilitario();
        return getDescricao() + " ("+util.decimalFormatComCifrao(getValor())+ ")";
    }
}
