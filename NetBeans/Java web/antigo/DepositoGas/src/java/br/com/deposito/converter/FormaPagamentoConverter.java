package br.com.deposito.converter;

import br.com.deposito.dao.FormaPagamentoDao;
import br.com.deposito.dao.VeiculoDao;
import br.com.deposito.domain.FormaPagamento;
import br.com.deposito.domain.Veiculos;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("formaPagamentoConverter")
public class FormaPagamentoConverter implements Converter{
 
    @Override
    public Object getAsObject(FacesContext fc, UIComponent componente, String valor) {        
        try{
            int codigo = Integer.parseInt(valor);
            FormaPagamentoDao dao = new FormaPagamentoDao();
            FormaPagamento forma = dao.buscarCodigo(codigo);
            return forma;
        }catch(RuntimeException ex){
            return null;
        }              
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent componente, Object objeto) {
       try{
        FormaPagamento forma =(FormaPagamento) objeto;
        Integer codigo = forma.getCodigo();
        return codigo.toString();
      }catch(RuntimeException ex){
        return null;        
    }
    }
    
}
