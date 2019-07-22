package br.com.vendas.bean;

import br.com.vendas.dao.FechamentoDao;
import br.com.vendas.domain.Fechamento;
import br.com.vendas.util.JSFUtil;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "MBFechamento")
@ViewScoped
public class FechamentoBean {
    ArrayList<Fechamento> ListaFechamento = new ArrayList<>();

    public ArrayList<Fechamento> getListaFechamento() {
        return ListaFechamento;
    }

    public void setListaFechamento(ArrayList<Fechamento> ListaFechamento) {
        this.ListaFechamento = ListaFechamento;
    }

public void listaPorVenda(int codigo) {
        FechamentoDao dao = new FechamentoDao();
        try {
            ListaFechamento = dao.ListarPorVenda(codigo);
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao listar itens " + ex);
        }
    }    
}
