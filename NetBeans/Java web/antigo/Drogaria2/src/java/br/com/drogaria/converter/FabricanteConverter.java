package br.com.drogaria.converter;


import br.com.drogaria.dao.FabricanteDAO;
import br.com.drogaria.domain.Fabricante;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;


@FacesConverter("fabricanteConverter")
public class FabricanteConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext fc, UIComponent componente, String valor) {
        
        try{
            int codigo = Integer.parseInt(valor);
            FabricanteDAO dao = new FabricanteDAO();
            Fabricante fabricante = dao.buscarPorCodigo(codigo);
            return fabricante;
        }catch(RuntimeException ex){
            return null;
        }              
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent componente, Object objeto) {
       try{
        Fabricante fabricante =(Fabricante) objeto;
        Integer codigo = fabricante.getCodigo();
        return codigo.toString();
      }catch(RuntimeException ex){
        return null;        
    }
    }
   
}

