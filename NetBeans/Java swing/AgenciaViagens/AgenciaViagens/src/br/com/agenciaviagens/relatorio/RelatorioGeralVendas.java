package br.com.agenciaviagens.relatorio;

public class RelatorioGeralVendas {

    private String servico;
    private double apurado;
    private double lucro;
    private String data; 
    private int quantidade;
    private String inicio;
    private String fim;

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getFim() {
        return fim;
    }

    public void setFim(String fim) {
        this.fim = fim;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getServico() {
        return servico;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }

    public double getApurado() {
        return apurado;
    }

    public void setApurado(double apurado) {
        this.apurado = apurado;
    }

    public double getLucro() {
        return lucro;
    }

    public void setLucro(double lucro) {
        this.lucro = lucro;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
   
}
