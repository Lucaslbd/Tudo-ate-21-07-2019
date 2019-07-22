package Vbox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;

public class FXMLVboxController implements Initializable {    

    @FXML
    private AnchorPane anchorPane;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    void CadastroClientes() {
        try {
            AnchorPane e = (AnchorPane) FXMLLoader.load(getClass().getResource("FXMLCadastroClientes.fxml"));
            anchorPane.getChildren().setAll(e);
        } catch (IOException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Erro ao carregar tela");
            alert.setContentText(ex.getMessage());
            alert.show();
        }
    }

    @FXML
    void RelatorioVendas() {
        try {
            AnchorPane e = (AnchorPane) FXMLLoader.load(getClass().getResource("FXMLRelatorio.fxml"));
            anchorPane.getChildren().setAll(e);
        } catch (IOException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Erro ao carregar tela");
            alert.setContentText(ex.getMessage());
            alert.show();
        }
    }    

    @FXML
    void Sair() {
        System.exit(0);
    }

}
