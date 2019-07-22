package br.com.drogaria.beans;

import br.com.drogaria.dao.ItemDao;
import br.com.drogaria.domain.Item;
import br.com.drogaria.util.JSFUtil;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "MBItens")
@ViewScoped
public class BeanItens {

    private List<Item> ListaItens;

    public List<Item> getListaItens() {

        return ListaItens;
    }

    public void setListaItens(List<Item> ListaItens) {
        this.ListaItens = ListaItens;
    }

    public void carregar() {
        try {
            String valor = JSFUtil.getParam("codVenda");
            if (valor != null) {
                int codigo = Integer.parseInt(valor);
                ItemDao dao = new ItemDao();
                ListaItens = dao.listarVendas(codigo);
            }
        } catch (RuntimeException ex) {
            JSFUtil.mensagemErro("Erro ao carregar produtos" + ex.getMessage());
        }
    }
}
