package br.com.agenciaviagens.ralatorio;

public class ListaPassageiro {

    private String nomePax;
    private String rg;
    private String embarque;
    private String num;
    private String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }   

    public String getNomePax() {
        return nomePax;
    }

    public void setNomePax(String nomePax) {
        this.nomePax = nomePax;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getEmbarque() {
        return embarque;
    }

    public void setEmbarque(String embarque) {
        this.embarque = embarque;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    private String telefone;
}
