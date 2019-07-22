package br.com.deposito.relatorio;

import java.util.Date;

public class VendaRelatorio {

    private int qtdTotal;
    private double apurado;
    private double lucro;
    private String totalPorcento;
    private int qtdEntregas;
    private double apuradoEntregas;
    private double lucroEntregas;
    private String entregaPorcento;
    private int qtdPortaria;
    private double apuradoPortaria;
    private double lucroPortaria;   
    private String portaPorcento;
    private int cartao;
    private int dinheiro;
    private int crediario;
    private int cheque;

    public Date getData1() {
        return data1;
    }

    public void setData1(Date data1) {
        this.data1 = data1;
    }

    public Date getData2() {
        return data2;
    }

    public void setData2(Date data2) {
        this.data2 = data2;
    }
    private Date data1;
    private Date data2;

    public int getQtdTotal() {
        return qtdTotal;
    }

    public void setQtdTotal(int qtdTotal) {
        this.qtdTotal = qtdTotal;
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

    public String getTotalPorcento() {
        return totalPorcento;
    }

    public void setTotalPorcento(String totalPorcento) {
        this.totalPorcento = totalPorcento;
    }

    public int getQtdEntregas() {
        return qtdEntregas;
    }

    public void setQtdEntregas(int qtdEntregas) {
        this.qtdEntregas = qtdEntregas;
    }

    public double getApuradoEntregas() {
        return apuradoEntregas;
    }

    public void setApuradoEntregas(double apuradoEntregas) {
        this.apuradoEntregas = apuradoEntregas;
    }

    public double getLucroEntregas() {
        return lucroEntregas;
    }

    public void setLucroEntregas(double lucroEntregas) {
        this.lucroEntregas = lucroEntregas;
    }

    public String getEntregaPorcento() {
        return entregaPorcento;
    }

    public void setEntregaPorcento(String entregaPorcento) {
        this.entregaPorcento = entregaPorcento;
    }

    public int getQtdPortaria() {
        return qtdPortaria;
    }

    public void setQtdPortaria(int qtdPortaria) {
        this.qtdPortaria = qtdPortaria;
    }

    public double getApuradoPortaria() {
        return apuradoPortaria;
    }

    public void setApuradoPortaria(double apuradoPortaria) {
        this.apuradoPortaria = apuradoPortaria;
    }

    public double getLucroPortaria() {
        return lucroPortaria;
    }

    public void setLucroPortaria(double lucroPortaria) {
        this.lucroPortaria = lucroPortaria;
    }

    public String getPortaPorcento() {
        return portaPorcento;
    }

    public void setPortaPorcento(String portaPorcento) {
        this.portaPorcento = portaPorcento;
    }

    public int getCartao() {
        return cartao;
    }

    public void setCartao(int cartao) {
        this.cartao = cartao;
    }

    public int getDinheiro() {
        return dinheiro;
    }

    public void setDinheiro(int dinheiro) {
        this.dinheiro = dinheiro;
    }

    public int getCrediario() {
        return crediario;
    }

    public void setCrediario(int crediario) {
        this.crediario = crediario;
    }

    public int getCheque() {
        return cheque;
    }

    public void setCheque(int cheque) {
        this.cheque = cheque;
    }

}