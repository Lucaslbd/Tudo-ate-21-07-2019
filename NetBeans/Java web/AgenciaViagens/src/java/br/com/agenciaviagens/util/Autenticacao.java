package br.com.agenciaviagens.util;

import br.com.agenciaviagens.beans.MBAutenticacao;
import br.com.agenciaviagens.domain.Empresa;
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
public class Autenticacao implements PhaseListener {

    @Override
    public void afterPhase(PhaseEvent event) {
        try {
            FacesContext facesContext = event.getFacesContext();
            UIViewRoot uIViewRoot = facesContext.getViewRoot();
            String paginaAtual = uIViewRoot.getViewId();
            boolean ehPaginaAutenticacao = paginaAtual.contains("index.xhtml");
            if (!ehPaginaAutenticacao) {
                ExternalContext externalContext = facesContext.getExternalContext();
                Map<String, Object> mapa = externalContext.getSessionMap();
                MBAutenticacao beanAutenticacao = (MBAutenticacao) mapa.get("MBAutenticacao");
                /**/ Empresa empresa = beanAutenticacao.getEmpresa();
                if (empresa == null) {
                    JSFUtil.mensagemErro("Acesso não autenticado");
                    Application aplication = facesContext.getApplication();
                    NavigationHandler navigationHandler = aplication.getNavigationHandler();
                    navigationHandler.handleNavigation(facesContext, null, "index.xhtml?faces-redirect=true");
                }
            }
        } catch (Exception ex) {
            JSFUtil.mensagemAviso("Tempo de sessão esgotado");
            FacesContext facesContext = event.getFacesContext();
            Application aplication = facesContext.getApplication();
            NavigationHandler navigationHandler = aplication.getNavigationHandler();
            navigationHandler.handleNavigation(facesContext, null, "index.xhtml?faces-redirect=true");
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
