package br.com.deposito.converter;


import br.com.deposito.dao.FuncionarioDao;
import br.com.deposito.domain.Funcionario;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;


@FacesConverter("funcionarioConverter")
public class FuncionarioConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext fc, UIComponent componente, String valor) {        
        try{
            int codigo = Integer.parseInt(valor);
            FuncionarioDao dao = new FuncionarioDao();
            Funcionario funcionario = dao.buscarCodigo(codigo);
            return funcionario;
        }catch(RuntimeException ex){
            return null;
        }              
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent componente, Object objeto) {
       try{
        Funcionario funcionario =(Funcionario) objeto;
        Integer codigo = funcionario.getCodigo();
        return codigo.toString();
      }catch(RuntimeException ex){
        return null;        
    }
    }
   
}

