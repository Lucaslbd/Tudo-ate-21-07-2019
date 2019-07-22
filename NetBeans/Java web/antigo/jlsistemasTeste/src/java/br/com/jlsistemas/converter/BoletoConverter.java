package br.com.jlsistemas.converter;


import br.com.jlsistemas.dao.BoletoDao;
import br.com.jlsistemas.domain.DomainBoleto;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;


@FacesConverter("BoletoConverter")
public class BoletoConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext fc, UIComponent componente, String valor) {        
        try{
            int codigo = Integer.parseInt(valor);
            BoletoDao dao = new BoletoDao();
            DomainBoleto boleto = dao.listarPorCodigo(codigo);
            return boleto;
        }catch(RuntimeException ex){
            return null;
        }              
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent componente, Object objeto) {
       try{
        DomainBoleto boleto =(DomainBoleto) objeto;
        Integer codigo = boleto.getCodigo();
        return codigo.toString();
      }catch(RuntimeException ex){
        return null;        
    }
    }
   
}

