package br.com.elementos.controller;

import br.com.elementos.fxml.Main;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;

public class PrincipalController implements Initializable {

    @FXML
    private AnchorPane anchorPane;
    
    @FXML
    void abrirTelaCliente() {
       try {
            AnchorPane e = (AnchorPane) FXMLLoader.load(Main.class.getResource("CadastroCliente.fxml"));
            anchorPane.getChildren().setAll(e);
        } catch (IOException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Erro ao carregar tela");
            alert.setContentText(ex.getMessage());
            alert.show();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
/*try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("CadastroCliente.fxml"));
            AnchorPane page = (AnchorPane) loader.load();
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
        }*/