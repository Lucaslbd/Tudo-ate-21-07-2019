package br.com.agenciaviagens.grafico;

import java.util.ArrayList;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class BarrasVendas extends JFrame {

    ArrayList<GraficoVendas> lista;

    public BarrasVendas(ArrayList<GraficoVendas> l) {
        lista = l;
        initComponets();
    }

    private void initComponets() {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Gráfico de barras");
        setSize(750, 400);
        setResizable(false);      
        criarGrafico();
        setVisible(true);
    }

    private void criarGrafico() {
        DefaultCategoryDataset barra = new DefaultCategoryDataset();
        for (GraficoVendas grafic : lista) {
            barra.setValue(grafic.getValor(), grafic.getMes(), grafic.getTipo());
        }
        JFreeChart grafico = ChartFactory.createBarChart3D(lista.get(0).getTitulo(), "Meses,", lista.get(0).getTipo(), barra, PlotOrientation.VERTICAL, true, true, false);
        ChartPanel painel = new ChartPanel(grafico);
        add(painel);
    }
}

/*CategoryPlot nu = grafico.getCategoryPlot();
        nu.getRenderer().setSeriesPaint(0, Color.WHITE);
        nu.getRenderer().setSeriesPaint(1, Color.ORANGE);
        nu.getRenderer().setSeriesPaint(2, Color.BLUE);
        nu.getRenderer().setSeriesPaint(3, Color.MAGENTA);
        nu.getRenderer().setSeriesPaint(4, Color.RED);
        nu.getRenderer().setSeriesPaint(5, Color.YELLOW);
        nu.getRenderer().setSeriesPaint(6, Color.WHITE);
        nu.getRenderer().setSeriesPaint(7, Color.WHITE);
        nu.getRenderer().setSeriesPaint(8, Color.WHITE);
        nu.getRenderer().setSeriesPaint(9, Color.WHITE);
        nu.getRenderer().setSeriesPaint(10, Color.WHITE);
        nu.getRenderer().setSeriesPaint(11, Color.WHITE);*/
