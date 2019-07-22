package br.com.deposito.domain;


public class Autonomia {
    
    private int codigo;
    private double km;
    private double litros;
    private int entregas;
    private GastoVeiculo gasto;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getKm() {
        return km;
    }

    public void setKm(double km) {
        this.km = km;
    }

    public double getLitros() {
        return litros;
    }

    public void setLitros(double litros) {
        this.litros = litros;
    }

    public int getEntregas() {
        return entregas;
    }

    public void setEntregas(int entregas) {
        this.entregas = entregas;
    }

    public GastoVeiculo getGasto() {
        return gasto;
    }

    public void setGasto(GastoVeiculo gasto) {
        this.gasto = gasto;
    }
}
