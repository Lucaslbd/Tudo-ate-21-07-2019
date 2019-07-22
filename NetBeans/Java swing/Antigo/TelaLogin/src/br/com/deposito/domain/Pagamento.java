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
@Table(name = "pagamentos")
@NamedQueries({
    @NamedQuery(name = "Pagamentos.listarTipo", query = "select pagamentos FROM Pagamento pagamentos where pagamentos.aceitar =:aceitar order by pagamentos.tipo")
    ,
     @NamedQuery(name = "Pagamentos.listar", query = "select pagamentos FROM Pagamento pagamentos order by pagamentos.tipo")
})
public class Pagamento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_pagamento")
    private int codigo;
    @Column(name = "descricao_pagamento", length = 30, nullable = true)
    private String descricao;
    @Column(name = "receber_pagamento", nullable = true)
    private int diasReceber;
    @Column(name = "desconto_pagamento", nullable = true)
    private double desconto;
    @Column(name = "aceitar_pagamento", length = 3, nullable = true)
    private String aceitar;
    @Column(name = "tipo_pagamento", length = 20, nullable = true)
    private String tipo;
    @Column(name = "estrategia_pagamento", length = 3, nullable = true)
    private String estrategia;

    public String getEstrategia() {
        return estrategia;
    }

    public void setEstrategia(String estrategia) {
        this.estrategia = estrategia;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getAceitar() {
        return aceitar;
    }

    public void setAceitar(String aceitar) {
        this.aceitar = aceitar;
    }

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

    public int getDiasReceber() {
        return diasReceber;
    }

    public void setDiasReceber(int diasReceber) {
        this.diasReceber = diasReceber;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    @Override
    public String toString() {
        if (getDescricao().equals("Sem descrição")) {
            return getTipo();
        } else {
            return getTipo() + " (" + getDescricao() + ")";
        }
    }
}
