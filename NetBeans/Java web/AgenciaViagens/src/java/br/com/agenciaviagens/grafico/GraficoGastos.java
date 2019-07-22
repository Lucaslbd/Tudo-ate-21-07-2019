
package br.com.agenciaviagens.grafico;


public class GraficoGastos {
    
    private String data;
    private double valor;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "GraficoVendas{" + "data=" + data + ", valor=" + valor + '}';
    }
}
