package javafxbasico;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

public class FXMLAlertController implements Initializable {
    
    @FXML
    private Button btAlert;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    
    @FXML
    void abrirAlert(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Titulo");
        alert.setHeaderText("Cabeçalho");
        alert.setContentText("Conteudo");
        alert.show();
    }
    
}
