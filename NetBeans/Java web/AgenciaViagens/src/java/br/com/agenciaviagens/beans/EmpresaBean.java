package br.com.agenciaviagens.beans;

import br.com.agenciaviagens.dao.EmpresaDao;
import br.com.agenciaviagens.domain.Empresa;
import br.com.agenciaviagens.util.JSFUtil;
import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "MBEmpresa")
@ViewScoped
public class EmpresaBean {

    Empresa empresa;

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public void iniciar() {
        empresa = new Empresa();
    }

    public void salvar() {
        EmpresaDao dao = new EmpresaDao();
        try {
            dao.Salvar(empresa);
            JSFUtil.mensagemSucesso("Cadastro realizado com sucesso!!!\r\nAguarde a liberação de seu plano");
        } catch (SQLException ex) {
            JSFUtil.mensagemSucesso("Erro ao cadastrar" + ex);
        }
    }
}
