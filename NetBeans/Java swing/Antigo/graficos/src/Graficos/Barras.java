package Graficos;

import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class Barras extends JFrame {

    public Barras() {
        initComponets();
    }

    private void initComponets() {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Gráfico de barras");
        setSize(750, 400);
        setResizable(false);
        setLocationRelativeTo(null);
        criarGrafico();
        setVisible(true);
    }

    private void criarGrafico() {
        DefaultCategoryDataset barra = new DefaultCategoryDataset();
        barra.setValue(1400, "Janeiro", "Numero de vendas:");
        barra.setValue(1500, "Fevereiro", "Numero de vendas:");
        barra.setValue(3000, "Março", "Numero de vendas:");
        barra.setValue(2000, "Abril", "Numero de vendas:");
        barra.setValue(1000, "Maio", "Numero de vendas:");
        barra.setValue(5000, "Junho", "Numero de vendas:");
        barra.setValue(4500, "Julho", "Numero de vendas:");
        barra.setValue(1400, "Agosto", "Numero de vendas:");
        barra.setValue(1500, "Setembro", "Numero de vendas:");
        barra.setValue(3000, "Outubro", "Numero de vendas:");
        barra.setValue(2000, "Novembro", "Numero de vendas:");
        barra.setValue(1000, "Dezembro", "Numero de vendas:");
        JFreeChart grafico = ChartFactory.createBarChart3D("Gráfico de vendas", "Meses,", "Quantidade", barra, PlotOrientation.VERTICAL, true, true, false);
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