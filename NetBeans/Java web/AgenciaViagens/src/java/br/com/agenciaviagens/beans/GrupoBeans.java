package br.com.agenciaviagens.beans;

import br.com.agenciaviagens.dao.GrupoDao;
import br.com.agenciaviagens.dao.PassageiroDao;
import br.com.agenciaviagens.domain.Grupo;
import br.com.agenciaviagens.domain.Passageiro;
import br.com.agenciaviagens.ralatorio.ListaPassageiro;
import br.com.agenciaviagens.ralatorio.ListaPassageiroDao;
import br.com.agenciaviagens.util.JSFUtil;
import br.com.agenciaviagens.util.UtilitarioDao;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import net.sf.jasperreports.engine.JRException;

@ManagedBean(name = "MBGrupo")
@ViewScoped
public class GrupoBeans {

    private int codigo;
    private int acao;
    private Grupo grupo;
    private ArrayList<Grupo> lista;
    private ArrayList<Grupo> listaFiltrada;
    private int pax;
    private int pagantes;
    private int agregados;
    private int tripulacao;
    private double relativo;
    private double relativoTotal;
    private double custoFixo;
    private double custoTotal;
    private double valorVenda;   
    private double vendaTotal;
    private ArrayList<Passageiro> listapax;
    private ArrayList<Passageiro> listaFiltradapax;

    public ArrayList<Passageiro> getListapax() {
        return listapax;
    }

    public void setListapax(ArrayList<Passageiro> listapax) {
        this.listapax = listapax;
    }

    public ArrayList<Passageiro> getListaFiltradapax() {
        return listaFiltradapax;
    }

    public void setListaFiltradapax(ArrayList<Passageiro> listaFiltradapax) {
        this.listaFiltradapax = listaFiltradapax;
    }

    public double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(double valorVenda) {
        this.valorVenda = valorVenda;
    }
    
    public double getVendaTotal() {
        return vendaTotal;
    }

    public void setVendaTotal(double vendaTotal) {
        this.vendaTotal = vendaTotal;
    }

    public double getCustoFixo() {
        return custoFixo;
    }

    public void setCustoFixo(double custoFixo) {
        this.custoFixo = custoFixo;
    }

    public double getCustoTotal() {
        return custoTotal;
    }

    public void setCustoTotal(double custoTotal) {
        this.custoTotal = custoTotal;
    }

    public double getRelativo() {
        return relativo;
    }

    public void setRelativo(double relativo) {
        this.relativo = relativo;
    }

    public int getPagantes() {
        return pagantes;
    }

    public void setPagantes(int pagantes) {
        this.pagantes = pagantes;
    }

    public int getAgregados() {
        return agregados;
    }

    public void setAgregados(int agregados) {
        this.agregados = agregados;
    }

    public int getTripulacao() {
        return tripulacao;
    }

    public void setTripulacao(int tripulacao) {
        this.tripulacao = tripulacao;
    }

    public int getPax() {
        return pax;
    }

    public void setPax(int pax) {
        this.pax = pax;
    }

    public double getRelativoTotal() {
        return relativoTotal;
    }

    public void setRelativoTotal(double relativoTotal) {
        this.relativoTotal = relativoTotal;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public ArrayList<Grupo> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Grupo> lista) {
        this.lista = lista;
    }

    public ArrayList<Grupo> getListaFiltrada() {
        return listaFiltrada;
    }

    public void setListaFiltrada(ArrayList<Grupo> listaFiltrada) {
        this.listaFiltrada = listaFiltrada;
    }

    @ManagedProperty(value = "#{MBAutenticacao}")
    private MBAutenticacao MBAutenticacao;

    public MBAutenticacao getMBAutenticacao() {
        return MBAutenticacao;
    }

