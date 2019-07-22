package br.com.elementos.controller;

import br.com.elementos.dao.ClienteDao;
import br.com.elementos.domain.Cliente;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class CadastroClienteController implements Initializable {

    @FXML
    private TableView<Cliente> tabela;

    @FXML
    private TableColumn<Cliente, String> colunaNome;

    @FXML
    private TableColumn<Cliente, String> colunaEstado;

    @FXML
    private TableColumn<Cliente, String> colunaCidade;

    @FXML
    private TableColumn<Cliente, String> colunaBairro;

    private ObservableList<Cliente> obslista;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        colunaNome.setResizable(false);
        colunaNome.setSortable(false);
        colunaNome.setEditable(false);
        colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colunaEstado.setResizable(false);
        colunaEstado.setSortable(false);
        colunaEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));
        colunaCidade.setResizable(false);
        colunaCidade.setSortable(false);
        colunaCidade.setCellValueFactory(new PropertyValueFactory<>("cidade"));
        colunaBairro.setResizable(false);
        colunaBairro.setSortable(false);
        colunaBairro.setCellValueFactory(new PropertyValueFactory<>("bairro"));
        tabela.setCache(false);
        tabela.setCacheShape(false);
        tabela.setCenterShape(false);
        tabela.setDisable(false);
        tabela.setEditable(false);
        tabela.setFixedCellSize(0);
        tabela.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY); //deixa toas as tabelas do mesmo tamanho
        tabela.setFixedCellSize(TableView.BASELINE_OFFSET_SAME_AS_HEIGHT);        
        iniciarTabela();
    }

    @FXML
    void pegarObj(MouseEvent event) {
        Cliente cliente = tabela.getSelectionModel().getSelectedItem();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);       
        alert.setContentText(cliente.toString());
        alert.show();
    }

    public void iniciarTabela() {
        ClienteDao dao = new ClienteDao();
        try {
            obslista = FXCollections.observableArrayList(dao.listar());
            tabela.setItems(obslista);
        } catch (SQLException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Erro ao listar clientes");
            alert.setContentText(ex.getMessage());
            alert.show();
        }
    }

}
