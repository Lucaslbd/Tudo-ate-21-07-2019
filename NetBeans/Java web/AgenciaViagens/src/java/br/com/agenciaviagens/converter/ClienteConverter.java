package br.com.agenciaviagens.converter;


import br.com.agenciaviagens.beans.MBAutenticacao;
import br.com.agenciaviagens.dao.ClienteDao;
import br.com.agenciaviagens.domain.Cliente;
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
            ClienteDao dao = new ClienteDao(MBAutenticacao.empresa.getNumeroBanco());
            Cliente cliente = dao.buscarPorCodigo(codigo);
            return cliente;
        }catch(Exception ex){
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

