package Vbox;

import Domain.Pessoa;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class FXMLCadastroClientesController implements Initializable {

    @FXML
    private TableView<Pessoa> tabela;

    @FXML
    private TableColumn<Pessoa, String> ColunaNome;

    @FXML
    private TableColumn<Pessoa, String> ColunaProfissao;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtProfissao;

    ArrayList<Pessoa> lista = new ArrayList<>();
    ObservableList<Pessoa> obsListaView;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    void adicionar() {
        if (txtNome.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Informação");
            alert.setHeaderText("Operação não autorizada");
            alert.setContentText("Preencha o campo nome");
            alert.show();
            txtNome.requestFocus();
        } else if (txtProfissao.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Informação");
            alert.setHeaderText("Operação não autorizada");
            alert.setContentText("Preencha o campo profissão");
            alert.show();
            txtProfissao.requestFocus();
        } else {
            ColunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
            ColunaProfissao.setCellValueFactory(new PropertyValueFactory<>("profissao"));
            Pessoa pessoa = new Pessoa();
            pessoa.setNome(txtNome.getText());
            pessoa.setProfissao(txtProfissao.getText());
            lista.add(pessoa);
            obsListaView = FXCollections.observableArrayList(lista);
            tabela.setItems(obsListaView);
            txtNome.setText("");
            txtProfissao.setText("");
        }
    }

    @FXML
    void alterar() {
        int i = tabela.getSelectionModel().getSelectedIndex();
        if (i < 0) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Informação");
            alert.setHeaderText("Operação não autorizada");
            alert.setContentText("Selecione uma pessoa");
            alert.show();
        } else if (txtNome.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Informação");
            alert.setHeaderText("Operação não autorizada");
            alert.setContentText("Preencha o campo nome");
            alert.show();
            txtNome.requestFocus();
        } else if (txtProfissao.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Informação");
            alert.setHeaderText("Operação não autorizada");
            alert.setContentText("Preencha o campo profissão");
            alert.show();
            txtProfissao.requestFocus();
        } else {
            Pessoa pessoa = new Pessoa();
            pessoa.setNome(txtNome.getText());
            pessoa.setProfissao(txtProfissao.getText());
            lista.set(i, pessoa);
            obsListaView = FXCollections.observableArrayList(lista);
            tabela.setItems(obsListaView);
            txtNome.setText("");
            txtProfissao.setText("");
        }
    }

    @FXML
    void remover() {
        int i = tabela.getSelectionModel().getSelectedIndex();
        if (i < 0) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Informação");
            alert.setHeaderText("Operação não autorizada");
            alert.setContentText("Selecione uma pessoa");
            alert.show();
        } else {
            lista.remove(i);
            obsListaView = FXCollections.observableArrayList(lista);
            tabela.setItems(obsListaView);
            txtNome.setText("");
            txtProfissao.setText("");
        }
    }

    @FXML
    void selecionar() {
        Pessoa pessoa = tabela.getSelectionModel().getSelectedItem();
        if (pessoa != null) {
            txtNome.setText(pessoa.getNome());
            txtProfissao.setText(pessoa.getProfissao());
        }
    }
}
