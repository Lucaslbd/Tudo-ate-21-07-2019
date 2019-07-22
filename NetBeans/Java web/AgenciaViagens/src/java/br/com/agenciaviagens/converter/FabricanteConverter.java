package br.com.agenciaviagens.converter;


import br.com.agenciaviagens.beans.MBAutenticacao;
import br.com.agenciaviagens.dao.FornecedorDao;
import br.com.agenciaviagens.domain.Fornecedor;
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
            FornecedorDao dao = new FornecedorDao(MBAutenticacao.empresa.getNumeroBanco());
            Fornecedor fornecedor = dao.buscarPorCodigo(codigo);
            return fornecedor;
        }catch(Exception ex){
            return null;
        }              
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent componente, Object objeto) {
       try{
        Fornecedor fornecedor =(Fornecedor) objeto;
        Integer codigo = fornecedor.getCodigo();
        return codigo.toString();
      }catch(RuntimeException ex){
        return null;        
    }
    }
   
}

