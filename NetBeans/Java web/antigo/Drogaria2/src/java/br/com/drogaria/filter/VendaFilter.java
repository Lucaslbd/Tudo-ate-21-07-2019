package br.com.drogaria.filter;

import br.com.drogaria.domain.Funcionarios;
import java.util.Date;


public class VendaFilter {
    
    private Date dataInicial;
    private Date dataFinal;
    private Funcionarios funcionario;

    public Funcionarios getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionarios funcionario) {
        this.funcionario = funcionario;
    }
    
    public Date getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }
}
