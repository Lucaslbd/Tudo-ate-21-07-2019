package javafxbasico;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class FXMLButtonController implements Initializable {
    
    @FXML
    private Label label;
    
     @FXML
    private TextField txtNome;
    
    @FXML
    private void acionarBotao(ActionEvent event) {
        System.out.println("O botão foi clicado!");
        label.setText(txtNome.getText());
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
