package br.com.deposito.bean;

import br.com.deposito.dao.OpniaoDao;
import br.com.deposito.domain.Opniao;
import br.com.deposito.util.JSFUtil;
import java.sql.SQLException;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "MBOpniao")
@ViewScoped
public class OpniaoBean {

    Opniao opniao = new Opniao();
    @ManagedProperty(value = "#{MBAutenticacao}")
    private BeanAutenticar MBAutenticacao;

    public Opniao getOpniao() {
        return opniao;
    }

    public void setOpniao(Opniao opniao) {
        this.opniao = opniao;
    }

    public BeanAutenticar getMBAutenticacao() {
        return MBAutenticacao;
    }

    public void setMBAutenticacao(BeanAutenticar MBAutenticacao) {
        this.MBAutenticacao = MBAutenticacao;
    }

    public void salvar() {
        OpniaoDao dao = new OpniaoDao();
        try {
            opniao.setData(new Date());
            opniao.setDeposito(MBAutenticacao.getUsuario().getDeposito());
            dao.Salvar(opniao);
            opniao = new Opniao();
            JSFUtil.mensagemSucesso("Agradecemos sua colaboração, entraremos em contato em breve");
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao registrar opniao" + ex);
        }
    }
}
