package br.com.deposito.converter;

import br.com.deposito.dao.VeiculoDao;
import br.com.deposito.domain.Veiculos;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("veiculoConverter")
public class VeiculoConverter implements Converter{
 
    @Override
    public Object getAsObject(FacesContext fc, UIComponent componente, String valor) {        
        try{
            int codigo = Integer.parseInt(valor);
            VeiculoDao dao = new VeiculoDao();
            Veiculos veiculo = dao.buscarCodigo(codigo);
            return veiculo;
        }catch(RuntimeException ex){
            return null;
        }              
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent componente, Object objeto) {
       try{
        Veiculos veiculo =(Veiculos) objeto;
        Integer codigo = veiculo.getCodigo();
        return codigo.toString();
      }catch(RuntimeException ex){
        return null;        
    }
    }
    
}
