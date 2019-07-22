package br.com.drogaria.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_fabricantes")
@NamedQueries({
        @NamedQuery (name= "Fabricante.listar", query ="select fabricante FROM Fabricante fabricante order by fabricante.descricao"),
        @NamedQuery (name= "Fabricante.buscarPorCodigo", query ="select fabricante FROM Fabricante fabricante WHERE fabricante.codigo =:codigo")
})
public class Fabricante{
   
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "fab_codigo")
    private int codigo;
    
    @NotNull(message = "")
    @Column(name = "fab_descricao", length = 50, nullable = false)
    private String descricao;

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

    @Override
    public String toString() {
        return "Fabricante{" + "codigo= " + codigo + ", descricao= " + descricao + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + this.codigo;
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
        final Fabricante other = (Fabricante) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        return true;
    }
}
