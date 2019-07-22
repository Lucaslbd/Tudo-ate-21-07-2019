package br.com.deposito.bean;

import br.com.deposito.dao.FechamentoCaixaDao;
import br.com.deposito.dao.VendaDao;
import br.com.deposito.domain.Venda;
import br.com.deposito.relatorio.VendaRelatorio;
import br.com.deposito.relatorio.VendaRelatorioDao;
import br.com.deposito.util.JSFUtil;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import net.sf.jasperreports.engine.JRException;

@ManagedBean(name = "MBVenda")
@ViewScoped
public class VendaBean {

    private Venda venda;
    private ArrayList<Venda> listaVenda;
    private ArrayList<Venda> listaVendaFiltrada;
    @ManagedProperty(value = "#{MBAutenticacao}")
    private BeanAutenticar MBAutenticacao;
    DecimalFormat df = new DecimalFormat("###,###,##0.00");
    private Date data1;
    private Date data2;
    private boolean controle = false;

    public boolean isControle() {
        return controle;
    }

    public void setControle(boolean controle) {
        this.controle = controle;
    }
    
    public DecimalFormat getDf() {
        return df;
    }

    public void setDf(DecimalFormat df) {
        this.df = df;
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

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public ArrayList<Venda> getListaVenda() {
        if (listaVenda == null) {
            listaVenda = new ArrayList<>();
        }
        return listaVenda;
    }

    public void setListaVenda(ArrayList<Venda> listaVenda) {
        this.listaVenda = listaVenda;
    }

    public ArrayList<Venda> getListaVendaFiltrada() {
        if (listaVendaFiltrada == null) {
            listaVendaFiltrada = new ArrayList<>();
        }
        return listaVendaFiltrada;
    }

    public void setListaVendaFiltrada(ArrayList<Venda> listaVendaFiltrada) {
        this.listaVendaFiltrada = listaVendaFiltrada;
    }

    public BeanAutenticar getMBAutenticacao() {
        return MBAutenticacao;
    }

    public void setMBAutenticacao(BeanAutenticar MBAutenticacao) {
        this.MBAutenticacao = MBAutenticacao;
    }

    //Aqui começa a implementação---------------------------------------------------------------------------
    public void listar() {
        VendaDao dao = new VendaDao();
        try {
            listaVenda = dao.Listar(MBAutenticacao.getUsuario().getDeposito().getCodigo(), data1, data2);
            controle = true;
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao listar vendas " + ex);
        }
    }

    public void excluir() {
        VendaDao dao = new VendaDao();
        FechamentoCaixaDao daoFecha = new FechamentoCaixaDao();
        try {
            dao.excluir(venda);
            daoFecha.Cancelar(venda);
            listar();
            JSFUtil.mensagemSucesso("Venda removida com sucesso");
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao remover venda " + ex);
        }
    }

    public void somarApurado() {
        double valor = 0;
        if (listaVendaFiltrada.isEmpty()) {
            for (Venda g : listaVenda) {
                valor += g.getValor();
            }
        } else {
            for (Venda v : listaVendaFiltrada) {
                valor += v.getValor();
            }
        }
        String v = df.format(valor);
        JSFUtil.mensagemSucesso("Apurado total R$ " + v);
    }

    public void somarCusto() {
        double valor = 0;
        if (listaVendaFiltrada.isEmpty()) {
            for (Venda g : listaVenda) {
                valor += g.getCusto();
            }
        } else {
            for (Venda v : listaVendaFiltrada) {
                valor += v.getCusto();
            }
        }
        String v = df.format(valor);
        JSFUtil.mensagemSucesso("Custo total R$ " + v);
    }

    public void somarLucro() {
        double valor = 0;
        double diminuir = 0;
        if (listaVendaFiltrada.isEmpty()) {
            for (Venda g : listaVenda) {
                diminuir += g.getValor() * (g.getDesconto() / 100);
                valor += g.getValor() - g.getCusto();
            }
        } else {
            for (Venda v : listaVendaFiltrada) {
                diminuir += v.getValor() * (v.getDesconto() / 100);
                valor += v.getValor() - v.getCusto();
            }
        }
        String v = df.format(valor - diminuir);
        JSFUtil.mensagemSucesso("Lucro total R$ " + v);
    }

    public void porcentagem() {
        if (listaVenda == null) {
            listaVenda = new ArrayList<>();
        }
        double valor = 0;
        double lucro = 0;
        if (listaVendaFiltrada.isEmpty()) {
            for (Venda g : listaVenda) {
                lucro += g.getValor() - g.getCusto() - (g.getValor() * (g.getDesconto() / 100));
                valor += g.getValor();
            }
        } else {
            for (Venda g : listaVendaFiltrada) {
                lucro += g.getValor() - g.getCusto() - (g.getValor() * (g.getDesconto() / 100));
                valor += g.getValor();
            }
        }
        String v = df.format((lucro / valor) * 100);
        JSFUtil.mensagemSucesso("Porcentagem de lucro " + v + " %");
    }

    public void imprimirRelatorio() {
        if (listaVenda == null) {
            listaVenda = new ArrayList<>();
        }
        if (listaVenda.isEmpty()) {
            JSFUtil.mensagemErro("A lista de vendas está vazia");
        } else {
            VendaRelatorio objeto = new VendaRelatorio();
            int qtdTotal = listaVenda.size();
            double apurado = 0;
            double lucro = 0;
            int qtdEntregas = 0;
            double apuradoEntregas = 0;
            double lucroEntregas = 0;
            int qtdPortaria = 0;
            double apuradoPortaria = 0;
            double lucroPortaria = 0;
            int cartao = 0;
            int dinheiro = 0;
            int crediario = 0;
            int cheque = 0;

            for (Venda v : listaVenda) {
                apurado += v.getValor();
                lucro += v.getValor() - v.getCusto() - (v.getValor() * (v.getDesconto() / 100));
                String dx = df.format(lucro / apurado * 100) + " %";
                objeto.setTotalPorcento(dx);
                if (v.getEntrega().equals("Com entrega")) {
                    qtdEntregas++;
                    apuradoEntregas += v.getValor();
                    lucroEntregas += v.getValor() - v.getCusto() - (v.getValor() * (v.getDesconto() / 100));
                    String dx1 = df.format(lucroEntregas / apuradoEntregas * 100) + " %";
                    objeto.setEntregaPorcento(dx1);
                } else {
                    qtdPortaria++;
                    apuradoPortaria += v.getValor();
                    lucroPortaria += v.getValor() - v.getCusto() - (v.getValor() * (v.getDesconto() / 100));
                    String dx2 = df.format(lucroPortaria / apuradoPortaria * 100) + " %";
                    objeto.setPortaPorcento(dx2);
                }
                switch (v.getFormaPagamento()) {
                    case "Dinheiro":
                        dinheiro++;
                        break;
                    case "Cartão de credito":
                        cartao++;
                        break;
                    case "Cartão de debito":
                        cartao++;
                        break;
                    case "Cheque":
                        cheque++;
                        break;
                    case "Crediário":
                        crediario++;
                        break;
                    default:
                        break;
                }
            }
            objeto.setData1(data1);
            objeto.setData2(data2);
            objeto.setApurado(apurado);
            objeto.setApuradoEntregas(apuradoEntregas);
            objeto.setApuradoPortaria(apuradoPortaria);
            objeto.setCartao(cartao);
            objeto.setCheque(cheque);
            objeto.setCrediario(crediario);
            objeto.setDinheiro(dinheiro);
            objeto.setLucro(lucro);
            objeto.setLucroEntregas(lucroEntregas);
            objeto.setLucroPortaria(lucroPortaria);
            objeto.setQtdEntregas(qtdEntregas);
            objeto.setQtdPortaria(qtdPortaria);
            objeto.setQtdTotal(qtdTotal);
            ArrayList<VendaRelatorio> Relatorio = new ArrayList();
            Relatorio.add(objeto);
            VendaRelatorioDao ven = new VendaRelatorioDao();
            try {
                ven.Imprimir(Relatorio);
            } catch (JRException | IOException ex) {
                JSFUtil.mensagemErro("Erro " + ex);
            }

        }
    }

    public String paginaVenda() {
        JSFUtil.mensagemSucesso("Modo de visualização 'Item' ");
        return "ConsultaItem.xhtml?faces-redirect=true";
    }
}
