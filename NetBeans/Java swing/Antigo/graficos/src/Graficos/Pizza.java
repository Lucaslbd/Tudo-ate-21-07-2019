package Graficos;

import java.awt.Color;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

public class Pizza extends JFrame {

    public Pizza() {
        initComponets();
    }

    private void initComponets() {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Gráfico de pizza");
        setSize(700, 400);
        setResizable(false);
        setLocationRelativeTo(null);
        criarGrafico();
        setVisible(true);
    }

    private void criarGrafico() {
        DefaultPieDataset pizza = new DefaultPieDataset();
        pizza.setValue("Brasil", 5);
        pizza.setValue("Alemanha", 4);
        pizza.setValue("Itália", 4);
        pizza.setValue("Argentina", 2);
        pizza.setValue("Uruguai", 2);
        pizza.setValue("Inglaterra", 2);
        pizza.setValue("França", 1);
        JFreeChart grafico = ChartFactory.createPieChart("Campeões mundiais", pizza, true, true, false);
        PiePlot fatia = (PiePlot) grafico.getPlot();
        fatia.setSectionPaint("Brasil", Color.yellow);
        fatia.setSectionPaint("Alemanha", Color.BLACK);
        ChartPanel painel = new ChartPanel(grafico);
        add(painel);
    }   
}
