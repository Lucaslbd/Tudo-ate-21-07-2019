package br.com.drogaria.domain;

import java.math.BigDecimal;
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
import javax.persistence.Transient;

@Entity
@Table(name = "tbl_vendas")
@NamedQueries({
        @NamedQuery (name= "Vendas.listar", query ="select vendas FROM Vendas vendas"),
        @NamedQuery (name= "Vendas.buscarPorCodigo", query ="select vendas FROM Vendas vendas WHERE vendas.codigo =:codigo")
})
public class Vendas {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ven_codigo")
    private int codigo;
    
    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "ven_horario", nullable = false)
    private Date horario;
    
    @Column(name = "ven_total", precision = 7, scale=2, nullable = false)
    private BigDecimal valor;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name ="tbl_funcionarios_fun_codigo", referencedColumnName = "fun_codigo", nullable = false)
    private Funcionarios funcionarios;

    @Transient
    private int quantidade;

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Date getHorario() {
        return horario;
    }

    public void setHorario(Date horario) {
        this.horario = horario;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Funcionarios getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(Funcionarios funcionarios) {
        this.funcionarios = funcionarios;
    }

    @Override
    public String toString() {
        return "Vendas{" + "codigo= " + codigo + ", horario= " + horario + ", valor= " + valor + ", funcionarios= " + funcionarios + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + this.codigo;
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
        final Vendas other = (Vendas) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        return true;
    }
}
