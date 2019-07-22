package br.com.jlsistemas.converter;


import br.com.jlsistemas.dao.SistemaDao;
import br.com.jlsistemas.domain.Sistema;
import java.sql.SQLException;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;


@FacesConverter("sistemaConverter")
public class SistemaConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext fc, UIComponent componente, String valor) {        
        try{
            int codigo = Integer.parseInt(valor);
            SistemaDao dao = new SistemaDao();
            Sistema sistema = dao.BuscarPorCodigo(codigo);
            return sistema;
        }catch(RuntimeException |SQLException ex){
            return null;
        }              
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent componente, Object objeto) {
       try{
        Sistema sistema =(Sistema) objeto;
        Integer codigo = sistema.getCodigo();
        return codigo.toString();
      }catch(RuntimeException ex){
        return null;        
    }
    }
   
}

