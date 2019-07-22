package ComboBox;

import Domain.Pessoa;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class FXMLDocumentController implements Initializable {

    @FXML
    private Button inserir;

    @FXML
    private Button remover;

    @FXML
    private TextField nome;

    @FXML
    private TextField profissao;

    @FXML
    private ComboBox<Pessoa> combo;
    ArrayList<Pessoa> lista = new ArrayList<>();
    ObservableList<Pessoa> obsCategoria;

    @FXML
    private ListView<Pessoa> listView;
    ArrayList<Pessoa> listaa = new ArrayList<>();
    ObservableList<Pessoa> obsListaView;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    void inserir() {
        if (nome.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Informação");
            alert.setHeaderText("Operação não autorizada");
            alert.setContentText("Preencha o campo nome");
            alert.show();
            nome.requestFocus();
        } else if (profissao.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Informação");
            alert.setHeaderText("Operação não autorizada");
            alert.setContentText("Preencha o campo profissão");
            alert.show();
            profissao.requestFocus();
        } else {
            Pessoa pessoa = new Pessoa();
            pessoa.setNome(nome.getText());
            pessoa.setProfissao(profissao.getText());
            lista.add(pessoa);
            obsCategoria = FXCollections.observableArrayList(lista);
            combo.setItems(obsCategoria);
            nome.setText("");
            profissao.setText("");
        }
    }

    @FXML
    void remover() {
        if (combo.getSelectionModel().getSelectedItem() == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Informação");
            alert.setHeaderText("Operação não autorizada");
            alert.setContentText("Selecione uma pessoa para poder remover");
            alert.show();
        } else {
            int i = combo.getSelectionModel().getSelectedIndex();
            lista.remove(i);
            obsCategoria = FXCollections.observableArrayList(lista);
            combo.setItems(obsCategoria);
        }
    }

    @FXML
    void adiconarNaLista() {
        Pessoa pessoa = combo.getSelectionModel().getSelectedItem();
        if (pessoa == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Informação");
            alert.setHeaderText("Operação não autorizada");
            alert.setContentText("Selecione uma pessoa para poder adicionar na lista");
            alert.show();
        } else {
            listaa.add(pessoa);
            obsListaView = FXCollections.observableArrayList(listaa);
            listView.setItems(obsListaView);
        }
    }

    @FXML
    void removerLista() {
        int i = listView.getSelectionModel().getSelectedIndex();
        if (i == -1) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Informação");
            alert.setHeaderText("Operação não autorizada");
            alert.setContentText("Selecione uma pessoa para poder remover da lista");
            alert.show();
        } else {
            listaa.remove(i);
            obsListaView = FXCollections.observableArrayList(listaa);
            listView.setItems(obsListaView);
        }
    }
}
