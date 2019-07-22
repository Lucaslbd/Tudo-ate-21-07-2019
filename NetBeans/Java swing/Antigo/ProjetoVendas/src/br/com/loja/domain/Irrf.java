package br.com.loja.domain;


public class Irrf {
    
   private double valorInicial;
   private double valorFinal;
   private double porcentagem;
   private double devolver;
   private int codigo;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(double valorInicial) {
        this.valorInicial = valorInicial;
    }

    public double getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(double valorFinal) {
        this.valorFinal = valorFinal;
    }

    public double getPorcentagem() {
        return porcentagem;
    }

    public void setPorcentagem(double porcentagem) {
        this.porcentagem = porcentagem;
    }

    public double getDevolver() {
        return devolver;
    }

    public void setDevolver(double devolver) {
        this.devolver = devolver;
    }

    @Override
    public String toString() {
        return "Irrf{" + "valorInicial=" + valorInicial + ", valorFinal=" + valorFinal + ", porcentagem=" + porcentagem + ", devolver=" + devolver + '}';
    }
}
