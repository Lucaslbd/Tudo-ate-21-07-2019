package Vbox;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.XYChart;

public class FXMLRelatorioController implements Initializable {

    @FXML
    private BarChart<String, Integer> barChart;

    @FXML
    private CategoryAxis xAxis;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        XYChart.Series<String, Integer> series = new XYChart.Series<>();
        series.setName("2018");
        series.getData().add(new XYChart.Data<>("Janeiro", 20));
        series.getData().add(new XYChart.Data<>("Fevereiro", 40));
        series.getData().add(new XYChart.Data<>("Março", 30));
        series.getData().add(new XYChart.Data<>("Abril", 100));
        barChart.getData().add(series);
    }

}
//ObservableList<String> obsMeses = FXCollections.observableArrayList();
//ObservableList<Integer> obsQuantidade = FXCollections.observableArrayList();
