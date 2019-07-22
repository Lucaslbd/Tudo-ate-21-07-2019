package br.com.agenciaviagens.grafico;

import br.com.agenciaviagens.beans.MBAutenticacao;
import br.com.agenciaviagens.domain.Venda;
import br.com.agenciaviagens.util.JSFUtil;
import br.com.agenciaviagens.util.UtilitarioDao;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.BarChartSeries;

@ManagedBean(name = "MBGrafico")
@ViewScoped
public class GraficoVendasBean {
    
    private BarChartModel lineModel = new BarChartModel();
    BarChartModel modelo = new BarChartModel();
    BarChartSeries serie = new BarChartSeries();
    ArrayList<String> listaAnos;
    ArrayList<Venda> listaVenda;
    private String anoDesejado;    
    UtilitarioDao util = new UtilitarioDao();
    @ManagedProperty(value = "#{MBAutenticacao}")
    private MBAutenticacao MBAutenticacao;

    public MBAutenticacao getMBAutenticacao() {
        return MBAutenticacao;
    }

    public void setMBAutenticacao(MBAutenticacao MBAutenticacao) {
        this.MBAutenticacao = MBAutenticacao;
    }

    public String getAnoDesejado() {
        return anoDesejado;
    }

    public void setAnoDesejado(String anoDesejado) {
        this.anoDesejado = anoDesejado;
    }

    public ArrayList<Venda> getListaVenda() {
        return listaVenda;
    }

    public void setListaVenda(ArrayList<Venda> listaVenda) {
        this.listaVenda = listaVenda;
    }

    public ArrayList<String> getListaAnos() {
        return listaAnos;
    }

    public void setListaAnos(ArrayList<String> listaAnos) {
        this.listaAnos = listaAnos;
    }

    public BarChartModel getLineModel() {
        return lineModel;
    }

    /*--------------------------------------------------------------------------------------------*/
    private BarChartModel iniciarModeloLinear() {
        GraficoVendasDao dao = new GraficoVendasDao(MBAutenticacao.getEmpresa().getNumeroBanco());
        lineModel = new BarChartModel();
        modelo = new BarChartModel();
        serie = new BarChartSeries();
        try {
            listaVenda = dao.listarVendasFornecedorPorAno(anoDesejado);
        } catch (SQLException | ParseException ex) {
            JSFUtil.mensagemSucesso("Erro ao listar anos trabalhados " + ex);
        }
        ArrayList<GraficoVendas> listaGrafico = new ArrayList<>();

        for (Venda v : listaVenda) {
            int PosicaoEncontrada = -1;
            for (int i = 0; i < listaGrafico.size() && PosicaoEncontrada < 0; i++) {
                GraficoVendas comparacao = listaGrafico.get(i);
                if (comparacao.getData().equals(util.mesEano(v.getDataVenda()))) {
                    PosicaoEncontrada = i;
                }
            }
            GraficoVendas grafico = new GraficoVendas();
            grafico.setValor(v.getValorReceber() - v.getComissaoFunc());
            if (PosicaoEncontrada < 0) {
                grafico.setData(util.mesEano(v.getDataVenda()));
                listaGrafico.add(grafico);
            } else {
                GraficoVendas temp = listaGrafico.get(PosicaoEncontrada);
                temp.setValor(grafico.getValor() + temp.getValor());
                listaGrafico.set(PosicaoEncontrada, temp);
            }
            for (GraficoVendas g : listaGrafico) {
                serie.set(g.getData(), g.getValor());
            }
        }
        serie.setLabel(anoDesejado);
        modelo.addSeries(serie);
        return modelo;
    }

    public void montarGrafico() {
        lineModel = iniciarModeloLinear();
        lineModel.setLegendPosition("e"); //e=east / n=north
        lineModel.setDatatipFormat("R$ %2$.2f");
        Axis yAxis = lineModel.getAxis(AxisType.Y);
        yAxis.setTickFormat("%d");
        yAxis.setLabel("Valor");
        lineModel.setTitle("Gráfico de lucratividade");
        lineModel.setAnimate(true);
        Axis xAxis = lineModel.getAxis(AxisType.X);
        xAxis.setTickFormat("%d");
        xAxis.setLabel("Data");
    }

    public void anosTrabalhados() {
        GraficoVendasDao dao = new GraficoVendasDao(MBAutenticacao.getEmpresa().getNumeroBanco());
        try {
            listaVenda = dao.listarVendasFornecedor();
            listaAnos = new ArrayList<>();
            for (Venda v : listaVenda) {
                String ano = util.retornaAno(v.getDataVenda());
                if (!listaAnos.contains(ano)) {
                    listaAnos.add(ano);
                }
            }
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao listar anos trabalhados " + ex);
        }
    }
}
