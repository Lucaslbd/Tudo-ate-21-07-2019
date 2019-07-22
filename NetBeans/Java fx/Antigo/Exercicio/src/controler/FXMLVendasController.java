package controler;

import dao.ClienteDao;
import domain.Cliente;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class FXMLVendasController implements Initializable {

    @FXML
    private TableView<?> tabela;

    @FXML
    private TableColumn<?, ?> colunaProduto;

    @FXML
    private TableColumn<?, ?> colunaQuantidade;

    @FXML
    private TableColumn<?, ?> colunaValor;

    @FXML
    private Label labelValorTotal;

    @FXML
    private ComboBox<?> comboProduto;

    @FXML
    private TextField txtQuantidade;

    @FXML
    private ComboBox<Cliente> comboCliente;

    @FXML
    void adicionar() {

    }

    @FXML
    void alterar() {

    }

    @FXML
    void cancelar() {

    }

    @FXML
    void finalizar() {

    }

    @FXML
    void remover() {

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        colunaProduto.setResizable(false);
        colunaQuantidade.setResizable(false);
        colunaValor.setResizable(false);
        comboProduto.requestFocus();
        preencherCliente();
    }

    private void preencherCliente() {
        ClienteDao dao = new ClienteDao();
        try {
            ArrayList<Cliente> lista = dao.Listar();
            ObservableList<Cliente> obsCategoria = FXCollections.observableArrayList(lista);
            comboCliente.setItems(obsCategoria);  
        } catch (SQLException ex) {
            Logger.getLogger(FXMLVendasController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
