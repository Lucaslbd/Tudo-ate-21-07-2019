package br.com.agenciaviagens.domain;

import java.util.Date;


public class Grupo {
    
    private int codigo;
    private String nome_grupo;/**/
    private Date data;/**/
    private int pax;/**/
    private double custo_fixo;/**/
    private double custo_relativo;/**/
    private String situacao;    
    private double valor_venda;/**/
    private String atividades;/**/
    private int tripulacao;/**/    
    private String dataFormatada;

    public String getDataFormatada() {
        return dataFormatada;
    }

    public void setDataFormatada(String dataFormatada) {
        this.dataFormatada = dataFormatada;
    }

    public int getTripulacao() {
        return tripulacao;
    }

    public void setTripulacao(int tripulacao) {
        this.tripulacao = tripulacao;
    }   

    public String getAtividades() {
        return atividades;
    }

    public void setAtividades(String atividades) {
        this.atividades = atividades;
    }

    public double getValor_venda() {
        return valor_venda;
    }

    public void setValor_venda(double valor_venda) {
        this.valor_venda = valor_venda;
    }

   
    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome_grupo() {
        return nome_grupo;
    }

    public void setNome_grupo(String nome_grupo) {
        this.nome_grupo = nome_grupo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getPax() {
        return pax;
    }

    public void setPax(int pax) {
        this.pax = pax;
    }

    public double getCusto_fixo() {
        return custo_fixo;
    }

    public void setCusto_fixo(double custo_fixo) {
        this.custo_fixo = custo_fixo;
    }

    public double getCusto_relativo() {
        return custo_relativo;
    }

    public void setCusto_relativo(double custo_relativo) {
        this.custo_relativo = custo_relativo;
    }
}
