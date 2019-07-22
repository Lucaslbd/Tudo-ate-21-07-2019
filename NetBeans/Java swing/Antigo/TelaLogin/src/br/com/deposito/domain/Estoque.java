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
@Table(name = "estoque")
@NamedQueries({
    @NamedQuery(name = "Estoque.listarPorNome", query = "select estoques FROM Estoque estoques where estoques.nome =:nome")
    ,
    @NamedQuery(name = "Estoque.listar", query = "select estoques FROM Estoque estoques where estoques.nome !=:nome order by estoques.nome")
})
public class Estoque implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_estoque")
    private int codigo;
    @Column(name = "vazio_estoque", nullable = true)
    private int vazio;
    @Column(name = "nome_estoque", length = 60, nullable = true)
    private String nome;
    @Column(name = "custo_casco", nullable = true)
    private double custoCasco;

    public double getCustoCasco() {
        return custoCasco;
    }

    public void setCustoCasco(double custoCasco) {
        this.custoCasco = custoCasco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getVazio() {
        return vazio;
    }

    public void setVazio(int vazio) {
        this.vazio = vazio;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return getNome() + " ("+getVazio() +") unidades";
    }
}
