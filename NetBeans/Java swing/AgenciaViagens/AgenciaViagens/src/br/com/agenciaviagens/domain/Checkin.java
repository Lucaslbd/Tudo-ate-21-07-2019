package br.com.agenciaviagens.domain;

import java.util.Date;


public class Checkin {
    
    private int codigo;
    private Venda venda;
    private Date dataCheckin;
    private String horaCheckin;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public Date getDataCheckin() {
        return dataCheckin;
    }

    public void setDataCheckin(Date dataCheckin) {
        this.dataCheckin = dataCheckin;
    }

    public String getHoraCheckin() {
        return horaCheckin;
    }

    public void setHoraCheckin(String horaCheckin) {
        this.horaCheckin = horaCheckin;
    }
}
