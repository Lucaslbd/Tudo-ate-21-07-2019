package Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class LoginController implements Initializable {

    @FXML
    private TextField texto;
    
    @FXML
    void cancelar() {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Informação");
        alerta.setHeaderText("Cancelar");
        alerta.setContentText("Você cancelou a operação");
        alerta.show();
        texto.setText("Cancelou a operação");
    }

    @FXML
    void confirmar() {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Informação");
        alerta.setHeaderText("Confirmar");
        alerta.setContentText("Você confirmou a operação");
        alerta.show();
        texto.setText("Confirmou a operação");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
