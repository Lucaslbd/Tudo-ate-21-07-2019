package br.com.drogaria.util;

import br.com.drogaria.beans.BeanAutenticacao;
import br.com.drogaria.domain.Funcionarios;
import java.util.Map;
import javax.faces.application.Application;
import javax.faces.application.NavigationHandler;
import javax.faces.component.UIViewRoot;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

@SuppressWarnings("serial")
public class Autenticacao implements PhaseListener{

    @Override
    public void afterPhase(PhaseEvent event) {
        FacesContext facesContext  = event.getFacesContext();
        UIViewRoot  uIViewRoot = facesContext .getViewRoot();
        String paginaAtual = uIViewRoot.getViewId();
        boolean ehPaginaAutenticacao = paginaAtual.contains("index.xhtml");
        if(!ehPaginaAutenticacao){
            ExternalContext externalContext = facesContext.getExternalContext();
            Map<String, Object> mapa = externalContext.getSessionMap();
            BeanAutenticacao beanAutenticacao = (BeanAutenticacao) mapa.get("MBAutenticacao");
            Funcionarios funcionario = beanAutenticacao.getFuncionarioLogado();
            if(funcionario.getFuncao() == null){
                JSFUtil.mensagemErro("Funcionario não autenticado");
                Application aplication = facesContext.getApplication();
                NavigationHandler navigationHandler = aplication.getNavigationHandler();
                navigationHandler.handleNavigation(facesContext,null,"index.xhtml?faces-redirect=true");
            }
        }
    }

    @Override
    public void beforePhase(PhaseEvent pe) {
        
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.RESTORE_VIEW;
    }
    
}
