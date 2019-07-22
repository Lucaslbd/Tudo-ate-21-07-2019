package br.com.elementos.controller;

import br.com.elementos.fxml.Main;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class LoginController implements Initializable {

    @FXML
    private TextField email;

    @FXML
    private PasswordField senha;

    @FXML
    void entrar() {
        if (email.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Informação");
            alert.setHeaderText("O campo e-mail está vazio");
            alert.setContentText("Preencha o campo e-mail");
            alert.show();
        } else if (senha.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Informação");
            alert.setHeaderText("O campo senha está vazio");
            alert.setContentText("Preencha o campo senha");
            alert.show();
        } else {
            if (email.getText().equals("lucasbertoldidias@gmail.com") && senha.getText().equals("1234")) {
                try {
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(Main.class.getResource("Principal.fxml"));
                    VBox page = (VBox) loader.load();
                    Stage dialogStage = new Stage();
                    dialogStage.setTitle("Cadastro de clientes");
                    dialogStage.setResizable(false);
                    Scene scene = new Scene(page);
                    dialogStage.setScene(scene);
                    dialogStage.initModality(Modality.APPLICATION_MODAL);
                    dialogStage.show();                    
                } catch (IOException ex) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Erro");
                    alert.setHeaderText("Erro ao cerrgar pagina");
                    alert.setContentText(ex.getMessage());
                    alert.show();
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Informação");
                alert.setHeaderText("Campo e-mail ou senha invalidos");
                alert.setContentText("Digite o login corretamente");
                alert.show();
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
