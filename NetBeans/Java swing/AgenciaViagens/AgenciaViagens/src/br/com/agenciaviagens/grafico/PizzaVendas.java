package br.com.agenciaviagens.grafico;

import java.util.ArrayList;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class PizzaVendas extends JFrame {

    ArrayList<GraficoVendas> lista;

    public PizzaVendas(ArrayList<GraficoVendas> l) {
        lista = l;
        initComponets();
    }

    private void initComponets() {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Gráfico de pizza");
        setSize(700, 400);
        setResizable(false);
        criarGrafico();
        setVisible(true);
    }

    private void criarGrafico() {
        DefaultPieDataset pizza = new DefaultPieDataset();
        for (GraficoVendas v : lista) {
            pizza.setValue(v.getTipo(), v.getValor());
        }
        JFreeChart grafico = ChartFactory.createPieChart(lista.get(0).getTitulo(), pizza, true, true, false);
        ChartPanel painel = new ChartPanel(grafico);
        add(painel);
    }
}
