package br.com.deposito.bean;

import br.com.deposito.dao.FuncionarioDao;
import br.com.deposito.dao.GastoFuncionarioDao;
import br.com.deposito.relatorio.FolhaPagamento;
import br.com.deposito.domain.Funcionario;
import br.com.deposito.domain.GastoFuncionario;
import br.com.deposito.domain.Inss;
import br.com.deposito.domain.Irrf;
import br.com.deposito.relatorio.FolhaPagamentoDao;
import br.com.deposito.util.JSFUtil;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import net.sf.jasperreports.engine.JRException;

@ManagedBean(name = "MBFuncionario")
@ViewScoped
public class FuncionarioBean {

    private Funcionario funcionario;
    private ArrayList<Funcionario> lista;
    private ArrayList<Funcionario> listaFiltrada;
    @ManagedProperty(value = "#{MBAutenticacao}")
    private BeanAutenticar MBAutenticacao;
    private ArrayList<GastoFuncionario> listaPagamento;
    private Date data1;
    private Date data2;
    private boolean control = false;

    public boolean isControl() {
        return control;
    }

    public void setControl(boolean control) {
        this.control = control;
    }

    public Date getData1() {
        return data1;
    }

    public void setData1(Date data1) {
        this.data1 = data1;
    }

    public Date getData2() {
        return data2;
    }

    public void setData2(Date data2) {
        this.data2 = data2;
    }

    public ArrayList<GastoFuncionario> getListaPagamento() {
        return listaPagamento;
    }

    public void setListaPagamento(ArrayList<GastoFuncionario> listaPagamento) {
        this.listaPagamento = listaPagamento;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public ArrayList<Funcionario> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Funcionario> lista) {
        this.lista = lista;
    }

    public ArrayList<Funcionario> getListaFiltrada() {
        return listaFiltrada;
    }

    public void setListaFiltrada(ArrayList<Funcionario> listaFiltrada) {
        this.listaFiltrada = listaFiltrada;
    }

    public BeanAutenticar getMBAutenticacao() {
        return MBAutenticacao;
    }

    public void setMBAutenticacao(BeanAutenticar MBAutenticacao) {
        this.MBAutenticacao = MBAutenticacao;
    }

    // Aqui começa toda a implementação--------------------------------------------------------------
    public void listar() {
        FuncionarioDao dao = new FuncionarioDao();
        try {
            lista = dao.Listar(MBAutenticacao.getUsuario().getDeposito().getCodigo());
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao listar funcionarios " + ex);
        }
    }

    public void atualizarObjeto() {
        funcionario = new Funcionario();
    }

    public void salvar() {
        FuncionarioDao dao = new FuncionarioDao();
        try {
            funcionario.setDeposito(MBAutenticacao.getUsuario().getDeposito());
            dao.Salvar(funcionario);
            JSFUtil.mensagemSucesso("Funcionario registrado com sucesso");
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao registrar funcionario" + ex);
        }
    }

    public void alterar() {
        FuncionarioDao dao = new FuncionarioDao();
        try {
            dao.Alterar(funcionario);
            JSFUtil.mensagemSucesso("Funcionario alterado com sucesso");
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao alterar funcionario " + ex);
        }
    }

    public void excluir() {
        FuncionarioDao dao = new FuncionarioDao();
        try {
            dao.excluir(funcionario);
            JSFUtil.mensagemSucesso("Funcionario removido com sucesso");
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao excluir funcionario " + ex);
        }
    }

    public void preencherPagamento() {
        GastoFuncionarioDao dao = new GastoFuncionarioDao();
        try {
            listaPagamento = dao.ListarPorFuncionario(funcionario.getCodigo(), data1, data2);
            if (listaPagamento.size() > 0) {
                control = true;
            }
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao listar pagamentos do funcionario " + ex);
        }
    }

    public void folhaPagamento() {
        ArrayList<FolhaPagamento> folha = new ArrayList<>();
        FuncionarioDao dao = new FuncionarioDao();
        ArrayList<Inss> listaInss = dao.listarInss();
        ArrayList<Irrf> listaIrrf = dao.listarIrrf();
        FolhaPagamento pagamento = new FolhaPagamento();
        for (GastoFuncionario gasto : listaPagamento) {
            String descricao = gasto.getDescricao();
            switch (descricao) {
                case "Pagamento":
                    pagamento.setPagamento(pagamento.getPagamento() + gasto.getValor());
                    break;
                case "Adiantamento":
                    pagamento.setAdiantamento(pagamento.getAdiantamento() + gasto.getValor());
                    break;
            }
        }
        boolean verificaInss = false;
        Inss inss = null;
        for (Inss i : listaInss) {
            if (funcionario.getSalario() > i.getValorInicial() && funcionario.getSalario() < i.getValorFinal()) {
                pagamento.setPorinss(i.getPorcentagem());
                pagamento.setInss(funcionario.getSalario() / 100 * i.getPorcentagem());
                verificaInss = true;
            }
            inss = i;
            if (verificaInss) {
                pagamento.setBaseinss(funcionario.getSalario());
                break;
            }
        }
        if (!verificaInss) {
            pagamento.setBaseinss(inss.getValorFinal());
            pagamento.setPorinss(inss.getPorcentagem());
            pagamento.setInss(inss.getValorFinal() / 100 * inss.getPorcentagem());
        }
        double baseIrrf = funcionario.getSalario() - pagamento.getInss();
        boolean verifica = false;
        for (Irrf i : listaIrrf) {
            if (baseIrrf > i.getValorInicial() && baseIrrf < i.getValorFinal()) {
                pagamento.setPorirrf(i.getPorcentagem());
                pagamento.setIrrf(baseIrrf / 100 * i.getPorcentagem() - i.getDevolver());
                verifica = true;
            }
            if (verifica) {
                break;
            }
        }
        if (!verifica) {
            pagamento.setPorirrf(0);
            pagamento.setIrrf(0);
        }
        pagamento.setBasefgts(funcionario.getSalario());
        pagamento.setBaseirrf(baseIrrf);
        pagamento.setTotal(funcionario.getSalario() - pagamento.getInss() - pagamento.getIrrf());
        pagamento.setNome(funcionario.getNome());
        pagamento.setSalario(funcionario.getSalario());
        pagamento.setFuncao(funcionario.getCargo());
        pagamento.setPorfgts(8);
        pagamento.setFgts(funcionario.getSalario() / 100 * 8);
        pagamento.setData1(data1);
        pagamento.setData2(data2);
        folha.add(pagamento);
        FolhaPagamentoDao d = new FolhaPagamentoDao();
        try {
            d.Imprimir(folha);
        } catch (IOException | JRException ex) {
            JSFUtil.mensagemErro("Erro ao gerar folha de pagamento " + ex);
        }
    }

    public void arrumar() {
        control = false;
    }
}
