package br.com.deposito.converter;


import br.com.deposito.dao.FornecedorDao;
import br.com.deposito.domain.Fornecedor;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;


@FacesConverter("fornecedorConverter")
public class FabricanteConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext fc, UIComponent componente, String valor) {        
        try{
            int codigo = Integer.parseInt(valor);
            FornecedorDao dao = new FornecedorDao();
            Fornecedor fabricante = dao.buscarCodigo(codigo);
            return fabricante;
        }catch(RuntimeException ex){
            return null;
        }              
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent componente, Object objeto) {
       try{
        Fornecedor fabricante =(Fornecedor) objeto;
        Integer codigo = fabricante.getCodigo();
        return codigo.toString();
      }catch(RuntimeException ex){
        return null;        
    }
    }
   
}

