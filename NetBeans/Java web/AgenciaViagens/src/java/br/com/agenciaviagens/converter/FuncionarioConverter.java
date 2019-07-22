package br.com.agenciaviagens.converter;


import br.com.agenciaviagens.beans.MBAutenticacao;
import br.com.agenciaviagens.dao.FuncionarioDao;
import br.com.agenciaviagens.domain.Funcionario;
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
            FuncionarioDao dao = new FuncionarioDao(MBAutenticacao.empresa.getNumeroBanco());
            Funcionario funcionario = dao.buscarPorCodigo(codigo);
            return funcionario;
        }catch(Exception ex){
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

