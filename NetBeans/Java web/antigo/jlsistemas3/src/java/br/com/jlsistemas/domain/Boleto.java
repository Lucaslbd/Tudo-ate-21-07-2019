package br.com.jlsistemas.domain;

import java.util.Date;

public class Boleto {

    private String code;
    private Empresa Empresa;
    private double valor;
    private double desconto;
    private Date criacao;
    private Date vencimento;     
    private String status; 
    private String link;   

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Empresa getEmpresa() {
        return Empresa;
    }

    public void setEmpresa(Empresa Empresa) {
        this.Empresa = Empresa;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public Date getCriacao() {
        return criacao;
    }

    public void setCriacao(Date criacao) {
        this.criacao = criacao;
    }

    public Date getVencimento() {
        return vencimento;
    }

    public void setVencimento(Date vencimento) {
        this.vencimento = vencimento;
    }  

    @Override
    public String toString() {
        return "Boleto{" + "code=" + code + "\nEmpresa=" + Empresa + "\nvalor=" + valor + "\ndesconto=" + desconto + "\ncriacao=" + criacao + "\nvencimento=" + vencimento + "\nstatus=" + status + "\nlink=" + link + '}';
    }
    
}
