
package br.com.loja.domain;

import java.util.Date;

public class Ponto {
    
   private int codigo;
   private Date data_hora;
   private String descricao;
   private Funcionario funcionario;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Date getData_hora() {
        return data_hora;
    }

    public void setData_hora(Date data_hora) {
        this.data_hora = data_hora;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    @Override
    public String toString() {
        return "HorasTrabalhadas{" + "codigo=" + codigo + ", data_hora=" + data_hora + ", descricao=" + descricao + ", funcionario=" + funcionario + '}';
    }
}
