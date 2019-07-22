package br.com.deposito.converter;

import br.com.deposito.dao.ProdutoDao;
import br.com.deposito.domain.Produto;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("produtoConverter")
public class ProdutoConverter implements Converter{
 
    @Override
    public Object getAsObject(FacesContext fc, UIComponent componente, String valor) {        
        try{
            int codigo = Integer.parseInt(valor);
            ProdutoDao dao = new ProdutoDao();
            Produto produto = dao.buscarCodigo(codigo);
            return produto;
        }catch(RuntimeException ex){
            return null;
        }              
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent componente, Object objeto) {
       try{
        Produto produto =(Produto) objeto;
        Integer codigo = produto.getCodigo();
        return codigo.toString();
      }catch(RuntimeException ex){
        return null;        
    }
    }
    
}
