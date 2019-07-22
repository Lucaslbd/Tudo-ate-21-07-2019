package br.com.deposito.converter;


import br.com.deposito.dao.ClienteDao;
import br.com.deposito.dao.FornecedorDao;
import br.com.deposito.domain.Cliente;
import br.com.deposito.domain.Fornecedor;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;


@FacesConverter("clienteConverter")
public class ClienteConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext fc, UIComponent componente, String valor) {        
        try{
            int codigo = Integer.parseInt(valor);
            ClienteDao dao = new ClienteDao();
            Cliente cliente = dao.buscarCodigo(codigo);
            return cliente;
        }catch(RuntimeException ex){
            return null;
        }              
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent componente, Object objeto) {
       try{
        Cliente cliente =(Cliente) objeto;
        Integer codigo = cliente.getCodigo();
        return codigo.toString();
      }catch(RuntimeException ex){
        return null;        
    }
    }
   
}

