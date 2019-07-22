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
@Table(name = "veiculos")
@NamedQueries({
    @NamedQuery(name = "veiculos.listar", query = "select veiculos FROM Veiculo veiculos order by veiculos.placa")
    ,
    @NamedQuery(name = "veiculos.listarMarca", query = "select veiculos FROM Veiculo veiculos WHERE lower(veiculos.marca) LIKE :marca order by veiculos.marca")
    ,
    @NamedQuery(name = "veiculos.listarModelo", query = "select veiculos FROM Veiculo veiculos WHERE lower(veiculos.modelo) LIKE :modelo order by veiculos.modelo")
    ,
    @NamedQuery(name = "veiculos.listarPlaca", query = "select veiculos FROM Veiculo veiculos WHERE lower(veiculos.placa) LIKE :placa order by veiculos.placa")
})
public class Veiculo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_veiculo")
    private int codigo;
    @Column(name = "placa_veiculo", length = 7, nullable = false)
    private String placa;
    @Column(name = "marca_veiculo", length = 30, nullable = false)
    private String marca;
    @Column(name = "modelo_veiculo", length = 50, nullable = false)
    private String modelo;
    @Column(name = "ano_veiculo", length = 4, nullable = false)
    private String ano;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    @Override
    public String toString() {
        return getModelo() + " (" + getPlaca() +")";
    }
}
