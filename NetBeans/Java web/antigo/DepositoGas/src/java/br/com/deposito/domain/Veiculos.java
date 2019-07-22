package br.com.deposito.domain;


public class Veiculos {
    
    private int codigo;
    private String placa;
    private String marca;
    private String categoria;
    private String modelo;
    private Deposito deposito;

    public Deposito getDeposito() {
        return deposito;
    }

    public void setDeposito(Deposito deposito) {
        this.deposito = deposito;
    }

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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return "Veiculos{" + "codigo=" + codigo + ", placa=" + placa + ", marca=" + marca + ", categoria=" + categoria + ", modelo=" + modelo + ", deposito=" + deposito + '}';
    }    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + this.codigo;
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
        final Veiculos other = (Veiculos) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        return true;
    }
}
