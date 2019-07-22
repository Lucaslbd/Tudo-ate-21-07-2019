package olamundojavafx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Button button;
    
    @FXML
    private Label label;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    
    @FXML
    void Clicar() {
        label.setText("Olá mundo");
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Clicando");
        alert.setHeaderText("");
        alert.setContentText("Olá mundo");
        alert.show();
    }
    
}
