package controler;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class FXMLPrincipalController implements Initializable {

    @FXML
    private AnchorPane anchorPane;

    @FXML
    void abrirTelaCategorias() {

    }

    @FXML
    void abrirTelaClientes() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/telas/FXMLCadastroClientes.fxml"));
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
        }
    }

    @FXML
    void abrirTelaGraficos() {

    }

    @FXML
    void abrirTelaProdutos() {

    }

    @FXML
    void abrirTelaRelatorios() {

    }

    @FXML
    void abrirTelaVendas() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/telas/FXMLVendas.fxml"));
            AnchorPane page = (AnchorPane) loader.load();
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Tela de vendas");
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
    }

    @FXML
    void abrirConsulta() {

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    //Abrir tela uma dentro da outra
    /*try {
            AnchorPane e = (AnchorPane) FXMLLoader.load(getClass().getResource("/telas/FXMLCadastroClientes.fxml"));
            anchorPane.getChildren().setAll(e);
        } catch (IOException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Erro ao carregar tela");
            alert.setContentText(ex.getMessage());
            alert.show();
        }*/
}
