package br.com.jlsistemas.converter;


import br.com.jlsistemas.dao.EmpresaDao;
import br.com.jlsistemas.dao.SistemaDao;
import br.com.jlsistemas.domain.Empresa;
import br.com.jlsistemas.domain.Sistema;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;


@FacesConverter("EmpresaConverter")
public class EmpresaConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext fc, UIComponent componente, String valor) {        
        try{
            int codigo = Integer.parseInt(valor);
            EmpresaDao dao = new EmpresaDao();
            Empresa empresa = dao.listarPorCodigo(codigo);
            return empresa;
        }catch(RuntimeException ex){
            return null;
        }              
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent componente, Object objeto) {
       try{
        Empresa empresa =(Empresa) objeto;
        Integer codigo = empresa.getCodigo();
        return codigo.toString();
      }catch(RuntimeException ex){
        return null;        
    }
    }
   
}

