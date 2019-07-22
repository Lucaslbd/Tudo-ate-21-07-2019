package br.com.agenciaviagens.grafico;


public class GraficoVendas {
    
   private String mes;
   private double valor;
   private String tipo;
   private String titulo;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "GraficoVendas{" + "mes=" + mes + ", valor=" + valor + '}';
    }
}