    public void setMBAutenticacao(MBAutenticacao MBAutenticacao) {
        this.MBAutenticacao = MBAutenticacao;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getAcao() {
        return acao;
    }

    public void setAcao(int acao) {
        this.acao = acao;
    }

    /*----------------------------------Codigo--------------------------------------------------------------------*/
    public void salvar() {
        GrupoDao dao = new GrupoDao(MBAutenticacao.getEmpresa().getNumeroBanco());
        try {
            dao.Salvar(grupo);
            JSFUtil.mensagemSucesso("Grupo registrado com sucesso");
            FacesContext.getCurrentInstance().getExternalContext().redirect("grupo.xhtml");
        } catch (SQLException | IOException ex) {
            JSFUtil.mensagemErro("Erro ao registrar grupo" + ex);
        }
    }

    public void alterar() {
        GrupoDao dao = new GrupoDao(MBAutenticacao.getEmpresa().getNumeroBanco());
        try {
            dao.Alterar(grupo);
            JSFUtil.mensagemSucesso("Grupo alterado com sucesso");
            FacesContext.getCurrentInstance().getExternalContext().redirect("grupo.xhtml");
        } catch (SQLException | IOException ex) {
            JSFUtil.mensagemErro("Erro ao alterar grupo" + ex);
        }
    }

    public void alterarStatus(int c) {
        GrupoDao dao = new GrupoDao(MBAutenticacao.getEmpresa().getNumeroBanco());
        try {
            Grupo g = dao.buscarPorCodigo(c);
            dao.AlterarStatus(g);
            listar();
            JSFUtil.mensagemSucesso("Status alterado com sucesso");
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao alterar grupo" + ex);
        }
    }

    public void excluir(int c) {
        GrupoDao dao = new GrupoDao(MBAutenticacao.getEmpresa().getNumeroBanco());
        try {
            dao.excluir(c);
            listar();
            JSFUtil.mensagemSucesso("Grupo removido com sucesso");
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao excluir grupo" + ex);
        }
    }

    public void listar() {
        GrupoDao dao = new GrupoDao(MBAutenticacao.getEmpresa().getNumeroBanco());
        try {
            lista = dao.Listar();
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao listar grupo" + ex);
        }
    }

    public void carregarCadastro() {
        GrupoDao dao = new GrupoDao(MBAutenticacao.getEmpresa().getNumeroBanco());
        try {
            if (acao == 1) {
                grupo = new Grupo();
            } else {
                grupo = dao.buscarPorCodigo(codigo);
                calcularLucro();
            }
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao buscar grupo por codigo " + ex);
        }
    }

    public void listarPax(int c) {
        PassageiroDao dao = new PassageiroDao(MBAutenticacao.getEmpresa().getNumeroBanco());
        try {
            listapax = dao.Listar(c);
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao listar fornecedor" + ex);
        }
    }

    public void calcularLucro() {
        pax = grupo.getPax();        
        tripulacao = grupo.getTripulacao();
        custoFixo = grupo.getCusto_fixo();
        valorVenda = grupo.getValor_venda();
        pagantes = pax - (tripulacao + agregados);        
        relativo = grupo.getCusto_relativo();
        relativoTotal = relativo * pagantes;
        custoTotal = custoFixo + relativoTotal;
        vendaTotal = valorVenda * pagantes;
    }

    public void listaPassageiro() {
        if (listapax.isEmpty()) {
            JSFUtil.mensagemAviso("Não existem passageiros na lista");
        } else {
            UtilitarioDao util = new UtilitarioDao();
            int i = 1;
            ArrayList<ListaPassageiro> listapassageiro = new ArrayList<>();
            for (Passageiro p : listapax) {
                ListaPassageiro passageiro = new ListaPassageiro();
                passageiro.setData(util.dateXstring(p.getGrupo().getData()) + " | " + p.getGrupo().getNome_grupo());
                passageiro.setEmbarque(" " + p.getLocalEmbarque());               
                passageiro.setNomePax(" " + p.getCliente().getNome());
                passageiro.setNum(" " + i);
                passageiro.setRg(" " + p.getCliente().getRg());
                passageiro.setTelefone(" "+ p .getCliente().getTelefone());
                listapassageiro.add(passageiro);
                i++;
            }
            ListaPassageiroDao d = new ListaPassageiroDao();
            try {
                d.Imprimir(listapassageiro);
            } catch (JRException | IOException ex) {
                JSFUtil.mensagemErro("Erro ao buscar compras do cliente " + ex);
            }
        }
    }
}
